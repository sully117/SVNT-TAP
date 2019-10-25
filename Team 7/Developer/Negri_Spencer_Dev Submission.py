import collections
import csv
import sys

#The idea behind this component is to create a user, set up their default attributes, and then
#generate a report for them based on how other YouTubers are doing with those topics
#the report befow is somewhat limited, but given more time a more specific report could be generated
#with a rating system regarding the users topics

#a class to keep track of who are users are and what attributes they want to make videos about
#each user will always have a set of defualt atrributes.
class User(object):
	def __init__(self, username, default_attributes, topics):
		self.username = username
		self.default_attributes = default_attributes
		self.topics = topics

	def getusername(self):
		return self.username

	def get_attributes(self):
		return self.default_attributes

	def get_topics(self):
		return self.topics

	def set_updated_topics(self, updated_topics):
		self.topics = updated_topics

	def calc_views_per_video(self, topic):
		topic_o = self.topics[topic]
		va = topic_o.get_videos_associated()
		if va != 0:
			average_views = float(topic_o.views_associated) / float(va)
		else:
			average_views = 0
		return average_views

	def create_user_report(self):
		user_attrs = self.default_attributes
		print "Generating user report for "  + self.username + "..."

		print "---------------------USER REPORT---------------------"
		for topic in self.topics.values():
			key_word = topic.get_keyword()
			print "------------------BEGIN {}------------------".format(key_word)
			va = topic.get_views_associated()
			likes = topic.get_likes()
			dislikes = topic.get_dislikes()
			average_views = self.calc_views_per_video(key_word)
			if dislikes != 0:
				ratio = float(likes)/float(dislikes)
			else:
				ratio = "No dislikes"

			print "Your topic {} produced a cumulative {} views, {} likes, and {} dislikes from other YouTubers".format(key_word, str(va), str(likes), str(dislikes))
			print "Topic like:dislike ratio: {}".format(str(ratio))
			print "Average views per topic: {}".format(str(average_views))
			print "------------------END {}------------------".format(key_word)


#this class is for our topics. Topics are essentially keywords with data attached to them such as likes, views, etc.
#we keep track of these topics to provide the user with the most up to date information regading the topics they are passionate about
#and want to make Youtube vidoes about			
class Topic(object):
	def __init__(self, keyword, frequency, likes, dislikes, views_associated, videos_associated):
		self.keyword = keyword
		self.frequency = frequency
		self.likes = likes
		self.dislikes = dislikes
		self.views_associated = views_associated
		self.videos_associated = videos_associated

	def get_keyword(self):
		return self.keyword

	def get_freq(self):
		return self.frequency

	def get_likes(self):
		return self.likes

	def get_dislikes(self):
		return self.dislikes

	def get_views_associated(self):
		return self.views_associated

	def get_videos_associated(self):
		return self.videos_associated

	def increase_attr(self, to_increase, increase):
		if to_increase == "f":
			self.frequency += increase
		elif to_increase == "l":
			self.likes += increase
		elif to_increase == "dl":
			self.dislikes += increase
		elif to_increase == "va":
			self.views_associated += increase
		elif to_increase == "v":
			self.videos_associated += increase


	def show_attrs(self):
		print "Keyword is: " + self.keyword
		print "Total likes: " + str(self.likes)
		print "Total dislikes: " + str(self.dislikes)
		print "Total views: " + str(self.views_associated)



class Video(Topic):
	def __init__(self, title, views, likes, dislikes):
		self.title = title
		self.views = views
		self.likes = likes
		self.dislikes = dislikes




#This function parses the csv file looking to set user attributes (see User Class)
def parse_CSV_for_defualt_attributes(file, attr_list):
	word_counts = {}
	topic_attributes = {}
	video_list = []

	topic_list = {} #our list of topics for this user
	for attr, freq in attr_list.items():
		new_topic = Topic(attr, freq, 0, 0, 0, 0)
		topic_list[attr] = new_topic

	with open(file) as csvfile:
	    readCSV = csv.reader(csvfile, delimiter=',')
	    for row in readCSV:
	    	keyword = ""
	    	frequency = 0
	    	likes = 0
	    	dislikes = 0
	    	views_associated = 0
	    	found = False
	    	temp = ""
	    	#row 15 contains the description, this loop will search the description looking for our users
	    	#default attributes
	    	for word in row[15].lower().split(' '): 
	    		if attr_list.get(word, None) is not None:
	    			found = True
	    			temp = word
	    			new_video = Video(row[1], row[8], row[9], row[10])
	    			video_list.append(new_video)
	    			attr_list[word] += 1
	    			topic_list[word].increase_attr('f', 1)
	    	#if this is true, we have found a video with our users attribute inside its description
	    	#in this case we want to increment the topic attributes to reflect what the current video is giving us
	    	if found == True:
	    		topic_list[temp].increase_attr('va', int(row[8])) #increase our cumulative views 
	    		topic_list[temp].increase_attr('l', int(row[9])) #increase cumulative likes
	    		topic_list[temp].increase_attr('dl', int(row[10])) #...
	    		topic_list[temp].increase_attr('v', 1)
	    		found = False

	#for topic in topic_list.values():
	#	topic.show_attrs()

	print attr_list
	return topic_list

#sets the attributes that the user will be starting with before making any videos
def access_attributes(file_path, user): 
	file = open(file_path, 'r')
	default_attribute_dict = {}

	for line in file:
		attrs = line.lower().split(',')
		for attr in attrs:
			default_attribute_dict[attr.strip()] = 1
	return default_attribute_dict


def main():
	csv_file = 'Trending-YouTube-Scraper/output/18.01.11_US_videos.csv' #hardcoded csv but in future should be script arguement
	Spencer = User("snegri", access_attributes('default_attributes.txt', "snegri"), None) #create test user Spencer with default attributes
	user_topics = parse_CSV_for_defualt_attributes(csv_file, Spencer.get_attributes()) #get data assocatied with our users default attributes
	Spencer.set_updated_topics(user_topics) #update with new data ^
	Spencer.create_user_report() #generate new user report! :)


if __name__ == '__main__':
	main()