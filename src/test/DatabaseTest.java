package test;

import java.sql.Date;
import java.sql.SQLException;

import manager.CampaignManager;
import manager.UserManager;

import jdbc.dao.CampaignDao;
import jdbc.dto.Campaign;
import jdbc.dto.CampaignPk;
import jdbc.exceptions.CampaignDaoException;
import jdbc.factory.CampaignDaoFactory;
import jdbc.jdbc.ResourceManager;

public class DatabaseTest {

	public static void main(String args[]) {
		/*
		 * CampaignDao campaignDao =
		 * CampaignDaoFactory.create(ResourceManager.getConnection());
		 * Campaign[] campanhas = null; try { campanhas =
		 * campaignDao.findWhereNameEquals("Mundo"); } catch
		 * (CampaignDaoException a) { a.printStackTrace(); } if
		 * (campanhas.length > 0) {
		 * campanhas[0].setBegin(Date.valueOf("2012-03-01"));
		 * campanhas[0].setEnd(Date.valueOf("2012-03-30"));
		 * 
		 * try { campaignDao.update(new CampaignPk(campanhas[0].getId()),
		 * campanhas[0]); } catch (CampaignDaoException c) {
		 * c.printStackTrace(); } } else {
		 * System.out.println("Não retornou nenhum resultado."); }
		 
		CampaignManager.addCampaign("GriteR",
				"Campanha pela consciência ecológica nos Gritos Rock",
				"2012-01-14", "2012-03-15");
		CampaignManager.addCampaign("Teste", "", "0000-01-01", "3000-01-01");
		*/
		Campaign campaigns[] = CampaignManager.getCampaignsByPeriod("2012-05-01"); 
		for (int i = 0; i < campaigns.length ; i++ )
			System.out.println(campaigns[i].getName());
	}
}
