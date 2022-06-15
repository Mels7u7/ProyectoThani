package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pagoloaddvcombo extends GXProcedure
{
   public pagoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pagoloaddvcombo.class ), "" );
   }

   public pagoloaddvcombo( int remoteHandle ,
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
      pagoloaddvcombo.this.aP7 = new String[] {""};
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
      pagoloaddvcombo.this.AV17ComboName = aP0;
      pagoloaddvcombo.this.AV19TrnMode = aP1;
      pagoloaddvcombo.this.AV21IsDynamicCall = aP2;
      pagoloaddvcombo.this.AV25PagoId = aP3;
      pagoloaddvcombo.this.AV12SearchTxt = aP4;
      pagoloaddvcombo.this.aP5 = aP5;
      pagoloaddvcombo.this.aP6 = aP6;
      pagoloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago", GXv_boolean2) ;
      pagoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         else if ( GXutil.strcmp(AV17ComboName, "DisponibilidadId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_DISPONIBILIDADID' */
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
         /* Using cursor P003A2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A64CitaCode = P003A2_A64CitaCode[0] ;
            A19CitaId = P003A2_A19CitaId[0] ;
            n19CitaId = P003A2_n19CitaId[0] ;
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
               /* Using cursor P003A3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV25PagoId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A47PagoId = P003A3_A47PagoId[0] ;
                  A19CitaId = P003A3_A19CitaId[0] ;
                  n19CitaId = P003A3_n19CitaId[0] ;
                  A64CitaCode = P003A3_A64CitaCode[0] ;
                  A64CitaCode = P003A3_A64CitaCode[0] ;
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
               /* Using cursor P003A4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV24CitaId)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A19CitaId = P003A4_A19CitaId[0] ;
                  n19CitaId = P003A4_n19CitaId[0] ;
                  A64CitaCode = P003A4_A64CitaCode[0] ;
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
      /* 'LOADCOMBOITEMS_DISPONIBILIDADID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              Integer.valueOf(A34DisponibilidadId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P003A5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A34DisponibilidadId = P003A5_A34DisponibilidadId[0] ;
            n34DisponibilidadId = P003A5_n34DisponibilidadId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A34DisponibilidadId, 8, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")) );
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
            /* Using cursor P003A6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(AV25PagoId)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A47PagoId = P003A6_A47PagoId[0] ;
               A34DisponibilidadId = P003A6_A34DisponibilidadId[0] ;
               n34DisponibilidadId = P003A6_n34DisponibilidadId[0] ;
               AV16SelectedValue = ((0==A34DisponibilidadId) ? "" : GXutil.trim( GXutil.str( A34DisponibilidadId, 8, 0))) ;
               AV22SelectedText = AV16SelectedValue ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = pagoloaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = pagoloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = pagoloaddvcombo.this.AV13Combo_DataJson;
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
      P003A2_A64CitaCode = new String[] {""} ;
      P003A2_A19CitaId = new int[1] ;
      P003A2_n19CitaId = new boolean[] {false} ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P003A3_A47PagoId = new int[1] ;
      P003A3_A19CitaId = new int[1] ;
      P003A3_n19CitaId = new boolean[] {false} ;
      P003A3_A64CitaCode = new String[] {""} ;
      P003A4_A19CitaId = new int[1] ;
      P003A4_n19CitaId = new boolean[] {false} ;
      P003A4_A64CitaCode = new String[] {""} ;
      P003A5_A34DisponibilidadId = new int[1] ;
      P003A5_n34DisponibilidadId = new boolean[] {false} ;
      P003A6_A47PagoId = new int[1] ;
      P003A6_A34DisponibilidadId = new int[1] ;
      P003A6_n34DisponibilidadId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pagoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P003A2_A64CitaCode, P003A2_A19CitaId
            }
            , new Object[] {
            P003A3_A47PagoId, P003A3_A19CitaId, P003A3_n19CitaId, P003A3_A64CitaCode
            }
            , new Object[] {
            P003A4_A19CitaId, P003A4_A64CitaCode
            }
            , new Object[] {
            P003A5_A34DisponibilidadId
            }
            , new Object[] {
            P003A6_A47PagoId, P003A6_A34DisponibilidadId, P003A6_n34DisponibilidadId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV25PagoId ;
   private int AV11MaxItems ;
   private int A19CitaId ;
   private int A47PagoId ;
   private int AV24CitaId ;
   private int A34DisponibilidadId ;
   private String AV19TrnMode ;
   private String scmdbuf ;
   private boolean AV21IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n19CitaId ;
   private boolean n34DisponibilidadId ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A64CitaCode ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P003A2_A64CitaCode ;
   private int[] P003A2_A19CitaId ;
   private boolean[] P003A2_n19CitaId ;
   private int[] P003A3_A47PagoId ;
   private int[] P003A3_A19CitaId ;
   private boolean[] P003A3_n19CitaId ;
   private String[] P003A3_A64CitaCode ;
   private int[] P003A4_A19CitaId ;
   private boolean[] P003A4_n19CitaId ;
   private String[] P003A4_A64CitaCode ;
   private int[] P003A5_A34DisponibilidadId ;
   private boolean[] P003A5_n34DisponibilidadId ;
   private int[] P003A6_A47PagoId ;
   private int[] P003A6_A34DisponibilidadId ;
   private boolean[] P003A6_n34DisponibilidadId ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class pagoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003A2( ModelContext context ,
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

   protected Object[] conditional_P003A5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          int A34DisponibilidadId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [DisponibilidadId] FROM [Disponibilidad]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(CONVERT( char(8), CAST([DisponibilidadId] AS decimal(8,0))) like '%' + ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [DisponibilidadId]" ;
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
                  return conditional_P003A2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P003A5(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003A2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003A3", "SELECT T1.[PagoId], T1.[CitaId], T2.[CitaCode] FROM ([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) WHERE T1.[PagoId] = ? ORDER BY T1.[PagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003A4", "SELECT TOP 1 [CitaId], [CitaCode] FROM [Cita] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P003A5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003A6", "SELECT [PagoId], [DisponibilidadId] FROM [Pago] WHERE [PagoId] = ? ORDER BY [PagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
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
      }
   }

}

