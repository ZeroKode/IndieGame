package com.github.zerokode.coreengine.objects.metrics;

public enum Orientation {

    PORTRAIT(1), PORTRAIT_INVERTED(2), LANDSCAPE(3), LANDSCAPE_INVERTED(4);

    private int id;

    Orientation(int id){
        this.id = id;
    }

    public int getValue(){
        return this.id;
    }
    
    public String getName() {
        switch (id){
            case 1: return "Portrait";
            case 2: return "Portrait Inverted";
            case 3: return "Landscape";
            case 4: return "Landscape Inverted";
            default: return "Unknown";
        }
    }

    /**
     * PORTRAIT is the inverted of PORTRAIT_INVERTED and viceversa.
     * LANDSCAPE is the inverted of LANDSCAPE_INVERTED and viceversa.
     *
     * @param orientation - the new orientation
     * @return true when switching from X to X_INVERTED -or- from X_INVERTED to X.
     */
    public boolean isInvertedOf(Orientation orientation) {
        return this.getValue() + 1 == orientation.getValue() || this.getValue() == orientation.getValue() + 1;
    }
}
