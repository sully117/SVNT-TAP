DROP DATABASE IF EXISTS youtube;

CREATE DATABASE youtube;

\c youtube;


CREATE TABLE youtube (
  video_id varchar(50) PRIMARY key,
  trending_date varchar(50),
  title varchar(100),
  channel_title varchar(50),
  category_id INT,
  publish_time TIMESTAMP,
  tags text,
  views INT,
  likes INT,
  dislikes INT,
  comment_count INT,
  thumbnail_link varchar(100),
  comments_disabled boolean,
  ratings_disabled boolean,
  video_error_or_removed boolean,
  description text
);

