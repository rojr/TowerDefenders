package old.com.gmail.robmadeyou;

import org.newdawn.slick.opengl.Texture;

public class State {
	/*
	 * Select from:
	 * 
	 *  * MAIN_MENU
	 *  * LEVEL_EDIT
	 *  * CREDITS
	 *  * GAME
	 *  * LEVEL_SELECT
	 *  
	 *   ...and many more!
	 */
	static String state = "MAIN_MENU";
	static String prevState = "MAIN_MENU";
	
	public static class Background extends GuiBackground{

		public Background(int x, int y, int w, int h, Texture tex) {
			super(x, y, w, h, tex);
		}
		
	}
	
	static Background backg = new Background(0, 0, 1024, 512, Textures.backgroundMenu);
	
	public static void onUpdate(int delta){
		if(!state.equals("GAME") && !state.equals("LEVEL_EDIT")){
			backg.draw();
		}
		GuiButtonList.drawAll(state);
		GuiButtonList.onUpdate(state);
		
		
		
		if(state.equals("MAIN_MENU")){
			StateMenu.onUpdate();
		}else if(state.equals("GAME")){
			TowerList.updateAll(delta);
			EnemyList.renderAll();
			EnemyList.updateAll(delta);
			BulletList.onUpdate(delta);
		}else if(state.equals("LEVEL_EDIT")){
			StateLevelEditor.onUpdate();
		}else if(state.equals("CREDITS")){
			StateCredits.onUpdate();
		}
	}
	public static void changeState(String s){
		prevState = state;
		state = s;
		
	}
	public static void changeBackground(Texture tex){
		backg.tex = tex;
	}
}
