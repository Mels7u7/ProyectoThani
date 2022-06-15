package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class petitorioloaddvcombo extends GXProcedure
{
   public petitorioloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitorioloaddvcombo.class ), "" );
   }

   public petitorioloaddvcombo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      petitorioloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      petitorioloaddvcombo.this.AV17ComboName = aP0;
      petitorioloaddvcombo.this.AV19TrnMode = aP1;
      petitorioloaddvcombo.this.AV21IsDynamicCall = aP2;
      petitorioloaddvcombo.this.AV27PetitorioId = aP3;
      petitorioloaddvcombo.this.AV12SearchTxt = aP4;
      petitorioloaddvcombo.this.aP5 = aP5;
      petitorioloaddvcombo.this.aP6 = aP6;
      petitorioloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio", GXv_boolean2) ;
      petitorioloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "DrogueriaId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_DROGUERIAID' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "PetitorioSubCategId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PETITORIOSUBCATEGID' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "FormaFarmaceuticaId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_FORMAFARMACEUTICAID' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_DROGUERIAID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A141DrogueriaNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003D2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A141DrogueriaNombre = P003D2_A141DrogueriaNombre[0] ;
            A36DrogueriaId = P003D2_A36DrogueriaId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A36DrogueriaId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A141DrogueriaNombre );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003D3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV27PetitorioId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A25PetitorioId = P003D3_A25PetitorioId[0] ;
                  A36DrogueriaId = P003D3_A36DrogueriaId[0] ;
                  A141DrogueriaNombre = P003D3_A141DrogueriaNombre[0] ;
                  A141DrogueriaNombre = P003D3_A141DrogueriaNombre[0] ;
                  AV16SelectedValue = ((0==A36DrogueriaId) ? "" : GXutil.trim( GXutil.str( A36DrogueriaId, 4, 0))) ;
                  AV22SelectedText = A141DrogueriaNombre ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV24DrogueriaId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P003D4 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV24DrogueriaId)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A36DrogueriaId = P003D4_A36DrogueriaId[0] ;
                  A141DrogueriaNombre = P003D4_A141DrogueriaNombre[0] ;
                  AV22SelectedText = A141DrogueriaNombre ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
            }
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_PETITORIOSUBCATEGID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A265PetitorioSubCategNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003D5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A265PetitorioSubCategNombre = P003D5_A265PetitorioSubCategNombre[0] ;
            A48PetitorioSubCategId = P003D5_A48PetitorioSubCategId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A48PetitorioSubCategId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A265PetitorioSubCategNombre );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P003D6 */
               pr_default.execute(4, new Object[] {Short.valueOf(AV27PetitorioId)});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A25PetitorioId = P003D6_A25PetitorioId[0] ;
                  A48PetitorioSubCategId = P003D6_A48PetitorioSubCategId[0] ;
                  A265PetitorioSubCategNombre = P003D6_A265PetitorioSubCategNombre[0] ;
                  A265PetitorioSubCategNombre = P003D6_A265PetitorioSubCategNombre[0] ;
                  AV16SelectedValue = ((0==A48PetitorioSubCategId) ? "" : GXutil.trim( GXutil.str( A48PetitorioSubCategId, 4, 0))) ;
                  AV22SelectedText = A265PetitorioSubCategNombre ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV25PetitorioSubCategId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P003D7 */
               pr_default.execute(5, new Object[] {Short.valueOf(AV25PetitorioSubCategId)});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A48PetitorioSubCategId = P003D7_A48PetitorioSubCategId[0] ;
                  A265PetitorioSubCategNombre = P003D7_A265PetitorioSubCategNombre[0] ;
                  AV22SelectedText = A265PetitorioSubCategNombre ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(5);
            }
         }
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_FORMAFARMACEUTICAID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(6, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              Short.valueOf(A39FormaFarmaceuticaId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003D8 */
         pr_default.execute(6, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A39FormaFarmaceuticaId = P003D8_A39FormaFarmaceuticaId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A39FormaFarmaceuticaId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9")) );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(6);
         }
         pr_default.close(6);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            /* Using cursor P003D9 */
            pr_default.execute(7, new Object[] {Short.valueOf(AV27PetitorioId)});
            while ( (pr_default.getStatus(7) != 101) )
            {
               A25PetitorioId = P003D9_A25PetitorioId[0] ;
               A39FormaFarmaceuticaId = P003D9_A39FormaFarmaceuticaId[0] ;
               AV16SelectedValue = ((0==A39FormaFarmaceuticaId) ? "" : GXutil.trim( GXutil.str( A39FormaFarmaceuticaId, 4, 0))) ;
               AV22SelectedText = AV16SelectedValue ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(7);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = petitorioloaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = petitorioloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = petitorioloaddvcombo.this.AV13Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16SelectedValue = "" ;
      AV22SelectedText = "" ;
      AV13Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A141DrogueriaNombre = "" ;
      P003D2_A141DrogueriaNombre = new String[] {""} ;
      P003D2_A36DrogueriaId = new short[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P003D3_A25PetitorioId = new short[1] ;
      P003D3_A36DrogueriaId = new short[1] ;
      P003D3_A141DrogueriaNombre = new String[] {""} ;
      P003D4_A36DrogueriaId = new short[1] ;
      P003D4_A141DrogueriaNombre = new String[] {""} ;
      A265PetitorioSubCategNombre = "" ;
      P003D5_A265PetitorioSubCategNombre = new String[] {""} ;
      P003D5_A48PetitorioSubCategId = new short[1] ;
      P003D6_A25PetitorioId = new short[1] ;
      P003D6_A48PetitorioSubCategId = new short[1] ;
      P003D6_A265PetitorioSubCategNombre = new String[] {""} ;
      P003D7_A48PetitorioSubCategId = new short[1] ;
      P003D7_A265PetitorioSubCategNombre = new String[] {""} ;
      P003D8_A39FormaFarmaceuticaId = new short[1] ;
      P003D9_A25PetitorioId = new short[1] ;
      P003D9_A39FormaFarmaceuticaId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitorioloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P003D2_A141DrogueriaNombre, P003D2_A36DrogueriaId
            }
            , new Object[] {
            P003D3_A25PetitorioId, P003D3_A36DrogueriaId, P003D3_A141DrogueriaNombre
            }
            , new Object[] {
            P003D4_A36DrogueriaId, P003D4_A141DrogueriaNombre
            }
            , new Object[] {
            P003D5_A265PetitorioSubCategNombre, P003D5_A48PetitorioSubCategId
            }
            , new Object[] {
            P003D6_A25PetitorioId, P003D6_A48PetitorioSubCategId, P003D6_A265PetitorioSubCategNombre
            }
            , new Object[] {
            P003D7_A48PetitorioSubCategId, P003D7_A265PetitorioSubCategNombre
            }
            , new Object[] {
            P003D8_A39FormaFarmaceuticaId
            }
            , new Object[] {
            P003D9_A25PetitorioId, P003D9_A39FormaFarmaceuticaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV27PetitorioId ;
   private short A36DrogueriaId ;
   private short A25PetitorioId ;
   private short AV24DrogueriaId ;
   private short A48PetitorioSubCategId ;
   private short AV25PetitorioSubCategId ;
   private short A39FormaFarmaceuticaId ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV19TrnMode ;
   private String scmdbuf ;
   private boolean AV21IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A141DrogueriaNombre ;
   private String A265PetitorioSubCategNombre ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P003D2_A141DrogueriaNombre ;
   private short[] P003D2_A36DrogueriaId ;
   private short[] P003D3_A25PetitorioId ;
   private short[] P003D3_A36DrogueriaId ;
   private String[] P003D3_A141DrogueriaNombre ;
   private short[] P003D4_A36DrogueriaId ;
   private String[] P003D4_A141DrogueriaNombre ;
   private String[] P003D5_A265PetitorioSubCategNombre ;
   private short[] P003D5_A48PetitorioSubCategId ;
   private short[] P003D6_A25PetitorioId ;
   private short[] P003D6_A48PetitorioSubCategId ;
   private String[] P003D6_A265PetitorioSubCategNombre ;
   private short[] P003D7_A48PetitorioSubCategId ;
   private String[] P003D7_A265PetitorioSubCategNombre ;
   private short[] P003D8_A39FormaFarmaceuticaId ;
   private short[] P003D9_A25PetitorioId ;
   private short[] P003D9_A39FormaFarmaceuticaId ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class petitorioloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003D2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A141DrogueriaNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [DrogueriaNombre], [DrogueriaId] FROM [Drogueria]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DrogueriaNombre]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003D5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A265PetitorioSubCategNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [PetitorioSubCategNombre], [PetitorioSubCategId] FROM [PetitorioSubCateg]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([PetitorioSubCategNombre] like '%' + ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [PetitorioSubCategNombre]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P003D8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          short A39FormaFarmaceuticaId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT [FormaFarmaceuticaId] FROM [FormaFarmaceutica]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(CONVERT( char(4), CAST([FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [FormaFarmaceuticaId]" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P003D2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P003D5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 6 :
                  return conditional_P003D8(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003D2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003D3", "SELECT T1.[PetitorioId], T1.[DrogueriaId], T2.[DrogueriaNombre] FROM ([Petitorio] T1 INNER JOIN [Drogueria] T2 ON T2.[DrogueriaId] = T1.[DrogueriaId]) WHERE T1.[PetitorioId] = ? ORDER BY T1.[PetitorioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003D4", "SELECT TOP 1 [DrogueriaId], [DrogueriaNombre] FROM [Drogueria] WHERE [DrogueriaId] = ? ORDER BY [DrogueriaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003D5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003D6", "SELECT T1.[PetitorioId], T1.[PetitorioSubCategId], T2.[PetitorioSubCategNombre] FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId] = T1.[PetitorioSubCategId]) WHERE T1.[PetitorioId] = ? ORDER BY T1.[PetitorioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003D7", "SELECT TOP 1 [PetitorioSubCategId], [PetitorioSubCategNombre] FROM [PetitorioSubCateg] WHERE [PetitorioSubCategId] = ? ORDER BY [PetitorioSubCategId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003D8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003D9", "SELECT [PetitorioId], [FormaFarmaceuticaId] FROM [Petitorio] WHERE [PetitorioId] = ? ORDER BY [PetitorioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

