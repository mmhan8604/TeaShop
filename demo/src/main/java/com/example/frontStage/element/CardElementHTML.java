package com.example.frontStage.element;

import java.util.LinkedList;

public class CardElementHTML {
	private String headerText1;
	private String headerText2;
	private String backroundColor;
	private String backroundImg;
	
	private String cardBackround;
	private String cardTitleColor;
	private String cardTextColor;
	
	private LinkedList<String> cardTitle;
	private LinkedList<String> cardImg;
	private LinkedList<String> cardImgTop;
	private LinkedList<String> cardText;
	
//	private String backImg;
//	private String textHead;
//	private String textBody;
	
	private String cardElement;
//	private String cardElement02;
//	private String cardElement03;
//	private String cardElement04;
//	private String cardElement05;
//	private String cardElement06;
//	private String cardElement07;
	
	public CardElementHTML(int type,String backroundColor,String backroundImg,String headerText1,String headerText2,String cardBackround,String cardTitleColor, String cardTextColor,LinkedList<String> cardTitle,LinkedList<String> cardImg,LinkedList<String> cardText) {
		this.backroundColor=backroundColor;
		this.backroundImg=backroundImg;
		this.headerText1=headerText1;
		this.headerText2=headerText2;
		this.cardBackround=cardBackround;
		this.cardTitleColor=cardTitleColor;
		this.cardTextColor=cardTextColor;
		this.cardTitle=cardTitle;
		this.cardText=cardText;
		switch (type) {
		case 1: {
			this.cardImg=cardImg;
			createCardElement01();
			break;
		}
		case 2:{
			cardImgTop=cardImg;
			createCardElement02();
			break;
		}
		case 3:{
			cardImgTop=cardImg;
			createCardElement03();
			break;
		}
		case 4:{
			this.cardImg=cardImg;
			createCardElement04();
			break;
			
		}
		case 5:{
			this.cardImg=cardImg;
			createCardElement05();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		
	
		
	}
	
//	public CardElementHTML(int type, String backImg,String textHead,String textBody) {
//		this.backImg=backImg;
//		this.textHead=textHead;
//		this.textBody=textBody;
//		
//		switch (type){
//		case 6: {
//			createCardElement06();
//			
//		}
//		case 7:{
//			createCardElement07();
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + type);
//		}
//		
//	}
	
	public String createCardElement01() {
		cardElement=String.format(" <div class=\"child\" style=\"display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;background-color: %s;background-image:%s \">\r\n"
				+ "        <h1 class=\"headerText1\">%s</h1>\r\n"
				+ "        <h2 class=\"headerText2\">%s</h2>\r\n"
				+ "    \r\n"
				+ "    \r\n"
				+ "        <div class=\"row\" >\r\n"
				+ "            <div class=\"col-12 col-lg-6 mb-3\" >\r\n"
				+ "                <div class=\"card\" style='background-color:%s'>\r\n"
				+ "                    <div class=\"card-body row g-0 card-1\">\r\n"
				+ "                        <div class=\"col-md-4\">\r\n"
				+ "                            <img class=\"cardImg\" src=\"%s\">\r\n"
				+ "                        </div>\r\n"
				+ "                        <div class=\"col-md-8\">\r\n"
				+ "                            <a href=\"#\">\r\n"
				+ "                                <h5 class=\"card-title\" style='color:%s'>%s</h5>\r\n"
				+ "                                <p class=\"card-text text-truncate\"style='color:%s'>%s</p>\r\n"
				+ "                            </a>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-12 col-lg-6 mb-3\">\r\n"
				+ "                <div class=\"card\"  style='background-color:%s'>\r\n"
				+ "                    <div class=\"card-body row g-0 card-2\">\r\n"
				+ "                        <div class=\"col-md-4\">\r\n"
				+ "                            <img class=\"cardImg\" src=\"%s\">\r\n"
				+ "                        </div>\r\n"
				+ "                        <div class=\"col-md-8\">\r\n"
				+ "                            <a href=\"#\">\r\n"
				+ "                                <h5 class=\"card-title\" style='color:%s'>%s</h5>\r\n"
				+ "                                <p class=\"card-text text-truncate\"style='color:%s'>%s</p>\r\n"
				+ "                            </a>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-12 col-lg-6 mb-3\" >\r\n"
				+ "                <div class=\"card\"  style='background-color:%s'>\r\n"
				+ "                    <div class=\"card-body row g-0 card-3\">\r\n"
				+ "                        <div class=\"col-md-4\">\r\n"
				+ "                            <img class=\"cardImg\" src=\"%s\">\r\n"
				+ "                        </div>\r\n"
				+ "                        <div class=\"col-md-8\">\r\n"
				+ "                            <a href=\"#\">\r\n"
				+ "                                <h5 class=\"card-title\" style='color:%s'>%s</h5>\r\n"
				+ "                                <p class=\"card-text text-truncate\"style='color:%s'>%s</p>\r\n"
				+ "                            </a>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-12 col-lg-6 mb-3\" >\r\n"
				+ "                <div class=\"card\"  style='background-color:%s'>\r\n"
				+ "                    <div class=\"card-body row g-0 card-4\">\r\n"
				+ "                        <div class=\"col-md-4\">\r\n"
				+ "                            <img class=\"cardImg\" src=\"%s\">\r\n"
				+ "                        </div>\r\n"
				+ "                        <div class=\"col-md-8\">\r\n"
				+ "                            <a href=\"#\">\r\n"
				+ "                                <h5 class=\"card-title\" style='color:%s'>%s</h5>\r\n"
				+ "                                <p class=\"card-text text-truncate\"style='color:%s'>%s</p>\r\n"
				+ "                            </a>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    \r\n"
				+ "    </div>",backroundColor,backroundImg,headerText1,headerText2,cardBackround,cardImg.get(0),cardTitleColor,cardTitle.get(0),cardTextColor,cardText.get(0),cardBackround,cardImg.get(1),cardTitleColor,cardTitle.get(1),cardTextColor,cardText.get(1),cardBackround,cardImg.get(2),cardTitleColor,cardTitle.get(2),cardTextColor,cardText.get(2),cardBackround,cardImg.get(3),cardTitleColor,cardTitle.get(3),cardTextColor,cardText.get(3));
				return cardElement;
	}
	
	public String createCardElement02() {
		cardElement= String.format("<div class='child' style='display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;background-color: %s;background-image:%s '>\r\n"
				+ "    <h1 class='headerText1'>%s</h1>\r\n"
				+ "    <h2 class='headerText2'>%s</h2>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <div class='row'>\r\n"
				+ "      <div class='col-12 col-lg-4 mb-3'>\r\n"
				+ "        <div class='card'  style='background-color:%s'>\r\n"
				+ "          <img src='%s' class='card-img-top p-3' style=' height: 65%; object-fit: contain;'>\r\n"
				+ "          <div class='card-body card-1'>\r\n"
				+ "            <a href='#'>\r\n"
				+ "              <h5 class='card-title' style='color:%s'>%s</h5>\r\n"
				+ "              <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "            </a>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-12 col-lg-4 mb-3'>\r\n"
				+ "        <div class='card'  style='background-color:%s'>\r\n"
				+ "          <img src='%s' class='card-img-top p-3' style=' height: 65%; object-fit: contain;'>\r\n"
				+ "          <div class='card-body card-2'>\r\n"
				+ "            <a href='#'>\r\n"
				+ "              <h5 class='card-title'style='color:%s'>%s</h5>\r\n"
				+ "              <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "            </a>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-12 col-lg-4 mb-3'>\r\n"
				+ "        <div class='card'  style='background-color:%s'>\r\n"
				+ "          <img src='%s' class='card-img-top p-3' style=' height: 65%; object-fit: contain;'>\r\n"
				+ "          <div class='card-body card-3'>\r\n"
				+ "            <a href='#'>\r\n"
				+ "              <h5 class='card-title'style='color:%s'>%s</h5>\r\n"
				+ "              <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "            </a>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "  </div>",backroundColor,backroundImg,headerText1,headerText2,cardBackround,cardImg.get(0),cardTitleColor,cardTitle.get(0),cardTextColor,cardText.get(0),cardBackround,cardImg.get(1),cardTitleColor,cardTitle.get(1),cardTextColor,cardText.get(1),cardBackround,cardImg.get(2),cardTitleColor,cardTitle.get(2),cardTextColor,cardText.get(2));
		return cardElement;
	}
	
	public String createCardElement03() {
		cardElement=String.format("<div class='child' style='display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;background-color: %s;background-image:%s '>\r\n"
				+ "    <h1 class='headerText1'>%s</h1>\r\n"
				+ "    <h2 class='headerText2'>%s</h2>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <div class='row'>\r\n"
				+ "      <div class='col-12 col-lg-4 mb-3'>\r\n"
				+ "        <div class='card' style='width: 80%; margin: 0 auto;background-color:%s'>\r\n"
				+ "          <img src='.%s' class='card-img-top p-3' style='height:65%; object-fit:cover;'>\r\n"
				+ "          <div class='card-body card-1'style='color:%s'>\r\n"
				+ "            <a href='#'>\r\n"
				+ "              <h5 class='card-title'>%s</h5>\r\n"
				+ "              <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "            </a>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-12 col-lg-4 mb-3'>\r\n"
				+ "        <div class='card' style='width: 80%; margin: 0 auto;background-color:%s'>\r\n"
				+ "          <img src='%s' class='card-img-top p-3' style='height:65%; object-fit:cover;'>\r\n"
				+ "          <div class='card-body card-2'>\r\n"
				+ "            <a href='#'>\r\n"
				+ "              <h5 class='card-title'style='color:%s'>%s</h5>\r\n"
				+ "              <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "            </a>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-12 col-lg-4 mb-3'>\r\n"
				+ "        <div class='card' style='width: 80%; margin: 0 auto;background-color:%s'>\r\n"
				+ "          <img src='%s' class='card-img-top p-3' style='height:65%; object-fit:cover;'>\r\n"
				+ "          <div class='card-body card-3'>\r\n"
				+ "            <a href='#'>\r\n"
				+ "              <h5 class='card-title'style='color:%s'>%s</h5>\r\n"
				+ "              <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "            </a>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "  </div>",backroundColor,backroundImg,headerText1,headerText2,cardBackround,cardImg.get(0),cardTitleColor,cardTitle.get(0),cardTextColor,cardText.get(0),cardBackround,cardImg.get(1),cardTitleColor,cardTitle.get(1),cardTextColor,cardText.get(1),cardBackround,cardImg.get(2),cardTitleColor,cardTitle.get(2),cardTextColor,cardText.get(2));
		return cardElement;
	}
	
	public String createCardElement04() {
		cardElement=String.format("<div class='child'\r\n"
				+ "    style='display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;background-color: %s;background-image:%s '>\r\n"
				+ "    <h1 class='headerText1'>%s</h1>\r\n"
				+ "    <h2 class='headerText2'>%s</h2>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <div class='row' style='justify-content: center;'>\r\n"
				+ "      <div class='col-8 mb-3' >\r\n"
				+ "        <div class='card'  style='background-color:%s>\r\n"
				+ "          <div class='card-body row g-0 card-1'>\r\n"
				+ "            <div class='col-4'>\r\n"
				+ "              <img class='cardImg' src='%s'>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='col-8'>\r\n"
				+ "              <a href='#'>\r\n"
				+ "                <h5 class='card-title'style='color:%s'>%s</h5>\r\n"
				+ "                <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "              </a>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-8 mb-3'>\r\n"
				+ "        <div class='card'  style='background-color:%s>'\r\n"
				+ "          <div class='card-body row g-0 card-2'>\r\n"
				+ "            <div class='col-4'>\r\n"
				+ "              <img class='cardImg' src='%s'>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='col-8'>\r\n"
				+ "              <a href='#'>\r\n"
				+ "                <h5 class='card-title'style='color:%s'>%s</h5>\r\n"
				+ "                <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "              </a>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "  </div>",backroundColor,backroundImg,headerText1,headerText2,cardBackround,cardImg.get(0),cardTitleColor,cardTitle.get(0),cardTextColor,cardText.get(0),cardBackround,cardImg.get(1),cardTitleColor,cardTitle.get(1),cardTextColor,cardText.get(1) );
		return cardElement;
		
	}
	public String createCardElement05() {
		cardElement=String.format(" <div class='child' style='display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;background-color: %s;background-image:%s '>\r\n"
				+ "    <h1 class='headerText1'>%s</h1>\r\n"
				+ "    <h2 class='headerText2'>%s</h2>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <div class='row' style='justify-content: center;'>\r\n"
				+ "      <div class='col-8 mb-3' >\r\n"
				+ "        <div class='card' style='background-color:%s>\r\n"
				+ "          <div class='card-body row g-0 card-1'>\r\n"
				+ "            <div class='col-8'>\r\n"
				+ "              <a href='#'>\r\n"
				+ "                <h5 class='card-title'>%s</h5>\r\n"
				+ "                <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "              </a>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='col-4'>\r\n"
				+ "              <img class='cardImg' src='%s'>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-8 mb-3'>\r\n"
				+ "        <div class='card' style='background-color:%s>\r\n"
				+ "          <div class='card-body row g-0 card-2'>\r\n"
				+ "            <div class='col-8'>\r\n"
				+ "              <a href='https://www.google.com/'>\r\n"
				+ "                <h5 class='card-title'>%s</h5>\r\n"
				+ "                <p class='card-text text-truncate'style='color:%s'>%s</p>\r\n"
				+ "              </a>\r\n"
				+ "            </div>\r\n"
				+ "            <div class='col-4'>\r\n"
				+ "              <img class='cardImg ' src='%s'>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  </div>",backroundColor,backroundImg,headerText1,headerText2,cardBackround,cardImg.get(0),cardTitleColor,cardTitle.get(0),cardTextColor,cardText.get(0),cardBackround,cardImg.get(1),cardTitleColor,cardTitle.get(1),cardTextColor,cardText.get(1) );
		return cardElement;
	}
//	public String createCardElement06() {
//		cardElement06=String.format(" <div class='child' style='display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;background-color: %s;background-image:%s '>\r\n"
//				+ "\r\n"
//				+ "    <div id='backDiv'>\r\n"
//				+ "        <img id='backImg' src='%s' alt='背景圖片'>\r\n"
//				+ "        <div class=row>\r\n"
//				+ "\r\n"
//				+ "            <div class='col-2 col-sm-0'></div>\r\n"
//				+ "\r\n"
//				+ "            <div class='col-6 col-sm-12' id='textDiv'>\r\n"
//				+ "                <div id='textLeft'>\r\n"
//				+ "                    <h1 id='textHead'>%s</h1>\r\n"
//				+ "                    <h4 id='textBody'>%s</h4>\r\n"
//				+ "                    <button type='submit' class='btn btn-secondary' id='button'>按鈕</button>\r\n"
//				+ "                </div>\r\n"
//				+ "            </div>\r\n"
//				+ "\r\n"
//				+ "            <div class='col-2 col-sm-0'></div>\r\n"
//				+ "            <div class='col-2 col-sm-0'></div>\r\n"
//				+ "\r\n"
//				+ "        </div>\r\n"
//				+ "    </div>\r\n"
//				+ "</div>",backImg,textHead,textBody );
//		return cardElement06;
//	
//	}
//	public String createCardElement07() {
//		cardElement07=String.format("<div class='child' style='display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%;padding: 3%;background-color: %s;background-image:%s '>\r\n"
//				+ "\r\n"
//				+ "    <div id='backDiv'>\r\n"
//				+ "        <img id='backImg' src='%s' alt='背景圖片'>\r\n"
//				+ "        <div class=row>\r\n"
//				+ "\r\n"
//				+ "            <div class='col-2 col-sm-0'></div>\r\n"
//				+ "\r\n"
//				+ "            <div class='col-6 col-sm-12' id='textDiv'>\r\n"
//				+ "                <div id='textCenter'>\r\n"
//				+ "                    <h1 id='textHead'>%s</h1>\r\n"
//				+ "                    <h4 id='textBody'>%s</h4>\r\n"
//				+ "                    <button type='submit' class='btn btn-secondary' id='button'>按鈕</button>\r\n"
//				+ "                </div>\r\n"
//				+ "            </div>\r\n"
//				+ "\r\n"
//				+ "            <div class='col-2 col-sm-0'></div>\r\n"
//				+ "            <div class='col-2 col-sm-0'></div>\r\n"
//				+ "\r\n"
//				+ "        </div>\r\n"
//				+ "    </div>\r\n"
//				+ "\r\n"
//				+ "</div>",backImg,textHead,textBody );
//		return cardElement07;
//		
//	}

//	public String getTextHead() {
//		return textHead;
//	}
//
//	public void setTextHead(String textHead) {
//		this.textHead = textHead;
//	}
//
//	public String getTextBody() {
//		return textBody;
//	}
//
//	public void setTextBody(String textBody) {
//		this.textBody = textBody;
//	}

	

	public String getHeaderText1() {
		return headerText1;
	}

	public void setHeaderText1(String headerText1) {
		this.headerText1 = headerText1;
	}

	public String getHeaderText2() {
		return headerText2;
	}

	public void setHeaderText2(String headerText2) {
		this.headerText2 = headerText2;
	}

	public LinkedList<String> getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(LinkedList<String> cardTitle) {
		this.cardTitle = cardTitle;
	}

	public LinkedList<String> getCardImg() {
		return cardImg;
	}

	public void setCardImg(LinkedList<String> cardImg) {
		this.cardImg = cardImg;
	}

	public LinkedList<String> getCardImgTop() {
		return cardImgTop;
	}

	public void setCardImgTop(LinkedList<String> cardImgTop) {
		this.cardImgTop = cardImgTop;
	}

	public LinkedList<String> getCardText() {
		return cardText;
	}

	public void setCardText(LinkedList<String> cardText) {
		this.cardText = cardText;
	}

	public String getCardElement() {
		return cardElement;
	}

	
}

	
