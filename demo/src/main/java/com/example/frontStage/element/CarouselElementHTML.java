package com.example.frontStage.element;

import java.util.List;

public class CarouselElementHTML {
	List<String>carouselImg;
	String carouselElement;
	
	public CarouselElementHTML(List<String>carouselImg) {
		this.carouselImg=carouselImg;
		createCarouselElement(carouselImg);
	}
	
	public String createCarouselElement(List<String>carouselImg) {
		carouselElement=String.format(" <!-- ****這邊開始複製 --------------------->\r\n"
				+ " <div class='child' style='display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "    <div id='myCarousel' class='carousel slide' data-bs-ride='carousel' data-bs-interval='2000'>\r\n"
				+ "        <!-- 下方指標 -->\r\n"
				+ "        <div class='carousel-indicators'>\r\n"
				+ "            <button type='button' data-bs-target='#myCarousel' data-bs-slide-to='0' class='active'\r\n"
				+ "                aria-current='true' aria-label='Slide 1'></button>\r\n"
				+ "            <button type='button' data-bs-target='#myCarousel' data-bs-slide-to='1' aria-label='Slide 2'></button>\r\n"
				+ "            <button type='button' data-bs-target='#myCarousel' data-bs-slide-to='2' aria-label='Slide 3'></button>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div class='carousel-inner'>\r\n"
				+ "            <div class='carousel-item active'>\r\n"
				+ "                <!-- 插入圖片1 ---------------------->\r\n"
				+ "                <img src='%s' class='d-block w-auto' alt='茶葉1' style='height: 100%%;'>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='carousel-item'>\r\n"
				+ "                <!-- 插入圖片2 ---------------------->\r\n"
				+ "                <img src='%s' class='d-block w-auto' alt='茶葉2' style='height: 100%%;'>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='carousel-item'>\r\n"
				+ "                <!-- 插入圖片3 ---------------------->\r\n"
				+ "                <img src='%s' class='d-block w-auto' alt='茶葉3' style='height: 100%%;'>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <!-- 左箭頭 -->\r\n"
				+ "        <button class='carousel-control-prev' type='button' data-bs-target='#myCarousel' data-bs-slide='prev'>\r\n"
				+ "            <span class='carousel-control-prev-icon' aria-hidden='true'></span>\r\n"
				+ "            <span class='visually-hidden'>Previous</span>\r\n"
				+ "        </button>\r\n"
				+ "        <!-- 右箭頭 -->\r\n"
				+ "        <button class='carousel-control-next' type='button' data-bs-target='#myCarousel' data-bs-slide='next'>\r\n"
				+ "            <span class='carousel-control-next-icon' aria-hidden='true'></span>\r\n"
				+ "            <span class='visually-hidden'>Next</span>\r\n"
				+ "        </button>\r\n"
				+ "    </div>\r\n"
				+ "</div>",carouselImg.get(0),carouselImg.get(1),carouselImg.get(2) );
		return carouselElement;
	}

	public List<String> getCarouselImg() {
		return carouselImg;
	}

	public void setCarouselImg(List<String> carouselImg) {
		this.carouselImg = carouselImg;
	}

	public String getCarouselElement() {
		return carouselElement;
	}
	
	
	
}
