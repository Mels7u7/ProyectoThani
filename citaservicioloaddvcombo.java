package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class citaservicioloaddvcombo extends GXProcedure
{
   public citaservicioloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citaservicioloaddvcombo.class ), "" );
   }

   public citaservicioloaddvcombo( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      citaservicioloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
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
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      citaservicioloaddvcombo.this.AV17ComboName = aP0;
      citaservicioloaddvcombo.this.AV19TrnMode = aP1;
      citaservicioloaddvcombo.this.AV21IsDynamicCall = aP2;
      citaservicioloaddvcombo.this.AV26CitaServicioId = aP3;
      citaservicioloaddvcombo.this.AV12SearchTxt = aP4;
      citaservicioloaddvcombo.this.aP5 = aP5;
      citaservicioloaddvcombo.this.aP6 = aP6;
      citaservicioloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCitaServicio", GXv_boolean2) ;
      citaservicioloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "CitaId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CITAID' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "ServicioId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SERVICIOID' */
            S121 ();
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
      /* 'LOADCOMBOITEMS_CITAID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A64CitaCode } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P002S2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A64CitaCode = P002S2_A64CitaCode[0] ;
            A19CitaId = P002S2_A19CitaId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A19CitaId, 8, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A64CitaCode );
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
               /* Using cursor P002S3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV26CitaServicioId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A26CitaServicioId = P002S3_A26CitaServicioId[0] ;
                  A19CitaId = P002S3_A19CitaId[0] ;
                  A64CitaCode = P002S3_A64CitaCode[0] ;
                  A64CitaCode = P002S3_A64CitaCode[0] ;
                  AV16SelectedValue = ((0==A19CitaId) ? "" : GXutil.trim( GXutil.str( A19CitaId, 8, 0))) ;
                  AV22SelectedText = A64CitaCode ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV24CitaId = (int)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P002S4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV24CitaId)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A19CitaId = P002S4_A19CitaId[0] ;
                  A64CitaCode = P002S4_A64CitaCode[0] ;
                  AV22SelectedText = A64CitaCode ;
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
      /* 'LOADCOMBOITEMS_SERVICIOID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A281ServicioNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P002S5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A281ServicioNombre = P002S5_A281ServicioNombre[0] ;
            A27ServicioId = P002S5_A27ServicioId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A27ServicioId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A281ServicioNombre );
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
               /* Using cursor P002S6 */
               pr_default.execute(4, new Object[] {Integer.valueOf(AV26CitaServicioId)});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A26CitaServicioId = P002S6_A26CitaServicioId[0] ;
                  A27ServicioId = P002S6_A27ServicioId[0] ;
                  A281ServicioNombre = P002S6_A281ServicioNombre[0] ;
                  A281ServicioNombre = P002S6_A281ServicioNombre[0] ;
                  AV16SelectedValue = ((0==A27ServicioId) ? "" : GXutil.trim( GXutil.str( A27ServicioId, 4, 0))) ;
                  AV22SelectedText = A281ServicioNombre ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV25ServicioId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P002S7 */
               pr_default.execute(5, new Object[] {Short.valueOf(AV25ServicioId)});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A27ServicioId = P002S7_A27ServicioId[0] ;
                  A281ServicioNombre = P002S7_A281ServicioNombre[0] ;
                  AV22SelectedText = A281ServicioNombre ;
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

   protected void cleanup( )
   {
      this.aP5[0] = citaservicioloaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = citaservicioloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = citaservicioloaddvcombo.this.AV13Combo_DataJson;
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
      A64CitaCode = "" ;
      P002S2_A64CitaCode = new String[] {""} ;
      P002S2_A19CitaId = new int[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P002S3_A26CitaServicioId = new int[1] ;
      P002S3_A19CitaId = new int[1] ;
      P002S3_A64CitaCode = new String[] {""} ;
      P002S4_A19CitaId = new int[1] ;
      P002S4_A64CitaCode = new String[] {""} ;
      A281ServicioNombre = "" ;
      P002S5_A281ServicioNombre = new String[] {""} ;
      P002S5_A27ServicioId = new short[1] ;
      P002S6_A26CitaServicioId = new int[1] ;
      P002S6_A27ServicioId = new short[1] ;
      P002S6_A281ServicioNombre = new String[] {""} ;
      P002S7_A27ServicioId = new short[1] ;
      P002S7_A281ServicioNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citaservicioloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P002S2_A64CitaCode, P002S2_A19CitaId
            }
            , new Object[] {
            P002S3_A26CitaServicioId, P002S3_A19CitaId, P002S3_A64CitaCode
            }
            , new Object[] {
            P002S4_A19CitaId, P002S4_A64CitaCode
            }
            , new Object[] {
            P002S5_A281ServicioNombre, P002S5_A27ServicioId
            }
            , new Object[] {
            P002S6_A26CitaServicioId, P002S6_A27ServicioId, P002S6_A281ServicioNombre
            }
            , new Object[] {
            P002S7_A27ServicioId, P002S7_A281ServicioNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A27ServicioId ;
   private short AV25ServicioId ;
   private short Gx_err ;
   private int AV26CitaServicioId ;
   private int AV11MaxItems ;
   private int A19CitaId ;
   private int A26CitaServicioId ;
   private int AV24CitaId ;
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
   private String A64CitaCode ;
   private String A281ServicioNombre ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P002S2_A64CitaCode ;
   private int[] P002S2_A19CitaId ;
   private int[] P002S3_A26CitaServicioId ;
   private int[] P002S3_A19CitaId ;
   private String[] P002S3_A64CitaCode ;
   private int[] P002S4_A19CitaId ;
   private String[] P002S4_A64CitaCode ;
   private String[] P002S5_A281ServicioNombre ;
   private short[] P002S5_A27ServicioId ;
   private int[] P002S6_A26CitaServicioId ;
   private short[] P002S6_A27ServicioId ;
   private String[] P002S6_A281ServicioNombre ;
   private short[] P002S7_A27ServicioId ;
   private String[] P002S7_A281ServicioNombre ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class citaservicioloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002S2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A64CitaCode )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [CitaCode], [CitaId] FROM [Cita]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([CitaCode] like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [CitaCode]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002S5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A281ServicioNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [ServicioNombre], [ServicioId] FROM [Servicio]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([ServicioNombre] like '%' + ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ServicioNombre]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P002S2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P002S5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002S2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002S3", "SELECT T1.[CitaServicioId], T1.[CitaId], T2.[CitaCode] FROM ([CitaServicio] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) WHERE T1.[CitaServicioId] = ? ORDER BY T1.[CitaServicioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002S4", "SELECT TOP 1 [CitaId], [CitaCode] FROM [Cita] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002S5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002S6", "SELECT T1.[CitaServicioId], T1.[ServicioId], T2.[ServicioNombre] FROM ([CitaServicio] T1 INNER JOIN [Servicio] T2 ON T2.[ServicioId] = T1.[ServicioId]) WHERE T1.[CitaServicioId] = ? ORDER BY T1.[CitaServicioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002S7", "SELECT TOP 1 [ServicioId], [ServicioNombre] FROM [Servicio] WHERE [ServicioId] = ? ORDER BY [ServicioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

