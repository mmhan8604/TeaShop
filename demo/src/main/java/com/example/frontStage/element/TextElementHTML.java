package com.example.frontStage.element;

public class TextElementHTML {
	
	private String textHead;
	private String textBody;
	private String childBackroundImg;
	private String BackroundColor;
	private String textElement;
	
	public TextElementHTML(int type, String textHead, String textBody,String BackroundColor,String childBackroundImg) {
		super();
		this.textHead = textHead;
		this.textBody = textBody;
		this.BackroundColor=BackroundColor;
		this.childBackroundImg=childBackroundImg;
		
		if(type==1) {
			createTextElement01();
		}else if (type==2) {
			createTextElement02();
		}
	}
	
	

	public String createTextElement01() {
		
		textElement=String.format("<div class='child' style='background-image:%s ; display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "\r\n"
				+ "        <div class='backColor' style='background-color:%s ;'>\r\n"
				+ "            <div class='row'>\r\n"
				+ "\r\n"
				+ "                <div class='col-6 col-sm-12' >\r\n"
				+ "                    <div class='textLeft2'>\r\n"
				+ "                        <h1 class='textHead'>%s</h1>\r\n"
				+ "                        <h4 class='textBody'>%s</h4>\r\n"
				+ "                        <!-- <button type='submit' class='btn btn-secondary' id='button'>按鈕</button> -->\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "",childBackroundImg,BackroundColor,textHead,textBody );
		
		return  textElement;
	}
	
	public String createTextElement02() {
		
		textElement=String.format("<div class='child' style='background-image:%s ; display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "\r\n"
				+ "      <div class='backColor' style='background-color:%s ;'>\r\n"
				+ "        <div class=row>\r\n"
				+ "\r\n"
				+ "          <div class='col-6 col-sm-12' >\r\n"
				+ "            <div class='textLeft2' >\r\n"
				+ "              <h1 class='textHead' >%s</h1>\r\n"
				+ "              <h4 class='textBody'>%s</h4>\r\n"
				+ "              <!-- <button type='submit' class='btn btn-secondary' id='button'>按鈕</button> -->\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "    </div>",childBackroundImg,BackroundColor,textHead,textBody );
		return  textElement;
	}
	

	public String getTextHead() {
		return textHead;
	}


	public void setTextHead(String textHead) {
		this.textHead = textHead;
	}


	public String getTextBody() {
		return textBody;
	}


	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}


	public String getTextElement() {
		return textElement;
	}


}
