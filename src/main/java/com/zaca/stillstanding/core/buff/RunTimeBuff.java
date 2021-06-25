package com.zaca.stillstanding.core.buff;

import com.zaca.stillstanding.dto.buff.RunTimeBuffDTO;

/**
 * @author hundun
 * Created on 2020/05/20
 */
public class RunTimeBuff {
    
    private final BuffModel model;
    private int duration;
    
    public RunTimeBuff(BuffModel model, int duration) {
        this.model = model;
        this.duration = duration;
    }
    
    public void minusOneDurationAndCheckMaxDuration() {
        duration--;
        if (duration > model.getMaxDuration()) {
            duration = model.getMaxDuration();
        }
    }
    
    public void clearDuration() {
        duration = 0;
    }
    
    public void addDuration(int plus) {
        duration += plus;
    }
    
    public BuffModel getModel() {
        return model;
    }
    
    public int getDuration() {
        return duration;
    }

    public RunTimeBuffDTO toRunTimeBuffDTO() {
        RunTimeBuffDTO dto = new RunTimeBuffDTO();
        dto.setName(this.model.getName());
        dto.setDescription(this.model.getDescription());
        dto.setDuration(duration);
        return dto;
    }

}
