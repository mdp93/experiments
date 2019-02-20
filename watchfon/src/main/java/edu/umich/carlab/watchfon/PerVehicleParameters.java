package edu.umich.carlab.watchfon;

import java.util.Arrays;

public class PerVehicleParameters {
    final static double INCHES_TO_METERS = 0.0254;

    public final static String ESCAPE1 = "Ford Escape 2017";
    public final static String ESCAPE2 = "Ford Escape 2017 #2";
    public final static String FIESTA = "Ford Fiesta 2017";
    public final static String FOCUS2016 = "Ford Focus Hatchback 2016";
    public final static String FOCUS2012 = "Focus 2012";
    public final static String MKZ = "MKZ";
    public final static String EXPLORER = "Explorer 2016";

    static String getPilotCar (String basename) {
        if (basename.contains("10482")) return EXPLORER;
        else if (basename.contains("10483")) return EXPLORER;
        else if (basename.contains("10484")) return EXPLORER;
        else if (basename.contains("10490")) return EXPLORER;
        else if (basename.contains("10491")) return EXPLORER;
        else if (basename.contains("10492")) return MKZ;
        else if (basename.contains("10622")) return MKZ;
        else if (basename.contains("10623")) return MKZ;
        else if (basename.contains("10624")) return MKZ;
        else if (basename.contains("10627")) return MKZ;
        else if (basename.contains("10628")) return MKZ;
        else if (basename.contains("10630")) return MKZ;
        else if (basename.contains("10631")) return MKZ;
        else if (basename.contains("10632")) return MKZ;
        else if (basename.contains("10633")) return MKZ;
        else if (basename.contains("10634")) return MKZ;
        else if (basename.contains("10635")) return MKZ;
        else if (basename.contains("10636")) return MKZ;
        else if (basename.contains("10637")) return MKZ;
        else if (basename.contains("10638")) return MKZ;
        else if (basename.contains("10639")) return MKZ;
        else if (basename.contains("10640")) return MKZ;
        else if (basename.contains("10641")) return MKZ;
        else if (basename.contains("10648")) return EXPLORER;
        else if (basename.contains("10650")) return EXPLORER;
        else if (basename.contains("10661")) return EXPLORER;
        else if (basename.contains("10663")) return EXPLORER;
        else if (basename.contains("10664")) return MKZ;
        else if (basename.contains("10665")) return MKZ;
        else if (basename.contains("10666")) return MKZ;
        else if (basename.contains("10667")) return MKZ;
        else if (basename.contains("10670")) return MKZ;
        else if (basename.contains("10673")) return MKZ;
        else if (basename.contains("10677")) return MKZ;
        else if (basename.contains("10730")) return MKZ;
        else if (basename.contains("10731")) return MKZ;
        else if (basename.contains("10732")) return MKZ;
        else if (basename.contains("10734")) return MKZ;
        else if (basename.contains("10735")) return MKZ;
        else if (basename.contains("10736")) return MKZ;
        else if (basename.contains("10738")) return MKZ;
        else if (basename.contains("10739")) return MKZ;
        else if (basename.contains("10741")) return MKZ;
        else if (basename.contains("10745")) return MKZ;
        else if (basename.contains("10746")) return MKZ;
        else if (basename.contains("10747")) return MKZ;
        else if (basename.contains("10755")) return MKZ;
        else if (basename.contains("10759")) return EXPLORER;
        else if (basename.contains("10760")) return EXPLORER;
        else if (basename.contains("10761")) return EXPLORER;
        else if (basename.contains("10762")) return EXPLORER;
        else if (basename.contains("10763")) return EXPLORER;
        else if (basename.contains("10764")) return MKZ;
        else if (basename.contains("10765")) return EXPLORER;
        else if (basename.contains("10766")) return MKZ;
        else if (basename.contains("10767")) return MKZ;
        else if (basename.contains("10768")) return MKZ;
        else if (basename.contains("10772")) return MKZ;
        else if (basename.contains("10773")) return MKZ;
        else if (basename.contains("10774")) return MKZ;
        else if (basename.contains("10775")) return MKZ;
        else if (basename.contains("10776")) return MKZ;
        else if (basename.contains("10777")) return MKZ;
        else if (basename.contains("10778")) return MKZ;
        else if (basename.contains("10779")) return MKZ;
        else if (basename.contains("10780")) return MKZ;
        else if (basename.contains("10781")) return MKZ;
        else if (basename.contains("10782")) return MKZ;
        else if (basename.contains("10783")) return MKZ;
        else if (basename.contains("10784")) return MKZ;
        else if (basename.contains("10785")) return MKZ;
        else if (basename.contains("10786")) return MKZ;
        else if (basename.contains("10795")) return MKZ;
        else if (basename.contains("10800")) return MKZ;
        else if (basename.contains("10815")) return MKZ;
        else if (basename.contains("10819")) return MKZ;
        else if (basename.contains("10820")) return MKZ;
        else if (basename.contains("10821")) return MKZ;
        else if (basename.contains("10824")) return MKZ;
        else if (basename.contains("10825")) return MKZ;
        else if (basename.contains("10826")) return MKZ;
        else if (basename.contains("10827")) return MKZ;
        else if (basename.contains("10828")) return MKZ;
        else if (basename.contains("10829")) return MKZ;
        else if (basename.contains("10830")) return MKZ;
        else if (basename.contains("10831")) return MKZ;
        else if (basename.contains("10833")) return MKZ;
        else if (basename.contains("10835")) return MKZ;
        else if (basename.contains("10836")) return MKZ;
        else if (basename.contains("10837")) return MKZ;
        else if (basename.contains("10838")) return MKZ;
        else if (basename.contains("10839")) return MKZ;
        else if (basename.contains("10840")) return MKZ;
        else if (basename.contains("10841")) return MKZ;
        else if (basename.contains("10842")) return MKZ;
        else if (basename.contains("10846")) return MKZ;
        else if (basename.contains("10847")) return MKZ;
        else if (basename.contains("10848")) return MKZ;
        else if (basename.contains("10849")) return MKZ;
        else if (basename.contains("10850")) return MKZ;
        else if (basename.contains("10851")) return EXPLORER;
        else if (basename.contains("20840")) return MKZ;
        else if (basename.contains("20841")) return MKZ;
        else if (basename.contains("20842")) return MKZ;
        else if (basename.contains("20843")) return MKZ;
        else if (basename.contains("20845")) return MKZ;
        else if (basename.contains("20854")) return EXPLORER;
        else if (basename.contains("20855")) return EXPLORER;
        else if (basename.contains("20862")) return EXPLORER;
        else if (basename.contains("20863")) return EXPLORER;
        else if (basename.contains("20864")) return EXPLORER;
        else if (basename.contains("20865")) return EXPLORER;
        else if (basename.contains("20868")) return MKZ;
        else if (basename.contains("20869")) return MKZ;
        else if (basename.contains("20870")) return MKZ;
        else if (basename.contains("20871")) return MKZ;
        else if (basename.contains("20872")) return MKZ;
        else if (basename.contains("20877")) return MKZ;
        else if (basename.contains("20878")) return MKZ;
        else if (basename.contains("20879")) return MKZ;
        else if (basename.contains("20880")) return MKZ;
        else if (basename.contains("20881")) return MKZ;
        else if (basename.contains("20882")) return FOCUS2012;
        else if (basename.contains("20883")) return MKZ;
        else if (basename.contains("20884")) return MKZ;
        else if (basename.contains("20885")) return MKZ;
        else if (basename.contains("20886")) return MKZ;
        else if (basename.contains("20887")) return MKZ;
        else if (basename.contains("20888")) return FOCUS2012;
        else if (basename.contains("20889")) return MKZ;
        else if (basename.contains("20890")) return MKZ;
        else if (basename.contains("20891")) return MKZ;
        else if (basename.contains("20892")) return MKZ;
        else if (basename.contains("20893")) return MKZ;
        else if (basename.contains("20894")) return MKZ;
        else if (basename.contains("20895")) return MKZ;
        else if (basename.contains("20896")) return MKZ;
        else if (basename.contains("20897")) return MKZ;
        else if (basename.contains("20898")) return MKZ;
        else if (basename.contains("20899")) return MKZ;
        else if (basename.contains("20900")) return MKZ;
        else if (basename.contains("20901")) return MKZ;
        else if (basename.contains("20902")) return MKZ;
        else if (basename.contains("20903")) return MKZ;
        else if (basename.contains("20904")) return MKZ;
        else if (basename.contains("20905")) return MKZ;
        else if (basename.contains("20906")) return MKZ;
        else if (basename.contains("20907")) return MKZ;
        else if (basename.contains("20912")) return MKZ;
        else if (basename.contains("20913")) return MKZ;
        else if (basename.contains("20914")) return MKZ;
        else if (basename.contains("20915")) return MKZ;
        else if (basename.contains("20916")) return MKZ;
        else if (basename.contains("20946")) return MKZ;
        else if (basename.contains("20947")) return MKZ;
        else if (basename.contains("20948")) return MKZ;
        else if (basename.contains("20949")) return MKZ;
        else if (basename.contains("20950")) return MKZ;
        else if (basename.contains("20951")) return MKZ;
        else if (basename.contains("20952")) return MKZ;
        else if (basename.contains("20953")) return MKZ;
        else if (basename.contains("20954")) return MKZ;
        else if (basename.contains("20955")) return MKZ;
        else if (basename.contains("20956")) return FOCUS2012;
        else if (basename.contains("20959")) return MKZ;
        else if (basename.contains("20960")) return MKZ;
        else if (basename.contains("20977")) return EXPLORER;
        else if (basename.contains("20979")) return MKZ;
        else if (basename.contains("20980")) return MKZ;
        else if (basename.contains("20983")) return MKZ;
        else if (basename.contains("20984")) return MKZ;
        else if (basename.contains("20985")) return MKZ;
        else if (basename.contains("20986")) return MKZ;
        else if (basename.contains("20987")) return MKZ;
        else if (basename.contains("20988")) return MKZ;
        else if (basename.contains("20989")) return MKZ;
        else if (basename.contains("20990")) return MKZ;
        else if (basename.contains("20991")) return MKZ;
        else if (basename.contains("20992")) return MKZ;
        else if (basename.contains("20993")) return FOCUS2012;
        else if (basename.contains("20994")) return FOCUS2012;
        else if (basename.contains("20995")) return FOCUS2012;
        else if (basename.contains("20997")) return EXPLORER;
        else if (basename.contains("20998")) return EXPLORER;
        else if (basename.contains("21004")) return EXPLORER;
        else if (basename.contains("21005")) return MKZ;
        else if (basename.contains("21006")) return MKZ;
        else if (basename.contains("21008")) return EXPLORER;
        else if (basename.contains("21009")) return EXPLORER;
        else if (basename.contains("21010")) return EXPLORER;
        else if (basename.contains("21011")) return EXPLORER;
        else if (basename.contains("21012")) return EXPLORER;
        else if (basename.contains("21013")) return EXPLORER;
        else if (basename.contains("21014")) return EXPLORER;
        else if (basename.contains("21015")) return EXPLORER;
        else if (basename.contains("21016")) return EXPLORER;
        else if (basename.contains("21017")) return EXPLORER;
        else if (basename.contains("21018")) return EXPLORER;
        else if (basename.contains("21019")) return EXPLORER;
        else if (basename.contains("21028")) return MKZ;
        else if (basename.contains("21029")) return MKZ;
        else if (basename.contains("21030")) return MKZ;
        else if (basename.contains("21031")) return EXPLORER;
        else if (basename.contains("21032")) return EXPLORER;
        else if (basename.contains("21033")) return EXPLORER;
        else if (basename.contains("21034")) return EXPLORER;
        else if (basename.contains("21035")) return EXPLORER;
        else if (basename.contains("21036")) return EXPLORER;
        else if (basename.contains("21037")) return EXPLORER;
        else if (basename.contains("21038")) return EXPLORER;
        else if (basename.contains("21039")) return EXPLORER;
        else if (basename.contains("21040")) return EXPLORER;
        else if (basename.contains("21041")) return EXPLORER;
        else if (basename.contains("21044")) return FOCUS2012;
        else if (basename.contains("21045")) return FOCUS2012;
        else if (basename.contains("21046")) return FOCUS2012;
        else if (basename.contains("21047")) return MKZ;
        else if (basename.contains("21048")) return MKZ;
        else if (basename.contains("21049")) return MKZ;
        else if (basename.contains("21050")) return MKZ;
        else if (basename.contains("21051")) return MKZ;
        else if (basename.contains("21052")) return FOCUS2012;
        else if (basename.contains("21053")) return FOCUS2012;
        else if (basename.contains("21054")) return FOCUS2012;
        else if (basename.contains("21056")) return MKZ;
        else if (basename.contains("21057")) return MKZ;
        else if (basename.contains("21058")) return MKZ;
        else if (basename.contains("21081")) return EXPLORER;
        else if (basename.contains("21082")) return EXPLORER;
        else if (basename.contains("21083")) return MKZ;
        else if (basename.contains("21085")) return MKZ;
        else if (basename.contains("21087")) return MKZ;
        else if (basename.contains("21089")) return MKZ;
        else if (basename.contains("21090")) return MKZ;
        else if (basename.contains("21091")) return MKZ;
        else if (basename.contains("21092")) return MKZ;
        else if (basename.contains("21094")) return MKZ;
        else if (basename.contains("21096")) return MKZ;
        else if (basename.contains("21098")) return MKZ;
        else if (basename.contains("21100")) return MKZ;
        else if (basename.contains("21102")) return MKZ;
        else if (basename.contains("21104")) return MKZ;
        else if (basename.contains("21110")) return MKZ;
        else if (basename.contains("21115")) return FOCUS2012;
        else if (basename.contains("21116")) return FOCUS2012;
        else if (basename.contains("21117")) return FOCUS2012;
        else if (basename.contains("21118")) return EXPLORER;
        else if (basename.contains("21119")) return EXPLORER;
        else if (basename.contains("21120")) return EXPLORER;
        else if (basename.contains("21121")) return EXPLORER;
        else if (basename.contains("21122")) return EXPLORER;
        else if (basename.contains("21123")) return EXPLORER;
        else if (basename.contains("21124")) return EXPLORER;
        else if (basename.contains("21125")) return EXPLORER;
        else if (basename.contains("21126")) return EXPLORER;
        else if (basename.contains("21127")) return EXPLORER;
        else if (basename.contains("21128")) return EXPLORER;
        else if (basename.contains("21129")) return FOCUS2012;
        else if (basename.contains("21130")) return FOCUS2012;
        else if (basename.contains("21131")) return FOCUS2012;
        else if (basename.contains("21132")) return FOCUS2012;
        else if (basename.contains("21133")) return FOCUS2012;
        else if (basename.contains("21134")) return FOCUS2012;
        else if (basename.contains("21135")) return FOCUS2012;
        else if (basename.contains("21136")) return FOCUS2012;
        else if (basename.contains("21137")) return FOCUS2012;
        else if (basename.contains("21138")) return FOCUS2012;
        else if (basename.contains("21139")) return FOCUS2012;
        else if (basename.contains("21140")) return FOCUS2012;
        else if (basename.contains("21141")) return EXPLORER;
        else if (basename.contains("21142")) return EXPLORER;
        else if (basename.contains("21143")) return EXPLORER;
        else if (basename.contains("21144")) return EXPLORER;
        else if (basename.contains("21145")) return EXPLORER;
        else if (basename.contains("21146")) return EXPLORER;
        else if (basename.contains("21147")) return EXPLORER;
        else if (basename.contains("21148")) return EXPLORER;
        else if (basename.contains("21149")) return EXPLORER;
        else if (basename.contains("21150")) return EXPLORER;
        else if (basename.contains("21151")) return EXPLORER;
        else if (basename.contains("21152")) return EXPLORER;
        else if (basename.contains("21153")) return FOCUS2012;
        else if (basename.contains("21154")) return FOCUS2012;
        else if (basename.contains("21155")) return FOCUS2012;
        else if (basename.contains("21156")) return FOCUS2012;
        else if (basename.contains("21157")) return FOCUS2012;
        else if (basename.contains("21158")) return FOCUS2012;
        else if (basename.contains("21159")) return FOCUS2012;
        else if (basename.contains("21160")) return FOCUS2012;
        else if (basename.contains("21161")) return FOCUS2012;
        else if (basename.contains("21162")) return FOCUS2012;
        else if (basename.contains("21163")) return FOCUS2012;
        else if (basename.contains("21164")) return FOCUS2012;
        else if (basename.contains("21165")) return FOCUS2012;
        else if (basename.contains("21166")) return FOCUS2012;
        else if (basename.contains("21168")) return FOCUS2012;
        else if (basename.contains("21169")) return EXPLORER;
        else if (basename.contains("21170")) return EXPLORER;
        else if (basename.contains("21171")) return EXPLORER;
        else if (basename.contains("21172")) return EXPLORER;
        else if (basename.contains("21173")) return EXPLORER;
        else if (basename.contains("21174")) return EXPLORER;
        else if (basename.contains("21175")) return EXPLORER;
        else if (basename.contains("21176")) return EXPLORER;
        else if (basename.contains("21177")) return EXPLORER;
        else if (basename.contains("21178")) return EXPLORER;
        else if (basename.contains("21179")) return EXPLORER;
        else if (basename.contains("21180")) return EXPLORER;
        else if (basename.contains("21184")) return EXPLORER;
        else if (basename.contains("21185")) return EXPLORER;
        else if (basename.contains("21186")) return EXPLORER;
        else if (basename.contains("21188")) return EXPLORER;
        else if (basename.contains("21189")) return EXPLORER;
        else if (basename.contains("21190")) return EXPLORER;
        else if (basename.contains("21191")) return EXPLORER;
        else if (basename.contains("21192")) return EXPLORER;
        else if (basename.contains("21193")) return EXPLORER;
        else if (basename.contains("21194")) return EXPLORER;
        else if (basename.contains("21196")) return EXPLORER;
        else if (basename.contains("21198")) return EXPLORER;
        else if (basename.contains("21200")) return EXPLORER;
        else if (basename.contains("21202")) return EXPLORER;
        else if (basename.contains("21213")) return EXPLORER;
        else if (basename.contains("21214")) return EXPLORER;
        else if (basename.contains("21215")) return EXPLORER;
        else if (basename.contains("21221")) return EXPLORER;
        else if (basename.contains("21222")) return EXPLORER;
        else if (basename.contains("21223")) return EXPLORER;
        else if (basename.contains("21224")) return EXPLORER;
        else if (basename.contains("21225")) return EXPLORER;
        else if (basename.contains("21227")) return EXPLORER;
        else if (basename.contains("21228")) return EXPLORER;
        else return EXPLORER;
//        else if (basename.contains("21229")) return EXPLORER;
    }

    public static String getVehicle (String basename) {
        String [] ESCAPE1_ORIGINAL = { "T47", "T48", "T50", "T51",
                                    "T52", "T64",
                                    "T60", "T61", "T62", "T63"};

        String [] ESCAPE2_ORIGINAL = { "T55", "T57" };

        String [] FIESTA_ORIGINAL = { "T53", "T54" };
        String [] FOCUS2016_ORIGINAL = { "T58", "T59" };

        if (basename.contains("-pilot")) return getPilotCar(basename);
        else if (basename.contains("-placement")) return MKZ;

        // Else it is the original set of trips
        else if (Arrays.asList(ESCAPE1_ORIGINAL).contains(basename))
            return ESCAPE1;
        else if (Arrays.asList(ESCAPE2_ORIGINAL).contains(basename))
            return ESCAPE2;
        else if (Arrays.asList(FIESTA_ORIGINAL).contains(basename))
            return FIESTA;

        // Else
        return FOCUS2016;
    }


    public static Float getVehicleLength (String vehicle) {
        Double lengthInches = 0.0;

        switch (vehicle) {
            case ESCAPE1:
            case ESCAPE2:
                lengthInches = 178.1;
                break;
            case FIESTA:
                lengthInches = 159.7;
                break;
            case FOCUS2012:
            case FOCUS2016:
                lengthInches = 171.7;
                break;
            case MKZ:
                lengthInches = 193.9;
                break;
            default: // Explorer
                lengthInches = 198.3;
                break;
        }

        return (float)(lengthInches * INCHES_TO_METERS);
    }

    public static Float getSteeringRatio (String vehicle) {
        switch (vehicle) {
            case ESCAPE1:
            case ESCAPE2:
                return 15.2f;
            case FIESTA:
                return 14.25f;
            case FOCUS2012:
            case FOCUS2016:
                return 18f;
            case MKZ:
                return 14.8f;
            default: // Explorer
                return 17.1f;
        }
    }


    /*
     51 def MAX_TANK_CAPACITY(filename):
     52     # gallons
     53     capacity = {
     54         ESCAPE: 15.7,
     55         FIESTA: 12.4,
     56         FOCUS: 12.4,
     57         MKZ: 18.0, # differs for FWD (16.4) and AWD (18)
     58         EXPLORER: 18.6,
     59     }
     60     return capacity[name_to_car(filename)]
     61
     62
     */

    public static Float getMaxFuelCapacity (String vehicle) {
        switch (vehicle) {
            case ESCAPE1:
            case ESCAPE2:
                return 15.7f;
            case FIESTA:
                return 12.4f;
            case FOCUS2012:
            case FOCUS2016:
                return 12.4f;
            case MKZ:
                return 18f;
            default: // Explorer
                return 18.6f;
        }
    }


    /*
     63 def AVERAGE_MPG(filename):
     64     average = {
     65         ESCAPE: 25,
     66         FIESTA: (27+35)/2.0,
     67         FOCUS: 31,
     68         MKZ: 23, # This is much higher on crowd-sourced websites, but this is from the spec
     69         EXPLORER: 19, # https://www.fueleconomy.gov/feg/bymodel/2016_Ford_Explorer.shtml
     70     }
     71     return average[name_to_car(filename)]
     72
     */

    public static Float getAverageMPG (String vehicle) {
        switch (vehicle) {
            case ESCAPE1:
            case ESCAPE2:
                return 25f;
            case FIESTA:
                return (float)(27 + 35)/2.0f;
            case FOCUS2012:
            case FOCUS2016:
                return 31f;
            case MKZ:
                return 23f;
            default: // Explorer
                return 19f;
        }
    }


    /*
     final double INCHES_TO_METERS = 0.0254;
    final double IDLE_RPM = 800;

    float FINAL_DRIVE_RATIO = 3.36f;
    final double TIRE_DIAM = (245 / 1000.0 * 45 / 100.0) * 2 + (18 * INCHES_TO_METERS);
    float TIRE_CIRCUM = (float)(TIRE_DIAM * Math.PI / 1000.0);
     */


    /*
    118
119 def code_to_circumference(p, slash, r):
120     # p in mm
121     # slash = percentage from rim to end of rubber
122     # r = diameter of rim in inches
123     diam = (p/1000.0 * slash / 100.0) * 2 + (r * INCHES_TO_METERS)
124     circum = diam * np.pi
125     return circum / 1000.0
126
     */


    static float code_to_circumference (int p, int slash, int r) {
        // p in mm
        // slash = percentage from rim to end of rubber
        // r = diameter of rim in inches

        double diam = (p / 1000.0 * slash / 100.0) * 2 + (r + INCHES_TO_METERS);
        double circum = diam * Math.PI;
        return (float)(circum / 1000.0);
    }

    /*

127 def TIRE_CIRCUMFERENCE(filename):
128     # returns in KM
129     circumferences = {
130         ESCAPE: code_to_circumference(p=235, slash=45, r=19), # could also be p235/55r17,
131         FIESTA: code_to_circumference(p=195, slash=50, r=16), # could also be 185/65r15, 195/55r15, 195/50r16, 195/50r16
132         FOCUS: code_to_circumference(p=215, slash=55, r=16), # other candidates: 195/65r15, 215/50r17, 215/50r17, 235/40r18
133         MKZ: code_to_circumference(p=245, slash=45, r=18), # other candidate: 245/40r19
134         EXPLORER: code_to_circumference(p=245, slash=60, r=18), # could be: 255/50r20
135     }
136
     */
    public static Float getTireCircum (String vehicle) {
        switch (vehicle) {
            case ESCAPE1:
            case ESCAPE2:
                return code_to_circumference(235, 45, 19);
            case FIESTA:
                return code_to_circumference(195, 50, 16);
            case FOCUS2012:
            case FOCUS2016:
                return code_to_circumference(215, 55, 16);
            case MKZ:
                return code_to_circumference(245, 45, 18);
            default: // Explorer
                return code_to_circumference(245, 60, 18);
        }
    }

    /*
    138
139 def FINAL_DRIVE_RATIO(filename, gear):
140     ratios = {
141         ESCAPE: 3.51, # could also be 3.21 or 3.07
142         #FIESTA: 4.07,
143         # FIESTA: 3.89 for gears 1, 2, 5, and 6. 4.35 for gears 3 4 and -1
144         # FOCUS: 4.06
145         FOCUS: 3.82,
146         MKZ: 3.36, # AWD MKZ
147         EXPLORER: 3.16,
148     }
149
150
151     model = name_to_car(filename)
152     if model == FIESTA:
153         if gear in [1,2,5,6]:
154             return 3.89
155         else: return 4.35
156     else:
157         return ratios[name_to_car(filename)]
~
~
     */

    public static Float getFinalDriveRatio (String vehicle) {
        switch (vehicle) {
            case ESCAPE1:
            case ESCAPE2:
                return 3.51f;
            case FIESTA:
                return (3.89f + 4.34f)/2.0f; // This isn't quite right. See above.
            case FOCUS2012:
            case FOCUS2016:
                return 3.82f;
            case MKZ:
                return 3.36f;
            default: // Explorer
                return 3.16f;
        }
    }
}
