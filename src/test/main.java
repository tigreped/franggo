package test;

import controller.PropertiesManager;
import twitter.GetAccessToken;
import twitter.UpdateStatus;

public class main {

	public static void main(String args[]) {
		
		/* Gets user access and grants access token/secret:
		new GetAccessToken(
				"ZhCwAzmMVakQnDSzwgHCUw",
				"954CP6Pmge5uzEbDdD4r8HZCnQgeN0N1qWWFAz3k");
		*/		
		
		/* Nova Campanha */
		/*
		Campaign campanha = new Campaign("M.O.A.");
		
		try {
			campanha.addMessage("Em abril, o plano é conhecer São Luiz do Maranhão no #MetalOpenAir");
			campanha.addMessage("Eu vou pro #MetalOpenAir Você vai também?");
			campanha.addMessage("O maior festival de metal do BRASIL #MetalOpenAir 40 bandas EU VOU!!!");
			campanha.addMessage("http://metalopenair.com/pt/ #MetalOpenAir");
			campanha.addMessage("TORTURE SQUAD/HANGAR/ANDRE MATOS/KORZUS/RATOS DE PORÃO --> #MetalOpenAir");
			campanha.addMessage("EXODUS/MEGADETH/VENOM/SYMPHONY X/DESTRUCTION/BLIND GUARDIAN/OBITUARY  --> #MetalOpenAir");
		} catch (Exception e) {
			e.printStackTrace();
		}
		campanha.persistMessages();
		
		campanha.loadMessages();
		while(true) {
			try {
				String msg = null;
				msg = campanha.fetchUpdateMessage("figgo");
				if (msg != null)
					new UpdateStatus(msg);
				else
					break;
				Thread.sleep(600000); // Uma msg a cada dez minutos
			} catch(InterruptedException i) {
				i.printStackTrace();
			}
		}
		*/
		try {
			PropertiesManager.loadProperties("figgo");
			Thread.sleep(1000);
			new UpdateStatus("http://www.figgo.com.br");
			Thread.sleep(1000);
			PropertiesManager.loadProperties("pedr0guimaraes");
			Thread.sleep(1000);
			new UpdateStatus("http://pedroguimaraes.blog.com");
			Thread.sleep(1000);
			PropertiesManager.loadProperties("bandahazamat");
			Thread.sleep(1000);
			new UpdateStatus("http://www.hazamat.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
