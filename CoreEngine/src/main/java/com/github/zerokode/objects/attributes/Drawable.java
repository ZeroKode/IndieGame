package com.github.zerokode.objects.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Drawable extends Attribute {

    private int widthInMm;
    private int heightInMm;

}
