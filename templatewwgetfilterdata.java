package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class templatewwgetfilterdata extends GXProcedure
{
   public templatewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( templatewwgetfilterdata.class ), "" );
   }

   public templatewwgetfilterdata( int remoteHandle ,
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
      templatewwgetfilterdata.this.aP5 = new String[] {""};
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
      templatewwgetfilterdata.this.AV21DDOName = aP0;
      templatewwgetfilterdata.this.AV19SearchTxt = aP1;
      templatewwgetfilterdata.this.AV20SearchTxtTo = aP2;
      templatewwgetfilterdata.this.aP3 = aP3;
      templatewwgetfilterdata.this.aP4 = aP4;
      templatewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTemplate", GXv_boolean2) ;
      templatewwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV21DDOName), "DDO_TEMPLATECODE") == 0 )
         {
            /* Execute user subroutine: 'LOADTEMPLATECODEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV25OptionsJson = AV24Options.toJSonString(false) ;
      AV28OptionsDescJson = AV27OptionsDesc.toJSonString(false) ;
      AV30OptionIndexesJson = AV29OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV32Session.getValue("TemplateWWGridState"), "") == 0 )
      {
         AV34GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TemplateWWGridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV32Session.getValue("TemplateWWGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV37FilterFullText = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPLATEID") == 0 )
         {
            AV11TFTemplateId = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFTemplateId_To = (short)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPLATECODE") == 0 )
         {
            AV13TFTemplateCode = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPLATECODE_SEL") == 0 )
         {
            AV14TFTemplateCode_Sel = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTEMPLATESTATUS_SEL") == 0 )
         {
            AV17TFTemplateStatus_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFTemplateStatus_Sels.fromJSonString(AV17TFTemplateStatus_SelsJson, null);
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTEMPLATECODEOPTIONS' Routine */
      returnInSub = false ;
      AV13TFTemplateCode = AV19SearchTxt ;
      AV14TFTemplateCode_Sel = "" ;
      AV42Templatewwds_1_filterfulltext = AV37FilterFullText ;
      AV43Templatewwds_2_tftemplateid = AV11TFTemplateId ;
      AV44Templatewwds_3_tftemplateid_to = AV12TFTemplateId_To ;
      AV45Templatewwds_4_tftemplatecode = AV13TFTemplateCode ;
      AV46Templatewwds_5_tftemplatecode_sel = AV14TFTemplateCode_Sel ;
      AV47Templatewwds_6_tftemplatestatus_sels = AV18TFTemplateStatus_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A293TemplateStatus ,
                                           AV47Templatewwds_6_tftemplatestatus_sels ,
                                           AV42Templatewwds_1_filterfulltext ,
                                           Short.valueOf(AV43Templatewwds_2_tftemplateid) ,
                                           Short.valueOf(AV44Templatewwds_3_tftemplateid_to) ,
                                           AV46Templatewwds_5_tftemplatecode_sel ,
                                           AV45Templatewwds_4_tftemplatecode ,
                                           Integer.valueOf(AV47Templatewwds_6_tftemplatestatus_sels.size()) ,
                                           Short.valueOf(A53TemplateId) ,
                                           A291TemplateCode } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV42Templatewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Templatewwds_1_filterfulltext), "%", "") ;
      lV42Templatewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Templatewwds_1_filterfulltext), "%", "") ;
      lV42Templatewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Templatewwds_1_filterfulltext), "%", "") ;
      lV42Templatewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Templatewwds_1_filterfulltext), "%", "") ;
      lV45Templatewwds_4_tftemplatecode = GXutil.concat( GXutil.rtrim( AV45Templatewwds_4_tftemplatecode), "%", "") ;
      /* Using cursor P003R2 */
      pr_default.execute(0, new Object[] {lV42Templatewwds_1_filterfulltext, lV42Templatewwds_1_filterfulltext, lV42Templatewwds_1_filterfulltext, lV42Templatewwds_1_filterfulltext, Short.valueOf(AV43Templatewwds_2_tftemplateid), Short.valueOf(AV44Templatewwds_3_tftemplateid_to), lV45Templatewwds_4_tftemplatecode, AV46Templatewwds_5_tftemplatecode_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3R2 = false ;
         A291TemplateCode = P003R2_A291TemplateCode[0] ;
         A53TemplateId = P003R2_A53TemplateId[0] ;
         A293TemplateStatus = P003R2_A293TemplateStatus[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P003R2_A291TemplateCode[0], A291TemplateCode) == 0 ) )
         {
            brk3R2 = false ;
            A53TemplateId = P003R2_A53TemplateId[0] ;
            AV31count = (long)(AV31count+1) ;
            brk3R2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A291TemplateCode)==0) )
         {
            AV23Option = A291TemplateCode ;
            AV24Options.add(AV23Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3R2 )
         {
            brk3R2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = templatewwgetfilterdata.this.AV25OptionsJson;
      this.aP4[0] = templatewwgetfilterdata.this.AV28OptionsDescJson;
      this.aP5[0] = templatewwgetfilterdata.this.AV30OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25OptionsJson = "" ;
      AV28OptionsDescJson = "" ;
      AV30OptionIndexesJson = "" ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV32Session = httpContext.getWebSession();
      AV34GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV35GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37FilterFullText = "" ;
      AV13TFTemplateCode = "" ;
      AV14TFTemplateCode_Sel = "" ;
      AV17TFTemplateStatus_SelsJson = "" ;
      AV18TFTemplateStatus_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A291TemplateCode = "" ;
      AV42Templatewwds_1_filterfulltext = "" ;
      AV45Templatewwds_4_tftemplatecode = "" ;
      AV46Templatewwds_5_tftemplatecode_sel = "" ;
      AV47Templatewwds_6_tftemplatestatus_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV42Templatewwds_1_filterfulltext = "" ;
      lV45Templatewwds_4_tftemplatecode = "" ;
      A293TemplateStatus = "" ;
      P003R2_A291TemplateCode = new String[] {""} ;
      P003R2_A53TemplateId = new short[1] ;
      P003R2_A293TemplateStatus = new String[] {""} ;
      AV23Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.templatewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003R2_A291TemplateCode, P003R2_A53TemplateId, P003R2_A293TemplateStatus
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFTemplateId ;
   private short AV12TFTemplateId_To ;
   private short AV43Templatewwds_2_tftemplateid ;
   private short AV44Templatewwds_3_tftemplateid_to ;
   private short A53TemplateId ;
   private short Gx_err ;
   private int AV40GXV1 ;
   private int AV47Templatewwds_6_tftemplatestatus_sels_size ;
   private long AV31count ;
   private String scmdbuf ;
   private String A293TemplateStatus ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3R2 ;
   private String AV25OptionsJson ;
   private String AV28OptionsDescJson ;
   private String AV30OptionIndexesJson ;
   private String AV17TFTemplateStatus_SelsJson ;
   private String AV21DDOName ;
   private String AV19SearchTxt ;
   private String AV20SearchTxtTo ;
   private String AV37FilterFullText ;
   private String AV13TFTemplateCode ;
   private String AV14TFTemplateCode_Sel ;
   private String A291TemplateCode ;
   private String AV42Templatewwds_1_filterfulltext ;
   private String AV45Templatewwds_4_tftemplatecode ;
   private String AV46Templatewwds_5_tftemplatecode_sel ;
   private String lV42Templatewwds_1_filterfulltext ;
   private String lV45Templatewwds_4_tftemplatecode ;
   private String AV23Option ;
   private com.genexus.webpanels.WebSession AV32Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P003R2_A291TemplateCode ;
   private short[] P003R2_A53TemplateId ;
   private String[] P003R2_A293TemplateStatus ;
   private GXSimpleCollection<String> AV18TFTemplateStatus_Sels ;
   private GXSimpleCollection<String> AV47Templatewwds_6_tftemplatestatus_sels ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class templatewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003R2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A293TemplateStatus ,
                                          GXSimpleCollection<String> AV47Templatewwds_6_tftemplatestatus_sels ,
                                          String AV42Templatewwds_1_filterfulltext ,
                                          short AV43Templatewwds_2_tftemplateid ,
                                          short AV44Templatewwds_3_tftemplateid_to ,
                                          String AV46Templatewwds_5_tftemplatecode_sel ,
                                          String AV45Templatewwds_4_tftemplatecode ,
                                          int AV47Templatewwds_6_tftemplatestatus_sels_size ,
                                          short A53TemplateId ,
                                          String A291TemplateCode )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [TemplateCode], [TemplateId], [TemplateStatus] FROM [Template]" ;
      if ( ! (GXutil.strcmp("", AV42Templatewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([TemplateId] AS decimal(4,0))) like '%' + ?) or ( [TemplateCode] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [TemplateStatus] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [TemplateStatus] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV43Templatewwds_2_tftemplateid) )
      {
         addWhere(sWhereString, "([TemplateId] >= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (0==AV44Templatewwds_3_tftemplateid_to) )
      {
         addWhere(sWhereString, "([TemplateId] <= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV46Templatewwds_5_tftemplatecode_sel)==0) && ( ! (GXutil.strcmp("", AV45Templatewwds_4_tftemplatecode)==0) ) )
      {
         addWhere(sWhereString, "([TemplateCode] like ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV46Templatewwds_5_tftemplatecode_sel)==0) )
      {
         addWhere(sWhereString, "([TemplateCode] = ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV47Templatewwds_6_tftemplatestatus_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV47Templatewwds_6_tftemplatestatus_sels, "[TemplateStatus] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [TemplateCode]" ;
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
                  return conditional_P003R2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , (String)dynConstraints[9] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003R2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               return;
      }
   }

}

