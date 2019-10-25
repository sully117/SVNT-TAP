from flask import Flask, render_template, request, jsonify, json
from pytube import YouTube
import urllib.request
import urllib.parse as urlparse
import csv

#Youtube API key
api_key = "AIzaSyD05BlpDfXbC4JFtVkg4wtD0PxXbLxVq1I"

class Helper:
    def __init__(self):
        pass

    # select the video id from the url
    def get_video_id(self, url: str):
        url_data = urlparse.urlparse(url)
        query = urlparse.parse_qs(url_data.query)
        video_id = query["v"][0]
        return video_id

class YouTubeStats:

    # Get the JSON to this request, and store the result of that JSON in this data variable
    def __init__(self, url: str):
        self.json_url = urllib.request.urlopen(url)
        self.data = json.loads(self.json_url.read())
    def print_data(self):
        print(self.data)
    def get_video_publishdate(self):
        return self.data["items"][0]["snippet"]["publishedAt"]
    def get_video_channel_id(self):
        return self.data["items"][0]["snippet"]["channelId"]
    def get_video_channel_title(self):
        return self.data["items"][0]["snippet"]["channelTitle"]
    def get_video_category_id(self):
        return self.data["items"][0]["snippet"]["categoryId"]
    def get_video_tags(self):
        return self.data["items"][0]["snippet"]["tags"]
    def get_video_title(self):
        return self.data["items"][0]["snippet"]["title"]
    def get_video_view_count(self):
        return self.data["items"][0]["statistics"]["viewCount"]
    def get_video_like_count(self):
        return self.data["items"][0]["statistics"]["likeCount"]
    def get_video_dislike_count(self):
        return self.data["items"][0]["statistics"]["dislikeCount"]
    def get_video_favorite_count(self):
        return self.data["items"][0]["statistics"]["favoriteCount"]
    def get_video_comment_count(self):
        return self.data["items"][0]["statistics"]["commentCount"]

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/', methods=['POST'])
def get_video_url():
    global youtube_url

    # get data from home page to python file
    youtube_url = request.form['youtube_url']

    helper = Helper()
    video_id = helper.get_video_id(youtube_url)

    api_url = f"https://www.googleapis.com/youtube/v3/videos?id={video_id}&key={api_key}&part=snippet,contentDetails,statistics,status"
    # Interact with the google api console and get the json data, then get the relevant pieces of information that
    # data scientist needs
    yt_stats = YouTubeStats(api_url)

    title = yt_stats.get_video_title()
    publish_date = yt_stats.get_video_publishdate()
    channel_id = yt_stats.get_video_channel_id()
    channel_title = yt_stats.get_video_channel_title()
    category_id = yt_stats.get_video_category_id()
    tags = yt_stats.get_video_tags()
    view_count = yt_stats.get_video_view_count()
    like_count = yt_stats.get_video_like_count()
    dislike_count = yt_stats.get_video_dislike_count()
    favorite_count = yt_stats.get_video_favorite_count()
    comment_count = yt_stats.get_video_comment_count()

    with open('data.csv', 'w', newline='') as csvfile:
        fieldnames = ['title', 'publish_date', 'channel_id', 'channel_title', 'category_id', 'tags', 'view_count',
                      'like_count', 'dislike_count', 'favorite_count', 'comment_count']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writerow(
            {'title': title, 'publish_date': publish_date, 'channel_id': channel_id, 'channel_title': channel_title,
             'category_id': category_id, 'tags': tags, 'view_count': view_count, 'like_count': like_count,
             'dislike_count': dislike_count, 'favorite_count': favorite_count, 'comment_count': comment_count})

    return render_template('processing.html', message = 'Thank you for your input, we are calculating your video result')

# pass the result back to the frontend
@app.route('/result')
def display_result():
    # It will call the functions that developed by the data scientist, and return the calculated result
    result = 250000
    return render_template('result.html', res = result)


if __name__ == "__main__":
    app.run(debug=True)

