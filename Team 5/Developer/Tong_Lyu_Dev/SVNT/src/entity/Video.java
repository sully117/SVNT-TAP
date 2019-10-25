package entity;

import java.util.List;

public class Video {
	private String videoId;
	private String title;
	private String categoryId;
	private String publishTime;
	private List<String> tags;
	private int views;
	private int likes;
	private int dislikes;
	private int commentCount;
	private String link;
	private String description;
	

	public String getVideoId() {
		return videoId;
	}


	public String getTitle() {
		return title;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public String getPublishTime() {
		return publishTime;
	}


	public List<String> getTags() {
		return tags;
	}


	public int getViews() {
		return views;
	}


	public int getLikes() {
		return likes;
	}


	public int getDislikes() {
		return dislikes;
	}


	public int getCommentCount() {
		return commentCount;
	}


	public String getThumbnail_link() {
		return link;
	}


	public String getDescription() {
		return description;
	}

	public static class VideoBuilder {
		private String videoId;
		private String title;
		private String categoryId;
		private String publishTime;
		private List<String> tags;
		private int views;
		private int likes;
		private int dislikes;
		private int commentCount;
		private String link;
		private String description;
		public void setVideoId(String videoId) {
			this.videoId = videoId;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}
		public void setPublishTime(String publishTime) {
			this.publishTime = publishTime;
		}
		public void setTags(List<String> tags) {
			this.tags = tags;
		}
		public void setViews(int views) {
			this.views = views;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		public void setDislikes(int dislikes) {
			this.dislikes = dislikes;
		}
		public void setCommentCount(int commentCount) {
			this.commentCount = commentCount;
		}
		public void setThumbnail_link(String thumbnail_link) {
			this.link = thumbnail_link;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public Video build() {
			return new Video(this);
		}
		
	}
	
	private Video(VideoBuilder builder) {
		this.videoId = builder.videoId;
				this.title = builder.title;
				this.categoryId = builder.categoryId;
				this.publishTime = builder.publishTime;
				this.tags = builder.tags;
				this.views = builder.views;
				this.likes = builder.likes;
				this.dislikes = builder.dislikes;
				this.commentCount = builder.commentCount;
				this.link = builder.link;
				this.description = builder.description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((videoId == null) ? 0 : videoId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (videoId == null) {
			if (other.videoId != null)
				return false;
		} else if (!videoId.equals(other.videoId))
			return false;
		return true;
	}
}
