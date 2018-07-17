package comfabiankockpflegi3000.github.pflegi3000.controller.show_patient_controller.ControllerCareFragment;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import comfabiankockpflegi3000.github.pflegi3000.activities.show_patient_activity.ShowPatientActivity;
import comfabiankockpflegi3000.github.pflegi3000.database.DaoFactory;
import comfabiankockpflegi3000.github.pflegi3000.database.tables.CareEntity;

public class ControllerCareFragment {

    private CareFragmentButtonListener btnListener;
    private DaoFactory daoFactory;
    private int patient_id;
    private ShowPatientActivity activity;

    public ControllerCareFragment(int p_id, ShowPatientActivity mainActivity){

        this.btnListener = new CareFragmentButtonListener(this);
        this.daoFactory = (DaoFactory) mainActivity.getApplication();
        this.activity = mainActivity;
        this.patient_id = p_id;
    }

    public CareEntity getCareDataForPatient() throws SQLException {

        Dao<CareEntity, Integer> cDao = this.daoFactory.getCareDAO();
        List<CareEntity> all = cDao.queryForAll();
        for(int i = 0; i < all.size(); i++){

            if(all.get(i).getId() == this.patient_id){

                return all.get(i);
            }
        }
        return null;
    }

    public CareFragmentButtonListener getBtnListener() {
        return btnListener;
    }
    public void now_Defecation() throws SQLException {

        Dao<CareEntity, Integer> cDao = this.daoFactory.getCareDAO();
        List<CareEntity> all = cDao.queryForAll();
        CareEntity e = null;
        for(int i = 0; i < all.size(); i++){

            if(all.get(i).getId() == this.patient_id){

                e = all.get(i);
                e.setL_defecation(System.currentTimeMillis());
                cDao.update(e);
            }
        }
        this.reloadView(e);
    }
    public void now_Meal() throws SQLException {

        Dao<CareEntity, Integer> cDao = this.daoFactory.getCareDAO();
        List<CareEntity> all = cDao.queryForAll();
        CareEntity e = null;

        for(int i = 0; i < all.size(); i++){

            if(all.get(i).getId() == this.patient_id){

                e = all.get(i);
                e.setL_meal(System.currentTimeMillis());
                cDao.update(e);
            }
        }
        this.reloadView(e);
    }
    public void now_Washed() throws SQLException {

        Dao<CareEntity, Integer> cDao = this.daoFactory.getCareDAO();
        List<CareEntity> all = cDao.queryForAll();
        CareEntity e = null;

        for(int i = 0; i < all.size(); i++){

            if(all.get(i).getId() == this.patient_id){

                e = all.get(i);
                e.setL_washed(System.currentTimeMillis());
                cDao.update(e);
            }
        }
        this.reloadView(e);
    }

    public void reloadView(CareEntity theEntity){

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM HH:mm:ss");

        Date tmp = new Date(theEntity.getL_defecation());
        this.activity.getfCare().getDefecationView().setText(sdf.format(tmp));
        tmp = new Date(theEntity.getL_meal());
        this.activity.getfCare().getMealView().setText(sdf.format(tmp));
        tmp = new Date(theEntity.getL_washed());
        this.activity.getfCare().getWashingView().setText(sdf.format(tmp));
    }
}
