package old.com.gmail.robmadeyou;




public class StateMenu {
	
	static boolean hasIni = false;
	public static void onUpdate(){
		
		if(!hasIni){
			GuiButtonList.addButton(new GuiButtonList.GuiButtons(312, 150, 256, 64, 0, "MAIN_MENU", "start", Textures.startButton));
			GuiButtonList.addButton(new GuiButtonList.GuiButtons(312, 214, 256 , 64, 1, "MAIN_MENU", "credits", Textures.creditsButton));
			GuiButtonList.addButton(new GuiButtonList.GuiButtons(312, 278, 256, 64, 2, "MAIN_MENU", "levelEditor", Textures.levelEditButton));
			GuiButtonList.addButton(new GuiButtonList.GuiButtons(312, 342, 256, 64, 3, "MAIN_MENU", "quit", Textures.quitButton));
			hasIni = true;
		}
		for(int i = 0; i < GuiButtonList.maxButtons; i++){
			GuiButton b = GuiButtonList.button[i];
			if(b != null){
				if(b.name.equals("start")){
					if(b.isMouseOver()){
						b.tex = Textures.startButtonU;
						b.shakeButton();
						if(Input.lmbp){
							State.changeState("GAME");
						}
					}else{
						b.tex = Textures.startButton;
					}
				}else if(b.name.equals("credits")){
					if(b.isMouseOver()){
						b.tex = Textures.creditsButtonU;
						b.shakeButton();
						if(Input.lmbp){
							State.changeState("CREDITS");
						}
					}else{
						b.tex = Textures.creditsButton;
					}
				}else if(b.name.equals("levelEditor")){
					if(b.isMouseOver()){
						b.tex = Textures.levelEditButtonU;
						b.shakeButton();
						if(Input.lmbp){
							State.changeState("LEVEL_EDIT");
						}
					}else{
						b.tex = Textures.levelEditButton;
					}
				}else if(b.name.equals("quit")){
					if(b.isMouseOver()){
						b.tex = Textures.quitButtonU;
						b.shakeButton();
						if(Input.lmbp){
							State.changeState("QUIT");
						}
					}else{
						b.tex = Textures.quitButton;
					}
				}
			}
		}
	}
}
