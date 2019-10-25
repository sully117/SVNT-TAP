package com.rating.youtube_rating.model;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;


@Entity
@Table(name="rating")
public class Rating{
    // Type id
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name="Total_Views")
    private Double total_views;

    @Basic
    @Column(name="Peak_Video_Name")
    private String peak_video_name;

    @Basic
    @Column(name="Topic_Name")
    private String topic_name;

    @Basic
    @Column(name="Num_video")
    private Integer video_num;

    @Basic
    @Column(name="Num_comments")
    private Integer comment_num;

    public Long GetId(){
        return this.id;
    }
    public void SetId(Long id){
        this.id=id;
    }

    public String GetPeakVideoName(){
        return this.peak_video_name;
    }
    public void SetPeakVideoName(String peak_video_name){
        this.peak_video_name=peak_video_name;
    }

    public Double GetTotalViews(){
        return this.total_views;
    }
    public void SetTotalViews(Double total_views){
        this.total_views=total_views;
    }

    public String GetTopicName(){
        return this.topic_name;
    }
    public void SetTopicName(String topic_name){
        this.topic_name=topic_name;
    }

    public Integer GetVideoNum(){
        return this.video_num;
    }
    public void SetVideoNum(Integer video_num){
        this.video_num=video_num;
    }

    public Integer GetCommentNum(){
        return this.comment_num;
    }

    public void SetCommentNum(Integer comment_num){
        this.comment_num=comment_num;
    }
    public Rating(){}

}
