package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class disponibilidadloaddvcombo extends GXProcedure
{
   public disponibilidadloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadloaddvcombo.class ), "" );
   }

   public disponibilidadloaddvcombo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      disponibilidadloaddvcombo.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      disponibilidadloaddvcombo.this.AV17ComboName = aP0;
      disponibilidadloaddvcombo.this.AV19TrnMode = aP1;
      disponibilidadloaddvcombo.this.AV21IsDynamicCall = aP2;
      disponibilidadloaddvcombo.this.AV26DisponibilidadId = aP3;
      disponibilidadloaddvcombo.this.AV27Cond_ProfesionalId = aP4;
      disponibilidadloaddvcombo.this.AV12SearchTxt = aP5;
      disponibilidadloaddvcombo.this.aP6 = aP6;
      disponibilidadloaddvcombo.this.aP7 = aP7;
      disponibilidadloaddvcombo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad", GXv_boolean2) ;
      disponibilidadloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "ProfesionalId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PROFESIONALID' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "EspecialidadId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_ESPECIALIDADID' */
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
      /* 'LOADCOMBOITEMS_PROFESIONALID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              Integer.valueOf(A31ProfesionalId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P002W2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A31ProfesionalId = P002W2_A31ProfesionalId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A31ProfesionalId, 8, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9")) );
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
            /* Using cursor P002W3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV26DisponibilidadId)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A34DisponibilidadId = P002W3_A34DisponibilidadId[0] ;
               A31ProfesionalId = P002W3_A31ProfesionalId[0] ;
               AV16SelectedValue = ((0==A31ProfesionalId) ? "" : GXutil.trim( GXutil.str( A31ProfesionalId, 8, 0))) ;
               AV22SelectedText = AV16SelectedValue ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_ESPECIALIDADID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              Short.valueOf(A32EspecialidadId) ,
                                              Integer.valueOf(AV27Cond_ProfesionalId) ,
                                              Integer.valueOf(A31ProfesionalId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P002W4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV27Cond_ProfesionalId), lV12SearchTxt});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A32EspecialidadId = P002W4_A32EspecialidadId[0] ;
            A31ProfesionalId = P002W4_A31ProfesionalId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A32EspecialidadId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9")) );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(2);
         }
         pr_default.close(2);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            /* Using cursor P002W5 */
            pr_default.execute(3, new Object[] {Integer.valueOf(AV26DisponibilidadId)});
            while ( (pr_default.getStatus(3) != 101) )
            {
               A34DisponibilidadId = P002W5_A34DisponibilidadId[0] ;
               A32EspecialidadId = P002W5_A32EspecialidadId[0] ;
               AV16SelectedValue = ((0==A32EspecialidadId) ? "" : GXutil.trim( GXutil.str( A32EspecialidadId, 4, 0))) ;
               AV22SelectedText = AV16SelectedValue ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(3);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = disponibilidadloaddvcombo.this.AV16SelectedValue;
      this.aP7[0] = disponibilidadloaddvcombo.this.AV22SelectedText;
      this.aP8[0] = disponibilidadloaddvcombo.this.AV13Combo_DataJson;
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
      P002W2_A31ProfesionalId = new int[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P002W3_A34DisponibilidadId = new int[1] ;
      P002W3_A31ProfesionalId = new int[1] ;
      P002W4_A32EspecialidadId = new short[1] ;
      P002W4_A31ProfesionalId = new int[1] ;
      P002W5_A34DisponibilidadId = new int[1] ;
      P002W5_A32EspecialidadId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P002W2_A31ProfesionalId
            }
            , new Object[] {
            P002W3_A34DisponibilidadId, P002W3_A31ProfesionalId
            }
            , new Object[] {
            P002W4_A32EspecialidadId, P002W4_A31ProfesionalId
            }
            , new Object[] {
            P002W5_A34DisponibilidadId, P002W5_A32EspecialidadId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A32EspecialidadId ;
   private short Gx_err ;
   private int AV26DisponibilidadId ;
   private int AV27Cond_ProfesionalId ;
   private int AV11MaxItems ;
   private int A31ProfesionalId ;
   private int A34DisponibilidadId ;
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
   private String[] aP8 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P002W2_A31ProfesionalId ;
   private int[] P002W3_A34DisponibilidadId ;
   private int[] P002W3_A31ProfesionalId ;
   private short[] P002W4_A32EspecialidadId ;
   private int[] P002W4_A31ProfesionalId ;
   private int[] P002W5_A34DisponibilidadId ;
   private short[] P002W5_A32EspecialidadId ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class disponibilidadloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002W2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          int A31ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [ProfesionalId] FROM [Profesional]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(CONVERT( char(8), CAST([ProfesionalId] AS decimal(8,0))) like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ProfesionalId]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002W4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          short A32EspecialidadId ,
                                          int AV27Cond_ProfesionalId ,
                                          int A31ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [EspecialidadId], [ProfesionalId] FROM [ProfesionalEspecialidad]" ;
      addWhere(sWhereString, "([ProfesionalId] = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(CONVERT( char(4), CAST([EspecialidadId] AS decimal(4,0))) like '%' + ?)");
      }
      else
      {
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [ProfesionalId], [EspecialidadId]" ;
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
                  return conditional_P002W2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).intValue() );
            case 2 :
                  return conditional_P002W4(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002W2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002W3", "SELECT [DisponibilidadId], [ProfesionalId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002W4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002W5", "SELECT [DisponibilidadId], [EspecialidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

