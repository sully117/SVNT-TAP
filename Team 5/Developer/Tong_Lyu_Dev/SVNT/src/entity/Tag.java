package entity;

import entity.Video.VideoBuilder;

public class Tag {
	private String tag;
	private int views;
	private int likes;
	private int dislikes;
	public String getTag() {
		return tag;
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
	
	public static class TagBuilder {
		private String tag;
		private int views;
		private int likes;
		private int dislikes;
		public void setTag(String tag) {
			this.tag = tag;
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
		
		public Tag build() {
			return new Tag(this);
		}
	}
	
	private Tag(TagBuilder builder) {
		this.tag = builder.tag;
		this.views = builder.views;
		this.likes = builder.likes;
		this.dislikes = builder.dislikes;
	}
}
