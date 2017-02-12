package de.nyxcode.pi;

/* 
 * Copyright (C) Moritz Bischof ("NyxCode")
 * Licensing is defined in the file "LICENSE.txt", which is part of this project.
 */

import lombok.Data;

@Data
public class Vector2D {
    private final double x, y;

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
