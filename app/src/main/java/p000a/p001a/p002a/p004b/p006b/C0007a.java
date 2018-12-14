package p000a.p001a.p002a.p004b.p006b;

import android.content.p013pm.PermissionInfo;
import android.support.p015v4.media.TransportMediator;
import com.tencent.xuanfeng.downloadsdkkernel.NetCallUntl;
import java.lang.reflect.Array;
import p000a.p001a.p002a.p007c.C0010a;

/* renamed from: a.a.a.b.b.a */
public final class C0007a {
    /* renamed from: g */
    private static final byte[] f30g;
    /* renamed from: h */
    private static final int[] f31h = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    /* renamed from: i */
    private static final int[] f32i;
    /* renamed from: a */
    private int f33a;
    /* renamed from: b */
    private int[][] f34b = null;
    /* renamed from: c */
    private int f35c;
    /* renamed from: d */
    private int f36d;
    /* renamed from: e */
    private int f37e;
    /* renamed from: f */
    private int f38f;

    static {
        byte[] bArr = new byte[256];
        bArr[0] = (byte) 99;
        bArr[1] = (byte) 124;
        bArr[2] = (byte) 119;
        bArr[3] = (byte) 123;
        bArr[4] = (byte) -14;
        bArr[5] = (byte) 107;
        bArr[6] = (byte) 111;
        bArr[7] = (byte) -59;
        bArr[8] = (byte) 48;
        bArr[9] = (byte) 1;
        bArr[10] = (byte) 103;
        bArr[11] = (byte) 43;
        bArr[12] = (byte) -2;
        bArr[13] = (byte) -41;
        bArr[14] = (byte) -85;
        bArr[15] = (byte) 118;
        bArr[16] = (byte) -54;
        bArr[17] = (byte) -126;
        bArr[18] = (byte) -55;
        bArr[19] = (byte) 125;
        bArr[20] = (byte) -6;
        bArr[21] = (byte) 89;
        bArr[22] = (byte) 71;
        bArr[23] = (byte) -16;
        bArr[24] = (byte) -83;
        bArr[25] = (byte) -44;
        bArr[26] = (byte) -94;
        bArr[27] = (byte) -81;
        bArr[28] = (byte) -100;
        bArr[29] = (byte) -92;
        bArr[30] = (byte) 114;
        bArr[31] = (byte) -64;
        bArr[32] = (byte) -73;
        bArr[33] = (byte) -3;
        bArr[34] = (byte) -109;
        bArr[35] = (byte) 38;
        bArr[36] = (byte) 54;
        bArr[37] = (byte) 63;
        bArr[38] = (byte) -9;
        bArr[39] = (byte) -52;
        bArr[40] = (byte) 52;
        bArr[41] = (byte) -91;
        bArr[42] = (byte) -27;
        bArr[43] = (byte) -15;
        bArr[44] = (byte) 113;
        bArr[45] = (byte) -40;
        bArr[46] = (byte) 49;
        bArr[47] = (byte) 21;
        bArr[48] = (byte) 4;
        bArr[49] = (byte) -57;
        bArr[50] = (byte) 35;
        bArr[51] = (byte) -61;
        bArr[52] = (byte) 24;
        bArr[53] = (byte) -106;
        bArr[54] = (byte) 5;
        bArr[55] = (byte) -102;
        bArr[56] = (byte) 7;
        bArr[57] = (byte) 18;
        bArr[58] = Byte.MIN_VALUE;
        bArr[59] = (byte) -30;
        bArr[60] = (byte) -21;
        bArr[61] = (byte) 39;
        bArr[62] = (byte) -78;
        bArr[63] = (byte) 117;
        bArr[64] = (byte) 9;
        bArr[65] = (byte) -125;
        bArr[66] = (byte) 44;
        bArr[67] = (byte) 26;
        bArr[68] = (byte) 27;
        bArr[69] = (byte) 110;
        bArr[70] = (byte) 90;
        bArr[71] = (byte) -96;
        bArr[72] = (byte) 82;
        bArr[73] = (byte) 59;
        bArr[74] = (byte) -42;
        bArr[75] = (byte) -77;
        bArr[76] = (byte) 41;
        bArr[77] = (byte) -29;
        bArr[78] = (byte) 47;
        bArr[79] = (byte) -124;
        bArr[80] = (byte) 83;
        bArr[81] = (byte) -47;
        bArr[83] = (byte) -19;
        bArr[84] = (byte) 32;
        bArr[85] = (byte) -4;
        bArr[86] = (byte) -79;
        bArr[87] = (byte) 91;
        bArr[88] = (byte) 106;
        bArr[89] = (byte) -53;
        bArr[90] = (byte) -66;
        bArr[91] = (byte) 57;
        bArr[92] = (byte) 74;
        bArr[93] = (byte) 76;
        bArr[94] = (byte) 88;
        bArr[95] = (byte) -49;
        bArr[96] = (byte) -48;
        bArr[97] = (byte) -17;
        bArr[98] = (byte) -86;
        bArr[99] = (byte) -5;
        bArr[100] = (byte) 67;
        bArr[101] = (byte) 77;
        bArr[102] = (byte) 51;
        bArr[NetCallUntl.NET_TYPE_MORE_THAN_3G] = (byte) -123;
        bArr[NetCallUntl.NET_TYPE_WIFI] = (byte) 69;
        bArr[105] = (byte) -7;
        bArr[106] = (byte) 2;
        bArr[107] = Byte.MAX_VALUE;
        bArr[108] = (byte) 80;
        bArr[109] = (byte) 60;
        bArr[110] = (byte) -97;
        bArr[111] = (byte) -88;
        bArr[112] = (byte) 81;
        bArr[113] = (byte) -93;
        bArr[114] = (byte) 64;
        bArr[115] = (byte) -113;
        bArr[116] = (byte) -110;
        bArr[117] = (byte) -99;
        bArr[118] = (byte) 56;
        bArr[119] = (byte) -11;
        bArr[120] = (byte) -68;
        bArr[121] = (byte) -74;
        bArr[122] = (byte) -38;
        bArr[123] = (byte) 33;
        bArr[124] = (byte) 16;
        bArr[125] = (byte) -1;
        bArr[TransportMediator.KEYCODE_MEDIA_PLAY] = (byte) -13;
        bArr[TransportMediator.KEYCODE_MEDIA_PAUSE] = (byte) -46;
        bArr[128] = (byte) -51;
        bArr[129] = (byte) 12;
        bArr[TransportMediator.KEYCODE_MEDIA_RECORD] = (byte) 19;
        bArr[131] = (byte) -20;
        bArr[132] = (byte) 95;
        bArr[133] = (byte) -105;
        bArr[134] = (byte) 68;
        bArr[135] = (byte) 23;
        bArr[136] = (byte) -60;
        bArr[137] = (byte) -89;
        bArr[138] = (byte) 126;
        bArr[139] = (byte) 61;
        bArr[140] = (byte) 100;
        bArr[141] = (byte) 93;
        bArr[142] = (byte) 25;
        bArr[143] = (byte) 115;
        bArr[144] = (byte) 96;
        bArr[145] = (byte) -127;
        bArr[146] = (byte) 79;
        bArr[147] = (byte) -36;
        bArr[148] = (byte) 34;
        bArr[149] = (byte) 42;
        bArr[150] = (byte) -112;
        bArr[151] = (byte) -120;
        bArr[152] = (byte) 70;
        bArr[153] = (byte) -18;
        bArr[154] = (byte) -72;
        bArr[155] = (byte) 20;
        bArr[156] = (byte) -34;
        bArr[157] = (byte) 94;
        bArr[158] = (byte) 11;
        bArr[159] = (byte) -37;
        bArr[160] = (byte) -32;
        bArr[161] = (byte) 50;
        bArr[162] = (byte) 58;
        bArr[163] = (byte) 10;
        bArr[164] = (byte) 73;
        bArr[165] = (byte) 6;
        bArr[166] = (byte) 36;
        bArr[167] = (byte) 92;
        bArr[168] = (byte) -62;
        bArr[169] = (byte) -45;
        bArr[170] = (byte) -84;
        bArr[171] = (byte) 98;
        bArr[172] = (byte) -111;
        bArr[173] = (byte) -107;
        bArr[174] = (byte) -28;
        bArr[175] = (byte) 121;
        bArr[176] = (byte) -25;
        bArr[177] = (byte) -56;
        bArr[178] = (byte) 55;
        bArr[179] = (byte) 109;
        bArr[180] = (byte) -115;
        bArr[181] = (byte) -43;
        bArr[182] = (byte) 78;
        bArr[183] = (byte) -87;
        bArr[184] = (byte) 108;
        bArr[185] = (byte) 86;
        bArr[186] = (byte) -12;
        bArr[187] = (byte) -22;
        bArr[188] = (byte) 101;
        bArr[189] = (byte) 122;
        bArr[190] = (byte) -82;
        bArr[191] = (byte) 8;
        bArr[192] = (byte) -70;
        bArr[193] = (byte) 120;
        bArr[194] = (byte) 37;
        bArr[195] = (byte) 46;
        bArr[196] = (byte) 28;
        bArr[197] = (byte) -90;
        bArr[198] = (byte) -76;
        bArr[199] = (byte) -58;
        bArr[200] = (byte) -24;
        bArr[201] = (byte) -35;
        bArr[202] = (byte) 116;
        bArr[203] = (byte) 31;
        bArr[204] = (byte) 75;
        bArr[205] = (byte) -67;
        bArr[206] = (byte) -117;
        bArr[207] = (byte) -118;
        bArr[208] = (byte) 112;
        bArr[209] = (byte) 62;
        bArr[210] = (byte) -75;
        bArr[211] = (byte) 102;
        bArr[212] = (byte) 72;
        bArr[213] = (byte) 3;
        bArr[214] = (byte) -10;
        bArr[215] = (byte) 14;
        bArr[216] = (byte) 97;
        bArr[217] = (byte) 53;
        bArr[218] = (byte) 87;
        bArr[219] = (byte) -71;
        bArr[220] = (byte) -122;
        bArr[221] = (byte) -63;
        bArr[222] = (byte) 29;
        bArr[223] = (byte) -98;
        bArr[224] = (byte) -31;
        bArr[225] = (byte) -8;
        bArr[226] = (byte) -104;
        bArr[227] = (byte) 17;
        bArr[228] = (byte) 105;
        bArr[229] = (byte) -39;
        bArr[230] = (byte) -114;
        bArr[231] = (byte) -108;
        bArr[232] = (byte) -101;
        bArr[233] = (byte) 30;
        bArr[234] = (byte) -121;
        bArr[235] = (byte) -23;
        bArr[236] = (byte) -50;
        bArr[237] = (byte) 85;
        bArr[238] = (byte) 40;
        bArr[239] = (byte) -33;
        bArr[PermissionInfo.PROTECTION_MASK_FLAGS] = (byte) -116;
        bArr[241] = (byte) -95;
        bArr[242] = (byte) -119;
        bArr[243] = (byte) 13;
        bArr[244] = (byte) -65;
        bArr[245] = (byte) -26;
        bArr[246] = (byte) 66;
        bArr[247] = (byte) 104;
        bArr[248] = (byte) 65;
        bArr[249] = (byte) -103;
        bArr[250] = (byte) 45;
        bArr[251] = (byte) 15;
        bArr[252] = (byte) -80;
        bArr[253] = (byte) 84;
        bArr[254] = (byte) -69;
        bArr[255] = (byte) 22;
        f30g = bArr;
        int[] iArr = new int[256];
        iArr[0] = -1520213050;
        iArr[1] = -2072216328;
        iArr[2] = -1720223762;
        iArr[3] = -1921287178;
        iArr[4] = 234025727;
        iArr[5] = -1117033514;
        iArr[6] = -1318096930;
        iArr[7] = 1422247313;
        iArr[8] = 1345335392;
        iArr[9] = 50397442;
        iArr[10] = -1452841010;
        iArr[11] = 2099981142;
        iArr[12] = 436141799;
        iArr[13] = 1658312629;
        iArr[14] = -424957107;
        iArr[15] = -1703512340;
        iArr[16] = 1170918031;
        iArr[17] = -1652391393;
        iArr[18] = 1086966153;
        iArr[19] = -2021818886;
        iArr[20] = 368769775;
        iArr[21] = -346465870;
        iArr[22] = -918075506;
        iArr[23] = 200339707;
        iArr[24] = -324162239;
        iArr[25] = 1742001331;
        iArr[26] = -39673249;
        iArr[27] = -357585083;
        iArr[28] = -1080255453;
        iArr[29] = -140204973;
        iArr[30] = -1770884380;
        iArr[31] = 1539358875;
        iArr[32] = -1028147339;
        iArr[33] = 486407649;
        iArr[34] = -1366060227;
        iArr[35] = 1780885068;
        iArr[36] = 1513502316;
        iArr[37] = 1094664062;
        iArr[38] = 49805301;
        iArr[39] = 1338821763;
        iArr[40] = 1546925160;
        iArr[41] = -190470831;
        iArr[42] = 887481809;
        iArr[43] = 150073849;
        iArr[44] = -1821281822;
        iArr[45] = 1943591083;
        iArr[46] = 1395732834;
        iArr[47] = 1058346282;
        iArr[48] = 201589768;
        iArr[49] = 1388824469;
        iArr[50] = 1696801606;
        iArr[51] = 1589887901;
        iArr[52] = 672667696;
        iArr[53] = -1583966665;
        iArr[54] = 251987210;
        iArr[55] = -1248159185;
        iArr[56] = 151455502;
        iArr[57] = 907153956;
        iArr[58] = -1686077413;
        iArr[59] = 1038279391;
        iArr[60] = 652995533;
        iArr[61] = 1764173646;
        iArr[62] = -843926913;
        iArr[63] = -1619692054;
        iArr[64] = 453576978;
        iArr[65] = -1635548387;
        iArr[66] = 1949051992;
        iArr[67] = 773462580;
        iArr[68] = 756751158;
        iArr[69] = -1301385508;
        iArr[70] = -296068428;
        iArr[71] = -73359269;
        iArr[72] = -162377052;
        iArr[73] = 1295727478;
        iArr[74] = 1641469623;
        iArr[75] = -827083907;
        iArr[76] = 2066295122;
        iArr[77] = 1055122397;
        iArr[78] = 1898917726;
        iArr[79] = -1752923117;
        iArr[80] = -179088474;
        iArr[81] = 1758581177;
        iArr[83] = 753790401;
        iArr[84] = 1612718144;
        iArr[85] = 536673507;
        iArr[86] = -927878791;
        iArr[87] = -312779850;
        iArr[88] = -1100322092;
        iArr[89] = 1187761037;
        iArr[90] = -641810841;
        iArr[91] = 1262041458;
        iArr[92] = -565556588;
        iArr[93] = -733197160;
        iArr[94] = -396863312;
        iArr[95] = 1255133061;
        iArr[96] = 1808847035;
        iArr[97] = 720367557;
        iArr[98] = -441800113;
        iArr[99] = 385612781;
        iArr[100] = -985447546;
        iArr[101] = -682799718;
        iArr[102] = 1429418854;
        iArr[NetCallUntl.NET_TYPE_MORE_THAN_3G] = -1803188975;
        iArr[NetCallUntl.NET_TYPE_WIFI] = -817543798;
        iArr[105] = 284817897;
        iArr[106] = 100794884;
        iArr[107] = -2122350594;
        iArr[108] = -263171936;
        iArr[109] = 1144798328;
        iArr[110] = -1163944155;
        iArr[111] = -475486133;
        iArr[112] = -212774494;
        iArr[113] = -22830243;
        iArr[114] = -1069531008;
        iArr[115] = -1970303227;
        iArr[116] = -1382903233;
        iArr[117] = -1130521311;
        iArr[118] = 1211644016;
        iArr[119] = 83228145;
        iArr[120] = -541279133;
        iArr[121] = -1044990345;
        iArr[122] = 1977277103;
        iArr[123] = 1663115586;
        iArr[124] = 806359072;
        iArr[125] = 452984805;
        iArr[TransportMediator.KEYCODE_MEDIA_PLAY] = 250868733;
        iArr[TransportMediator.KEYCODE_MEDIA_PAUSE] = 1842533055;
        iArr[128] = 1288555905;
        iArr[129] = 336333848;
        iArr[TransportMediator.KEYCODE_MEDIA_RECORD] = 890442534;
        iArr[131] = 804056259;
        iArr[132] = -513843266;
        iArr[133] = -1567123659;
        iArr[134] = -867941240;
        iArr[135] = 957814574;
        iArr[136] = 1472513171;
        iArr[137] = -223893675;
        iArr[138] = -2105639172;
        iArr[139] = 1195195770;
        iArr[140] = -1402706744;
        iArr[141] = -413311558;
        iArr[142] = 723065138;
        iArr[143] = -1787595802;
        iArr[144] = -1604296512;
        iArr[145] = -1736343271;
        iArr[146] = -783331426;
        iArr[147] = 2145180835;
        iArr[148] = 1713513028;
        iArr[149] = 2116692564;
        iArr[150] = -1416589253;
        iArr[151] = -2088204277;
        iArr[152] = -901364084;
        iArr[153] = 703524551;
        iArr[154] = -742868885;
        iArr[155] = 1007948840;
        iArr[156] = 2044649127;
        iArr[157] = -497131844;
        iArr[158] = 487262998;
        iArr[159] = 1994120109;
        iArr[160] = 1004593371;
        iArr[161] = 1446130276;
        iArr[162] = 1312438900;
        iArr[163] = 503974420;
        iArr[164] = -615954030;
        iArr[165] = 168166924;
        iArr[166] = 1814307912;
        iArr[167] = -463709000;
        iArr[168] = 1573044895;
        iArr[169] = 1859376061;
        iArr[170] = -273896381;
        iArr[171] = -1503501628;
        iArr[172] = -1466855111;
        iArr[173] = -1533700815;
        iArr[174] = 937747667;
        iArr[175] = -1954973198;
        iArr[176] = 854058965;
        iArr[177] = 1137232011;
        iArr[178] = 1496790894;
        iArr[179] = -1217565222;
        iArr[180] = -1936880383;
        iArr[181] = 1691735473;
        iArr[182] = -766620004;
        iArr[183] = -525751991;
        iArr[184] = -1267962664;
        iArr[185] = -95005012;
        iArr[186] = 133494003;
        iArr[187] = 636152527;
        iArr[188] = -1352309302;
        iArr[189] = -1904575756;
        iArr[190] = -374428089;
        iArr[191] = 403179536;
        iArr[192] = -709182865;
        iArr[193] = -2005370640;
        iArr[194] = 1864705354;
        iArr[195] = 1915629148;
        iArr[196] = 605822008;
        iArr[197] = -240736681;
        iArr[198] = -944458637;
        iArr[199] = 1371981463;
        iArr[200] = 602466507;
        iArr[201] = 2094914977;
        iArr[202] = -1670089496;
        iArr[203] = 555687742;
        iArr[204] = -582268010;
        iArr[205] = -591544991;
        iArr[206] = -2037675251;
        iArr[207] = -2054518257;
        iArr[208] = -1871679264;
        iArr[209] = 1111375484;
        iArr[210] = -994724495;
        iArr[211] = -1436129588;
        iArr[212] = -666351472;
        iArr[213] = 84083462;
        iArr[214] = 32962295;
        iArr[215] = 302911004;
        iArr[216] = -1553899070;
        iArr[217] = 1597322602;
        iArr[218] = -111716434;
        iArr[219] = -793134743;
        iArr[220] = -1853454825;
        iArr[221] = 1489093017;
        iArr[222] = 656219450;
        iArr[223] = -1180787161;
        iArr[224] = 954327513;
        iArr[225] = 335083755;
        iArr[226] = -1281845205;
        iArr[227] = 856756514;
        iArr[228] = -1150719534;
        iArr[229] = 1893325225;
        iArr[230] = -1987146233;
        iArr[231] = -1483434957;
        iArr[232] = -1231316179;
        iArr[233] = 572399164;
        iArr[234] = -1836611819;
        iArr[235] = 552200649;
        iArr[236] = 1238290055;
        iArr[237] = -11184726;
        iArr[238] = 2015897680;
        iArr[239] = 2061492133;
        iArr[PermissionInfo.PROTECTION_MASK_FLAGS] = -1886614525;
        iArr[241] = -123625127;
        iArr[242] = -2138470135;
        iArr[243] = 386731290;
        iArr[244] = -624967835;
        iArr[245] = 837215959;
        iArr[246] = -968736124;
        iArr[247] = -1201116976;
        iArr[248] = -1019133566;
        iArr[249] = -1332111063;
        iArr[250] = 1999449434;
        iArr[251] = 286199582;
        iArr[252] = -877612933;
        iArr[253] = -61582168;
        iArr[254] = -692339859;
        iArr[255] = 974525996;
        f32i = iArr;
    }

    public C0007a(byte[] bArr) {
        this.f34b = m35a(bArr);
    }

    /* renamed from: a */
    private static int m33a(int i) {
        return (((f30g[i & 255] & 255) | ((f30g[(i >> 8) & 255] & 255) << 8)) | ((f30g[(i >> 16) & 255] & 255) << 16)) | (f30g[i >>> 24] << 24);
    }

    /* renamed from: a */
    private static int m34a(int i, int i2) {
        return (i >>> i2) | (i << (-i2));
    }

    /* renamed from: a */
    private int[][] m35a(byte[] bArr) {
        int i = 0;
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && (length << 2) == bArr.length) {
            this.f33a = length + 6;
            int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.f33a + 1, 4});
            int i2 = 0;
            while (i < bArr.length) {
                iArr[i2 >> 2][i2 & 3] = (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | (bArr[i + 3] << 24);
                i += 4;
                i2++;
            }
            int i3 = (this.f33a + 1) << 2;
            i2 = length;
            while (i2 < i3) {
                i = iArr[(i2 - 1) >> 2][(i2 - 1) & 3];
                if (i2 % length == 0) {
                    i = C0007a.m33a(C0007a.m34a(i, 8)) ^ f31h[(i2 / length) - 1];
                } else if (length > 6 && i2 % length == 4) {
                    i = C0007a.m33a(i);
                }
                iArr[i2 >> 2][i2 & 3] = i ^ iArr[(i2 - length) >> 2][(i2 - length) & 3];
                i2++;
            }
            return iArr;
        }
        throw new C0010a("invalid key length (not 128/192/256)");
    }

    /* renamed from: a */
    public final int mo20a(byte[] bArr, byte[] bArr2) {
        if (this.f34b == null) {
            throw new C0010a("AES engine not initialised");
        } else if (16 > bArr.length) {
            throw new C0010a("input buffer too short");
        } else if (16 > bArr2.length) {
            throw new C0010a("output buffer too short");
        } else {
            int a;
            int a2;
            int a3;
            int i;
            this.f35c = bArr[0] & 255;
            this.f35c |= (bArr[1] & 255) << 8;
            this.f35c |= (bArr[2] & 255) << 16;
            this.f35c |= bArr[3] << 24;
            this.f36d = bArr[4] & 255;
            this.f36d |= (bArr[5] & 255) << 8;
            this.f36d |= (bArr[6] & 255) << 16;
            this.f36d |= bArr[7] << 24;
            this.f37e = bArr[8] & 255;
            this.f37e |= (bArr[9] & 255) << 8;
            this.f37e |= (bArr[10] & 255) << 16;
            this.f37e |= bArr[11] << 24;
            this.f38f = bArr[12] & 255;
            this.f38f |= (bArr[13] & 255) << 8;
            this.f38f |= (bArr[14] & 255) << 16;
            this.f38f |= bArr[15] << 24;
            int[][] iArr = this.f34b;
            this.f35c ^= iArr[0][0];
            this.f36d ^= iArr[0][1];
            this.f37e ^= iArr[0][2];
            this.f38f ^= iArr[0][3];
            int i2 = 1;
            while (i2 < this.f33a - 1) {
                a = (((f32i[this.f35c & 255] ^ C0007a.m34a(f32i[(this.f36d >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f37e >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f38f >>> 24], 8)) ^ iArr[i2][0];
                a2 = (((f32i[this.f36d & 255] ^ C0007a.m34a(f32i[(this.f37e >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f38f >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f35c >>> 24], 8)) ^ iArr[i2][1];
                a3 = (((f32i[this.f37e & 255] ^ C0007a.m34a(f32i[(this.f38f >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f35c >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f36d >>> 24], 8)) ^ iArr[i2][2];
                i = i2 + 1;
                i2 = iArr[i2][3] ^ (((f32i[this.f38f & 255] ^ C0007a.m34a(f32i[(this.f35c >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f36d >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f37e >>> 24], 8));
                this.f35c = (((f32i[a & 255] ^ C0007a.m34a(f32i[(a2 >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(a3 >> 16) & 255], 16)) ^ C0007a.m34a(f32i[i2 >>> 24], 8)) ^ iArr[i][0];
                this.f36d = (((f32i[a2 & 255] ^ C0007a.m34a(f32i[(a3 >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(i2 >> 16) & 255], 16)) ^ C0007a.m34a(f32i[a >>> 24], 8)) ^ iArr[i][1];
                this.f37e = (((f32i[a3 & 255] ^ C0007a.m34a(f32i[(i2 >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(a >> 16) & 255], 16)) ^ C0007a.m34a(f32i[a2 >>> 24], 8)) ^ iArr[i][2];
                a = C0007a.m34a(f32i[a3 >>> 24], 8) ^ ((f32i[i2 & 255] ^ C0007a.m34a(f32i[(a >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(a2 >> 16) & 255], 16));
                i2 = i + 1;
                this.f38f = a ^ iArr[i][3];
            }
            a = (((f32i[this.f35c & 255] ^ C0007a.m34a(f32i[(this.f36d >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f37e >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f38f >>> 24], 8)) ^ iArr[i2][0];
            a2 = (((f32i[this.f36d & 255] ^ C0007a.m34a(f32i[(this.f37e >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f38f >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f35c >>> 24], 8)) ^ iArr[i2][1];
            a3 = (((f32i[this.f37e & 255] ^ C0007a.m34a(f32i[(this.f38f >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f35c >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f36d >>> 24], 8)) ^ iArr[i2][2];
            i = i2 + 1;
            i2 = iArr[i2][3] ^ (((f32i[this.f38f & 255] ^ C0007a.m34a(f32i[(this.f35c >> 8) & 255], 24)) ^ C0007a.m34a(f32i[(this.f36d >> 16) & 255], 16)) ^ C0007a.m34a(f32i[this.f37e >>> 24], 8));
            this.f35c = ((((f30g[a & 255] & 255) ^ ((f30g[(a2 >> 8) & 255] & 255) << 8)) ^ ((f30g[(a3 >> 16) & 255] & 255) << 16)) ^ (f30g[i2 >>> 24] << 24)) ^ iArr[i][0];
            this.f36d = ((((f30g[a2 & 255] & 255) ^ ((f30g[(a3 >> 8) & 255] & 255) << 8)) ^ ((f30g[(i2 >> 16) & 255] & 255) << 16)) ^ (f30g[a >>> 24] << 24)) ^ iArr[i][1];
            this.f37e = ((((f30g[a3 & 255] & 255) ^ ((f30g[(i2 >> 8) & 255] & 255) << 8)) ^ ((f30g[(a >> 16) & 255] & 255) << 16)) ^ (f30g[a2 >>> 24] << 24)) ^ iArr[i][2];
            this.f38f = ((((f30g[i2 & 255] & 255) ^ ((f30g[(a >> 8) & 255] & 255) << 8)) ^ ((f30g[(a2 >> 16) & 255] & 255) << 16)) ^ (f30g[a3 >>> 24] << 24)) ^ iArr[i][3];
            bArr2[0] = (byte) this.f35c;
            bArr2[1] = (byte) (this.f35c >> 8);
            bArr2[2] = (byte) (this.f35c >> 16);
            bArr2[3] = this.f35c >> 24;
            bArr2[4] = (byte) this.f36d;
            bArr2[5] = (byte) (this.f36d >> 8);
            bArr2[6] = (byte) (this.f36d >> 16);
            bArr2[7] = this.f36d >> 24;
            bArr2[8] = (byte) this.f37e;
            bArr2[9] = (byte) (this.f37e >> 8);
            bArr2[10] = (byte) (this.f37e >> 16);
            bArr2[11] = this.f37e >> 24;
            bArr2[12] = (byte) this.f38f;
            bArr2[13] = (byte) (this.f38f >> 8);
            bArr2[14] = (byte) (this.f38f >> 16);
            bArr2[15] = this.f38f >> 24;
            return 16;
        }
    }
}