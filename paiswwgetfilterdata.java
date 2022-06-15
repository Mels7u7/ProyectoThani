package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paiswwgetfilterdata extends GXProcedure
{
   public paiswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paiswwgetfilterdata.class ), "" );
   }

   public paiswwgetfilterdata( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      paiswwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      paiswwgetfilterdata.this.AV19DDOName = aP0;
      paiswwgetfilterdata.this.AV17SearchTxt = aP1;
      paiswwgetfilterdata.this.AV18SearchTxtTo = aP2;
      paiswwgetfilterdata.this.aP3 = aP3;
      paiswwgetfilterdata.this.aP4 = aP4;
      paiswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais", GXv_boolean2) ;
      paiswwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_PAISDESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADPAISDESCRIPCIONOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV23OptionsJson = AV22Options.toJSonString(false) ;
      AV26OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV28OptionIndexesJson = AV27OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("PaisWWGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PaisWWGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("PaisWWGridState"), null, null);
      }
      AV38GXV1 = 1 ;
      while ( AV38GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV38GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV35FilterFullText = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISID") == 0 )
         {
            AV11TFPaisId = (short)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPaisId_To = (short)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION") == 0 )
         {
            AV13TFPaisDescripcion = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISDESCRIPCION_SEL") == 0 )
         {
            AV14TFPaisDescripcion_Sel = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAISESTADO_SEL") == 0 )
         {
            AV15TFPaisEstado_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFPaisEstado_Sels.fromJSonString(AV15TFPaisEstado_SelsJson, null);
         }
         AV38GXV1 = (int)(AV38GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPAISDESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV13TFPaisDescripcion = AV17SearchTxt ;
      AV14TFPaisDescripcion_Sel = "" ;
      AV40Paiswwds_1_filterfulltext = AV35FilterFullText ;
      AV41Paiswwds_2_tfpaisid = AV11TFPaisId ;
      AV42Paiswwds_3_tfpaisid_to = AV12TFPaisId_To ;
      AV43Paiswwds_4_tfpaisdescripcion = AV13TFPaisDescripcion ;
      AV44Paiswwds_5_tfpaisdescripcion_sel = AV14TFPaisDescripcion_Sel ;
      AV45Paiswwds_6_tfpaisestado_sels = AV16TFPaisEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A259PaisEstado ,
                                           AV45Paiswwds_6_tfpaisestado_sels ,
                                           AV40Paiswwds_1_filterfulltext ,
                                           Short.valueOf(AV41Paiswwds_2_tfpaisid) ,
                                           Short.valueOf(AV42Paiswwds_3_tfpaisid_to) ,
                                           AV44Paiswwds_5_tfpaisdescripcion_sel ,
                                           AV43Paiswwds_4_tfpaisdescripcion ,
                                           Integer.valueOf(AV45Paiswwds_6_tfpaisestado_sels.size()) ,
                                           Short.valueOf(A43PaisId) ,
                                           A184PaisDescripcion } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV40Paiswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV40Paiswwds_1_filterfulltext), "%", "") ;
      lV40Paiswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV40Paiswwds_1_filterfulltext), "%", "") ;
      lV40Paiswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV40Paiswwds_1_filterfulltext), "%", "") ;
      lV40Paiswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV40Paiswwds_1_filterfulltext), "%", "") ;
      lV43Paiswwds_4_tfpaisdescripcion = GXutil.concat( GXutil.rtrim( AV43Paiswwds_4_tfpaisdescripcion), "%", "") ;
      /* Using cursor P003C2 */
      pr_default.execute(0, new Object[] {lV40Paiswwds_1_filterfulltext, lV40Paiswwds_1_filterfulltext, lV40Paiswwds_1_filterfulltext, lV40Paiswwds_1_filterfulltext, Short.valueOf(AV41Paiswwds_2_tfpaisid), Short.valueOf(AV42Paiswwds_3_tfpaisid_to), lV43Paiswwds_4_tfpaisdescripcion, AV44Paiswwds_5_tfpaisdescripcion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3C2 = false ;
         A184PaisDescripcion = P003C2_A184PaisDescripcion[0] ;
         A43PaisId = P003C2_A43PaisId[0] ;
         A259PaisEstado = P003C2_A259PaisEstado[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P003C2_A184PaisDescripcion[0], A184PaisDescripcion) == 0 ) )
         {
            brk3C2 = false ;
            A43PaisId = P003C2_A43PaisId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk3C2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A184PaisDescripcion)==0) )
         {
            AV21Option = A184PaisDescripcion ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3C2 )
         {
            brk3C2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = paiswwgetfilterdata.this.AV23OptionsJson;
      this.aP4[0] = paiswwgetfilterdata.this.AV26OptionsDescJson;
      this.aP5[0] = paiswwgetfilterdata.this.AV28OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23OptionsJson = "" ;
      AV26OptionsDescJson = "" ;
      AV28OptionIndexesJson = "" ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35FilterFullText = "" ;
      AV13TFPaisDescripcion = "" ;
      AV14TFPaisDescripcion_Sel = "" ;
      AV15TFPaisEstado_SelsJson = "" ;
      AV16TFPaisEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A184PaisDescripcion = "" ;
      AV40Paiswwds_1_filterfulltext = "" ;
      AV43Paiswwds_4_tfpaisdescripcion = "" ;
      AV44Paiswwds_5_tfpaisdescripcion_sel = "" ;
      AV45Paiswwds_6_tfpaisestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV40Paiswwds_1_filterfulltext = "" ;
      lV43Paiswwds_4_tfpaisdescripcion = "" ;
      A259PaisEstado = "" ;
      P003C2_A184PaisDescripcion = new String[] {""} ;
      P003C2_A43PaisId = new short[1] ;
      P003C2_A259PaisEstado = new String[] {""} ;
      AV21Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.paiswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003C2_A184PaisDescripcion, P003C2_A43PaisId, P003C2_A259PaisEstado
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFPaisId ;
   private short AV12TFPaisId_To ;
   private short AV41Paiswwds_2_tfpaisid ;
   private short AV42Paiswwds_3_tfpaisid_to ;
   private short A43PaisId ;
   private short Gx_err ;
   private int AV38GXV1 ;
   private int AV45Paiswwds_6_tfpaisestado_sels_size ;
   private long AV29count ;
   private String scmdbuf ;
   private String A259PaisEstado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3C2 ;
   private String AV23OptionsJson ;
   private String AV26OptionsDescJson ;
   private String AV28OptionIndexesJson ;
   private String AV15TFPaisEstado_SelsJson ;
   private String AV19DDOName ;
   private String AV17SearchTxt ;
   private String AV18SearchTxtTo ;
   private String AV35FilterFullText ;
   private String AV13TFPaisDescripcion ;
   private String AV14TFPaisDescripcion_Sel ;
   private String A184PaisDescripcion ;
   private String AV40Paiswwds_1_filterfulltext ;
   private String AV43Paiswwds_4_tfpaisdescripcion ;
   private String AV44Paiswwds_5_tfpaisdescripcion_sel ;
   private String lV40Paiswwds_1_filterfulltext ;
   private String lV43Paiswwds_4_tfpaisdescripcion ;
   private String AV21Option ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P003C2_A184PaisDescripcion ;
   private short[] P003C2_A43PaisId ;
   private String[] P003C2_A259PaisEstado ;
   private GXSimpleCollection<String> AV16TFPaisEstado_Sels ;
   private GXSimpleCollection<String> AV45Paiswwds_6_tfpaisestado_sels ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
}

final  class paiswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003C2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A259PaisEstado ,
                                          GXSimpleCollection<String> AV45Paiswwds_6_tfpaisestado_sels ,
                                          String AV40Paiswwds_1_filterfulltext ,
                                          short AV41Paiswwds_2_tfpaisid ,
                                          short AV42Paiswwds_3_tfpaisid_to ,
                                          String AV44Paiswwds_5_tfpaisdescripcion_sel ,
                                          String AV43Paiswwds_4_tfpaisdescripcion ,
                                          int AV45Paiswwds_6_tfpaisestado_sels_size ,
                                          short A43PaisId ,
                                          String A184PaisDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [PaisDescripcion], [PaisId], [PaisEstado] FROM [Pais]" ;
      if ( ! (GXutil.strcmp("", AV40Paiswwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([PaisId] AS decimal(4,0))) like '%' + ?) or ( [PaisDescripcion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [PaisEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [PaisEstado] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV41Paiswwds_2_tfpaisid) )
      {
         addWhere(sWhereString, "([PaisId] >= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV42Paiswwds_3_tfpaisid_to) )
      {
         addWhere(sWhereString, "([PaisId] <= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV44Paiswwds_5_tfpaisdescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV43Paiswwds_4_tfpaisdescripcion)==0) ) )
      {
         addWhere(sWhereString, "([PaisDescripcion] like ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV44Paiswwds_5_tfpaisdescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([PaisDescripcion] = ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV45Paiswwds_6_tfpaisestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV45Paiswwds_6_tfpaisestado_sels, "[PaisEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [PaisDescripcion]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P003C2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , (String)dynConstraints[9] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003C2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 80);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               return;
      }
   }

}

