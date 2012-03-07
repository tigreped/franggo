package manager;

import java.sql.Connection;
import java.sql.Date;

import jdbc.dao.CampaignDao;
import jdbc.dto.Campaign;
import jdbc.dto.CampaignPk;
import jdbc.exceptions.CampaignDaoException;
import jdbc.factory.CampaignDaoFactory;
import jdbc.jdbc.ResourceManager;

/**
 * Manages campaigns.
 * 
 * @author Pedro Guimarães
 * @date 06/03/2012
 * 
 */
public class CampaignManager {

	private static Connection connection = ResourceManager.getConnection();

	private static CampaignDao campaignDao = getCampaignDao();

	private static CampaignDao getCampaignDao() {
		return CampaignDaoFactory.create(connection);
	}

	public static void addCampaign(String name, String description,
			String begin, String end) {
		if (exists(name))
			System.out.println("A campanha " + name + " já está cadastrada.");
		else {
			Campaign campaign = new Campaign();
			campaign.setName(name);
			campaign.setDescription(description);
			campaign.setBegin(Date.valueOf(begin));
			campaign.setEnd(Date.valueOf(end));
			try {
			campaignDao.insert(campaign);
			} catch(CampaignDaoException c) {
				c.printStackTrace();
			}
		}
	}

	public static boolean exists(String name) {
		try {
			if (campaignDao.findWhereNameEquals(name).length > 0)
				return true;
		} catch (CampaignDaoException c) {
			c.printStackTrace();
		}
		return false;
	}

	public static Campaign[] getAllCampaigns() {
		try {
			return campaignDao.findAll();
		} catch (CampaignDaoException c) {
			c.printStackTrace();
			return null;
		}
	}

	public static Campaign getCampaignByName(String name) {
		try {
			Campaign[] campaigns = campaignDao.findWhereNameEquals(name);
			if (campaigns.length > 0)
				return campaigns[0];
		} catch (CampaignDaoException c) {
			c.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns campaigns that are valid at the period specified in the date
	 * argument.
	 * 
	 * @param date
	 *            filter
	 * @return
	 */
	public static Campaign[] getCampaignsByPeriod(String date) {
		Object[] args = new Object[2];
		args[0] = date;
		args[1] = date;
		Campaign[] campaigns = null;
		try {
			campaigns = campaignDao
					.findByDynamicSelect(
							"SELECT * FROM Franggo.CAMPAIGN WHERE BEGIN <= ? AND END >= ?",
							args);
		} catch (CampaignDaoException e) {
			e.printStackTrace();
		}
		return campaigns;
	}

	public static void updateBegin(int id, String begin) {
		try {
			Campaign campaign = findById(id);
			if (campaign != null) {
				campaign.setBegin(Date.valueOf(begin));
				campaignDao.update(new CampaignPk(campaign.getId()), campaign);
			} else
				System.out.println("Campanha não encontrada com o id: " + id);
		} catch (CampaignDaoException c) {
			c.printStackTrace();
		}
	}

	public static void updateEnd(int id, String end) {
		try {
			Campaign campaign = findById(id);
			if (campaign != null) {
				campaign.setEnd(Date.valueOf(end));
				campaignDao.update(new CampaignPk(campaign.getId()), campaign);
			} else
				System.out.println("Campanha não encontrada com o id: " + id);
		} catch (CampaignDaoException c) {
			c.printStackTrace();
		}
	}

	public static void updateDescription(int id, String description) {
		try {
			Campaign campaign = findById(id);
			if (campaign != null) {
				campaign.setDescription(description);
				campaignDao.update(new CampaignPk(campaign.getId()), campaign);
			} else
				System.out.println("Campanha não encontrada com o id: " + id);
		} catch (CampaignDaoException c) {
			c.printStackTrace();
		}
	}

	public static Campaign findById(int id) {
		try {
			Campaign campaign = campaignDao.findByPrimaryKey(id);
			if (campaign != null)
				return campaign;	
		} catch (CampaignDaoException c) {
			c.printStackTrace();
		}
		return null;
	}
	
	public static void removeCampaign(String name) {
		Campaign campaign = getCampaignByName(name);
		try {
			campaignDao.delete(new CampaignPk(campaign.getId()));
		} catch (CampaignDaoException e) {
			e.printStackTrace();
		}
	}
}