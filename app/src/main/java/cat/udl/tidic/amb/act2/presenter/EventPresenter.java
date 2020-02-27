package cat.udl.tidic.amb.act2.presenter;

import cat.udl.tidic.amb.act2.EventViewActions;
import cat.udl.tidic.amb.act2.models.EventModel;

public class EventPresenter {
    private EventModel model;

    private EventViewActions view;

    public EventPresenter(EventViewActions view){
        this.view = view;
    }

    public void setEvent(String nom, String desc, int year, int month, int day) {
        this.model = new EventModel(nom,desc,year,month,day);
    }

    public void getEvent(){
        view.updateUI(this.model.toString());
    }

}
