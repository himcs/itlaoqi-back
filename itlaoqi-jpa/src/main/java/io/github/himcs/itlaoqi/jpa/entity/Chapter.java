package io.github.himcs.itlaoqi.jpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "chapter")
@Data
public class Chapter implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  /**
   * 目录id
   */
  @Column(name = "cid", nullable = false)
  private Integer cid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "url", nullable = false)
  private String url;

  @Column(name = "sort")
  private Integer sort;

  /**
   * 时长
   */
  @Column(name = "time")
  private Integer time;

  /**
   * 视频地址
   */
  @Column(name = "video_url")
  private String videoUrl;

  /**
   * 图片
   */
  @Column(name = "img")
  private String img;

}
