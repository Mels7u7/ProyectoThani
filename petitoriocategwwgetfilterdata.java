package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class petitoriocategwwgetfilterdata extends GXProcedure
{
   public petitoriocategwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitoriocategwwgetfilterdata.class ), "" );
   }

   public petitoriocategwwgetfilterdata( int remoteHandle ,
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
      petitoriocategwwgetfilterdata.this.aP5 = new String[] {""};
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
      petitoriocategwwgetfilterdata.this.AV17DDOName = aP0;
      petitoriocategwwgetfilterdata.this.AV15SearchTxt = aP1;
      petitoriocategwwgetfilterdata.this.AV16SearchTxtTo = aP2;
      petitoriocategwwgetfilterdata.this.aP3 = aP3;
      petitoriocategwwgetfilterdata.this.aP4 = aP4;
      petitoriocategwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioCateg", GXv_boolean2) ;
      petitoriocategwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_PETITORIOCATEGNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADPETITORIOCATEGNOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV21OptionsJson = AV20Options.toJSonString(false) ;
      AV24OptionsDescJson = AV23OptionsDesc.toJSonString(false) ;
      AV26OptionIndexesJson = AV25OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("PetitorioCategWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PetitorioCategWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("PetitorioCategWWGridState"), null, null);
      }
      AV36GXV1 = 1 ;
      while ( AV36GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV36GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV33FilterFullText = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV11TFPetitorioCategId = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPetitorioCategId_To = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE") == 0 )
         {
            AV13TFPetitorioCategNombre = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE_SEL") == 0 )
         {
            AV14TFPetitorioCategNombre_Sel = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV36GXV1 = (int)(AV36GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPETITORIOCATEGNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV13TFPetitorioCategNombre = AV15SearchTxt ;
      AV14TFPetitorioCategNombre_Sel = "" ;
      AV38Petitoriocategwwds_1_filterfulltext = AV33FilterFullText ;
      AV39Petitoriocategwwds_2_tfpetitoriocategid = AV11TFPetitorioCategId ;
      AV40Petitoriocategwwds_3_tfpetitoriocategid_to = AV12TFPetitorioCategId_To ;
      AV41Petitoriocategwwds_4_tfpetitoriocategnombre = AV13TFPetitorioCategNombre ;
      AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel = AV14TFPetitorioCategNombre_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV38Petitoriocategwwds_1_filterfulltext ,
                                           Short.valueOf(AV39Petitoriocategwwds_2_tfpetitoriocategid) ,
                                           Short.valueOf(AV40Petitoriocategwwds_3_tfpetitoriocategid_to) ,
                                           AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel ,
                                           AV41Petitoriocategwwds_4_tfpetitoriocategnombre ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           A266PetitorioCategNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV38Petitoriocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV38Petitoriocategwwds_1_filterfulltext), "%", "") ;
      lV38Petitoriocategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV38Petitoriocategwwds_1_filterfulltext), "%", "") ;
      lV41Petitoriocategwwds_4_tfpetitoriocategnombre = GXutil.concat( GXutil.rtrim( AV41Petitoriocategwwds_4_tfpetitoriocategnombre), "%", "") ;
      /* Using cursor P003F2 */
      pr_default.execute(0, new Object[] {lV38Petitoriocategwwds_1_filterfulltext, lV38Petitoriocategwwds_1_filterfulltext, Short.valueOf(AV39Petitoriocategwwds_2_tfpetitoriocategid), Short.valueOf(AV40Petitoriocategwwds_3_tfpetitoriocategid_to), lV41Petitoriocategwwds_4_tfpetitoriocategnombre, AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3F2 = false ;
         A266PetitorioCategNombre = P003F2_A266PetitorioCategNombre[0] ;
         A49PetitorioCategId = P003F2_A49PetitorioCategId[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P003F2_A266PetitorioCategNombre[0], A266PetitorioCategNombre) == 0 ) )
         {
            brk3F2 = false ;
            A49PetitorioCategId = P003F2_A49PetitorioCategId[0] ;
            AV27count = (long)(AV27count+1) ;
            brk3F2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A266PetitorioCategNombre)==0) )
         {
            AV19Option = A266PetitorioCategNombre ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3F2 )
         {
            brk3F2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = petitoriocategwwgetfilterdata.this.AV21OptionsJson;
      this.aP4[0] = petitoriocategwwgetfilterdata.this.AV24OptionsDescJson;
      this.aP5[0] = petitoriocategwwgetfilterdata.this.AV26OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21OptionsJson = "" ;
      AV24OptionsDescJson = "" ;
      AV26OptionIndexesJson = "" ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV33FilterFullText = "" ;
      AV13TFPetitorioCategNombre = "" ;
      AV14TFPetitorioCategNombre_Sel = "" ;
      A266PetitorioCategNombre = "" ;
      AV38Petitoriocategwwds_1_filterfulltext = "" ;
      AV41Petitoriocategwwds_4_tfpetitoriocategnombre = "" ;
      AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel = "" ;
      scmdbuf = "" ;
      lV38Petitoriocategwwds_1_filterfulltext = "" ;
      lV41Petitoriocategwwds_4_tfpetitoriocategnombre = "" ;
      P003F2_A266PetitorioCategNombre = new String[] {""} ;
      P003F2_A49PetitorioCategId = new short[1] ;
      AV19Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriocategwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003F2_A266PetitorioCategNombre, P003F2_A49PetitorioCategId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFPetitorioCategId ;
   private short AV12TFPetitorioCategId_To ;
   private short AV39Petitoriocategwwds_2_tfpetitoriocategid ;
   private short AV40Petitoriocategwwds_3_tfpetitoriocategid_to ;
   private short A49PetitorioCategId ;
   private short Gx_err ;
   private int AV36GXV1 ;
   private long AV27count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3F2 ;
   private String AV21OptionsJson ;
   private String AV24OptionsDescJson ;
   private String AV26OptionIndexesJson ;
   private String AV17DDOName ;
   private String AV15SearchTxt ;
   private String AV16SearchTxtTo ;
   private String AV33FilterFullText ;
   private String AV13TFPetitorioCategNombre ;
   private String AV14TFPetitorioCategNombre_Sel ;
   private String A266PetitorioCategNombre ;
   private String AV38Petitoriocategwwds_1_filterfulltext ;
   private String AV41Petitoriocategwwds_4_tfpetitoriocategnombre ;
   private String AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel ;
   private String lV38Petitoriocategwwds_1_filterfulltext ;
   private String lV41Petitoriocategwwds_4_tfpetitoriocategnombre ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P003F2_A266PetitorioCategNombre ;
   private short[] P003F2_A49PetitorioCategId ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV23OptionsDesc ;
   private GXSimpleCollection<String> AV25OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class petitoriocategwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003F2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV38Petitoriocategwwds_1_filterfulltext ,
                                          short AV39Petitoriocategwwds_2_tfpetitoriocategid ,
                                          short AV40Petitoriocategwwds_3_tfpetitoriocategid_to ,
                                          String AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel ,
                                          String AV41Petitoriocategwwds_4_tfpetitoriocategnombre ,
                                          short A49PetitorioCategId ,
                                          String A266PetitorioCategNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[6];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [PetitorioCategNombre], [PetitorioCategId] FROM [PetitorioCateg]" ;
      if ( ! (GXutil.strcmp("", AV38Petitoriocategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( [PetitorioCategNombre] like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
      }
      if ( ! (0==AV39Petitoriocategwwds_2_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "([PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( ! (0==AV40Petitoriocategwwds_3_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "([PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV41Petitoriocategwwds_4_tfpetitoriocategnombre)==0) ) )
      {
         addWhere(sWhereString, "([PetitorioCategNombre] like ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV42Petitoriocategwwds_5_tfpetitoriocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "([PetitorioCategNombre] = ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [PetitorioCategNombre]" ;
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
                  return conditional_P003F2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003F2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 200);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               return;
      }
   }

}

