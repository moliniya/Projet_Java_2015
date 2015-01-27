package fr.enac.aero.airportPackage;


/**
 * Un point physique de l'aeroport est caracterise par son type.
 * Les differentes valeurs que peut prendre ce type sont enumerees dans EnumTypePt:
 * "Stand" ou aire de parking (valeur 0)
 * "Deicing" ou zone de degel (valeur 1)
 * "Runway_Point" ou point d'intersection d'une piste (valeur 2)
 */
public enum EnumTypePt {
Stand, 
Deicing,
Runway_Point;
}
