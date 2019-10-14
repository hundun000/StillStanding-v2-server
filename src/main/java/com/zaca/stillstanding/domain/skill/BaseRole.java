package com.zaca.stillstanding.domain.skill;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hundun
 * Created on 2019/10/08
 */
public class BaseRole implements Cloneable{
    
    private final String name;
    private final String description;
    private List<SkillSlot> skillSlots = new ArrayList<>();
    
    
    public BaseRole(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public List<SkillSlot> getSkillSlots() {
        return skillSlots;
    }
    
    @Override
    public BaseRole clone() {
            BaseRole cloneRole = new BaseRole(name, description);
            for (SkillSlot skillSlot : skillSlots) {
                cloneRole.skillSlots.add(skillSlot.clone());
            }
            return cloneRole;
        }
}
