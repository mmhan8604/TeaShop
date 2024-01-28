package com.example.frontStage.element;

public class VideoElementHTML {
	
	private String youtubeUrl;
	private String headerText1;
	private String backroundColor;
	private String backroundImg;
	private String videoElement;
	
	public VideoElementHTML(String youtubeUrl, String headerText1, String backroundColor, String backroundImg) {
		super();
		this.youtubeUrl = youtubeUrl;
		this.headerText1 = headerText1;
		this.backroundColor = backroundColor;
		this.backroundImg = backroundImg;
		createVideoElement();
	}
	
	public String createVideoElement() {
		
		videoElement=String.format("<div class='child' style='background-color:%s ;background-image: %s; display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;'>\r\n"
				+ "      <h1 class='headerText1' >%s</h1>\r\n"
				+ "      \r\n"
				+ "      <div class='ratio ratio-16x9'>\r\n"
				+ "          <iframe style='width: 560px;height: 315px;' width='560' height='315' src='%s'\r\n"
				+ "              title='YouTube video player' frameborder='0'\r\n"
				+ "              allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share'\r\n"
				+ "              allowfullscreen></iframe>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "  </div>\r\n"
				+ "", backroundColor,backroundImg, headerText1,youtubeUrl);
		
		return videoElement;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public String getHeaderText1() {
		return headerText1;
	}

	public void setHeaderText1(String headerText1) {
		this.headerText1 = headerText1;
	}

	public String getBackroundColor() {
		return backroundColor;
	}

	public void setBackroundColor(String backroundColor) {
		this.backroundColor = backroundColor;
	}

	public String getBackroundImg() {
		return backroundImg;
	}

	public void setBackroundImg(String backroundImg) {
		this.backroundImg = backroundImg;
	}

	public String getVideoElement() {
		return videoElement;
	}

}
