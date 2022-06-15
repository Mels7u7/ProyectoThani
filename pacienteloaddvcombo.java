package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pacienteloaddvcombo extends GXProcedure
{
   public pacienteloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacienteloaddvcombo.class ), "" );
   }

   public pacienteloaddvcombo( int remoteHandle ,
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
      pacienteloaddvcombo.this.aP7 = new String[] {""};
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
      pacienteloaddvcombo.this.AV17ComboName = aP0;
      pacienteloaddvcombo.this.AV19TrnMode = aP1;
      pacienteloaddvcombo.this.AV21IsDynamicCall = aP2;
      pacienteloaddvcombo.this.AV27PacienteId = aP3;
      pacienteloaddvcombo.this.AV12SearchTxt = aP4;
      pacienteloaddvcombo.this.aP5 = aP5;
      pacienteloaddvcombo.this.aP6 = aP6;
      pacienteloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean2) ;
      pacienteloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "PaisId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAISID' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "SecUserId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SECUSERID' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV17ComboName, "UbigeoCode") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_UBIGEOCODE' */
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
      /* 'LOADCOMBOITEMS_PAISID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A184PaisDescripcion } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P002M2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A184PaisDescripcion = P002M2_A184PaisDescripcion[0] ;
            A43PaisId = P002M2_A43PaisId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A43PaisId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A184PaisDescripcion );
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
               /* Using cursor P002M3 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV27PacienteId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A20PacienteId = P002M3_A20PacienteId[0] ;
                  A43PaisId = P002M3_A43PaisId[0] ;
                  A184PaisDescripcion = P002M3_A184PaisDescripcion[0] ;
                  A184PaisDescripcion = P002M3_A184PaisDescripcion[0] ;
                  AV16SelectedValue = ((0==A43PaisId) ? "" : GXutil.trim( GXutil.str( A43PaisId, 4, 0))) ;
                  AV22SelectedText = A184PaisDescripcion ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV24PaisId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P002M4 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV24PaisId)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A43PaisId = P002M4_A43PaisId[0] ;
                  A184PaisDescripcion = P002M4_A184PaisDescripcion[0] ;
                  AV22SelectedText = A184PaisDescripcion ;
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
      /* 'LOADCOMBOITEMS_SECUSERID' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A14SecUserName } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P002M5 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A14SecUserName = P002M5_A14SecUserName[0] ;
            A6SecUserId = P002M5_A6SecUserId[0] ;
            n6SecUserId = P002M5_n6SecUserId[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6SecUserId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A14SecUserName );
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
               /* Using cursor P002M6 */
               pr_default.execute(4, new Object[] {Integer.valueOf(AV27PacienteId)});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A20PacienteId = P002M6_A20PacienteId[0] ;
                  A6SecUserId = P002M6_A6SecUserId[0] ;
                  n6SecUserId = P002M6_n6SecUserId[0] ;
                  A14SecUserName = P002M6_A14SecUserName[0] ;
                  A14SecUserName = P002M6_A14SecUserName[0] ;
                  AV16SelectedValue = ((0==A6SecUserId) ? "" : GXutil.trim( GXutil.str( A6SecUserId, 4, 0))) ;
                  AV22SelectedText = A14SecUserName ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV25SecUserId = (short)(GXutil.lval( AV12SearchTxt)) ;
               /* Using cursor P002M7 */
               pr_default.execute(5, new Object[] {Short.valueOf(AV25SecUserId)});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A6SecUserId = P002M7_A6SecUserId[0] ;
                  n6SecUserId = P002M7_n6SecUserId[0] ;
                  A14SecUserName = P002M7_A14SecUserName[0] ;
                  AV22SelectedText = A14SecUserName ;
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
      /* 'LOADCOMBOITEMS_UBIGEOCODE' Routine */
      returnInSub = false ;
      if ( AV21IsDynamicCall )
      {
         pr_default.dynParam(6, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A186UbigeoDepartamento ,
                                              A187UbigeoProvincia ,
                                              A188UbigeoDistrito } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P002M8 */
         pr_default.execute(6, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A185UbigeoNombre = P002M8_A185UbigeoNombre[0] ;
            A44UbigeoCode = P002M8_A44UbigeoCode[0] ;
            n44UbigeoCode = P002M8_n44UbigeoCode[0] ;
            A186UbigeoDepartamento = P002M8_A186UbigeoDepartamento[0] ;
            A187UbigeoProvincia = P002M8_A187UbigeoProvincia[0] ;
            A188UbigeoDistrito = P002M8_A188UbigeoDistrito[0] ;
            AV15Combo_DataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A44UbigeoCode );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A185UbigeoNombre );
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
            if ( GXutil.strcmp(AV19TrnMode, "GET") != 0 )
            {
               /* Using cursor P002M9 */
               pr_default.execute(7, new Object[] {Integer.valueOf(AV27PacienteId)});
               while ( (pr_default.getStatus(7) != 101) )
               {
                  A20PacienteId = P002M9_A20PacienteId[0] ;
                  A44UbigeoCode = P002M9_A44UbigeoCode[0] ;
                  n44UbigeoCode = P002M9_n44UbigeoCode[0] ;
                  A188UbigeoDistrito = P002M9_A188UbigeoDistrito[0] ;
                  A187UbigeoProvincia = P002M9_A187UbigeoProvincia[0] ;
                  A186UbigeoDepartamento = P002M9_A186UbigeoDepartamento[0] ;
                  A188UbigeoDistrito = P002M9_A188UbigeoDistrito[0] ;
                  A187UbigeoProvincia = P002M9_A187UbigeoProvincia[0] ;
                  A186UbigeoDepartamento = P002M9_A186UbigeoDepartamento[0] ;
                  A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
                  AV16SelectedValue = A44UbigeoCode ;
                  AV22SelectedText = A185UbigeoNombre ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(7);
            }
            else
            {
               AV26UbigeoCode = AV12SearchTxt ;
               /* Using cursor P002M10 */
               pr_default.execute(8, new Object[] {AV26UbigeoCode});
               while ( (pr_default.getStatus(8) != 101) )
               {
                  A44UbigeoCode = P002M10_A44UbigeoCode[0] ;
                  n44UbigeoCode = P002M10_n44UbigeoCode[0] ;
                  A188UbigeoDistrito = P002M10_A188UbigeoDistrito[0] ;
                  A187UbigeoProvincia = P002M10_A187UbigeoProvincia[0] ;
                  A186UbigeoDepartamento = P002M10_A186UbigeoDepartamento[0] ;
                  A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
                  AV22SelectedText = A185UbigeoNombre ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(8);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = pacienteloaddvcombo.this.AV16SelectedValue;
      this.aP6[0] = pacienteloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = pacienteloaddvcombo.this.AV13Combo_DataJson;
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
      A184PaisDescripcion = "" ;
      P002M2_A184PaisDescripcion = new String[] {""} ;
      P002M2_A43PaisId = new short[1] ;
      AV15Combo_DataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P002M3_A20PacienteId = new int[1] ;
      P002M3_A43PaisId = new short[1] ;
      P002M3_A184PaisDescripcion = new String[] {""} ;
      P002M4_A43PaisId = new short[1] ;
      P002M4_A184PaisDescripcion = new String[] {""} ;
      A14SecUserName = "" ;
      P002M5_A14SecUserName = new String[] {""} ;
      P002M5_A6SecUserId = new short[1] ;
      P002M5_n6SecUserId = new boolean[] {false} ;
      P002M6_A20PacienteId = new int[1] ;
      P002M6_A6SecUserId = new short[1] ;
      P002M6_n6SecUserId = new boolean[] {false} ;
      P002M6_A14SecUserName = new String[] {""} ;
      P002M7_A6SecUserId = new short[1] ;
      P002M7_n6SecUserId = new boolean[] {false} ;
      P002M7_A14SecUserName = new String[] {""} ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P002M8_A185UbigeoNombre = new String[] {""} ;
      P002M8_A44UbigeoCode = new String[] {""} ;
      P002M8_n44UbigeoCode = new boolean[] {false} ;
      P002M8_A186UbigeoDepartamento = new String[] {""} ;
      P002M8_A187UbigeoProvincia = new String[] {""} ;
      P002M8_A188UbigeoDistrito = new String[] {""} ;
      A185UbigeoNombre = "" ;
      A44UbigeoCode = "" ;
      P002M9_A20PacienteId = new int[1] ;
      P002M9_A44UbigeoCode = new String[] {""} ;
      P002M9_n44UbigeoCode = new boolean[] {false} ;
      P002M9_A188UbigeoDistrito = new String[] {""} ;
      P002M9_A187UbigeoProvincia = new String[] {""} ;
      P002M9_A186UbigeoDepartamento = new String[] {""} ;
      AV26UbigeoCode = "" ;
      P002M10_A44UbigeoCode = new String[] {""} ;
      P002M10_n44UbigeoCode = new boolean[] {false} ;
      P002M10_A188UbigeoDistrito = new String[] {""} ;
      P002M10_A187UbigeoProvincia = new String[] {""} ;
      P002M10_A186UbigeoDepartamento = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacienteloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P002M2_A184PaisDescripcion, P002M2_A43PaisId
            }
            , new Object[] {
            P002M3_A20PacienteId, P002M3_A43PaisId, P002M3_A184PaisDescripcion
            }
            , new Object[] {
            P002M4_A43PaisId, P002M4_A184PaisDescripcion
            }
            , new Object[] {
            P002M5_A14SecUserName, P002M5_A6SecUserId
            }
            , new Object[] {
            P002M6_A20PacienteId, P002M6_A6SecUserId, P002M6_n6SecUserId, P002M6_A14SecUserName
            }
            , new Object[] {
            P002M7_A6SecUserId, P002M7_A14SecUserName
            }
            , new Object[] {
            P002M8_A185UbigeoNombre, P002M8_A44UbigeoCode, P002M8_A186UbigeoDepartamento, P002M8_A187UbigeoProvincia, P002M8_A188UbigeoDistrito
            }
            , new Object[] {
            P002M9_A20PacienteId, P002M9_A44UbigeoCode, P002M9_n44UbigeoCode, P002M9_A188UbigeoDistrito, P002M9_A187UbigeoProvincia, P002M9_A186UbigeoDepartamento
            }
            , new Object[] {
            P002M10_A44UbigeoCode, P002M10_A188UbigeoDistrito, P002M10_A187UbigeoProvincia, P002M10_A186UbigeoDepartamento
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A43PaisId ;
   private short AV24PaisId ;
   private short A6SecUserId ;
   private short AV25SecUserId ;
   private short Gx_err ;
   private int AV27PacienteId ;
   private int AV11MaxItems ;
   private int A20PacienteId ;
   private String AV19TrnMode ;
   private String scmdbuf ;
   private String A44UbigeoCode ;
   private String AV26UbigeoCode ;
   private boolean AV21IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n6SecUserId ;
   private boolean n44UbigeoCode ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A184PaisDescripcion ;
   private String A14SecUserName ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A185UbigeoNombre ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P002M2_A184PaisDescripcion ;
   private short[] P002M2_A43PaisId ;
   private int[] P002M3_A20PacienteId ;
   private short[] P002M3_A43PaisId ;
   private String[] P002M3_A184PaisDescripcion ;
   private short[] P002M4_A43PaisId ;
   private String[] P002M4_A184PaisDescripcion ;
   private String[] P002M5_A14SecUserName ;
   private short[] P002M5_A6SecUserId ;
   private boolean[] P002M5_n6SecUserId ;
   private int[] P002M6_A20PacienteId ;
   private short[] P002M6_A6SecUserId ;
   private boolean[] P002M6_n6SecUserId ;
   private String[] P002M6_A14SecUserName ;
   private short[] P002M7_A6SecUserId ;
   private boolean[] P002M7_n6SecUserId ;
   private String[] P002M7_A14SecUserName ;
   private String[] P002M8_A185UbigeoNombre ;
   private String[] P002M8_A44UbigeoCode ;
   private boolean[] P002M8_n44UbigeoCode ;
   private String[] P002M8_A186UbigeoDepartamento ;
   private String[] P002M8_A187UbigeoProvincia ;
   private String[] P002M8_A188UbigeoDistrito ;
   private int[] P002M9_A20PacienteId ;
   private String[] P002M9_A44UbigeoCode ;
   private boolean[] P002M9_n44UbigeoCode ;
   private String[] P002M9_A188UbigeoDistrito ;
   private String[] P002M9_A187UbigeoProvincia ;
   private String[] P002M9_A186UbigeoDepartamento ;
   private String[] P002M10_A44UbigeoCode ;
   private boolean[] P002M10_n44UbigeoCode ;
   private String[] P002M10_A188UbigeoDistrito ;
   private String[] P002M10_A187UbigeoProvincia ;
   private String[] P002M10_A186UbigeoDepartamento ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class pacienteloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002M2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A184PaisDescripcion )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT [PaisDescripcion], [PaisId] FROM [Pais]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([PaisDescripcion] like '%' + ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [PaisDescripcion]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P002M5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A14SecUserName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [SecUserName], [SecUserId] FROM [SecUser]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([SecUserName] like '%' + ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SecUserName]" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P002M8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] AS UbigeoNombre, [UbigeoCode], [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito]" ;
      scmdbuf += " FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [UbigeoNombre]" ;
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
                  return conditional_P002M2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P002M5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 6 :
                  return conditional_P002M8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002M2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002M3", "SELECT T1.[PacienteId], T1.[PaisId], T2.[PaisDescripcion] FROM ([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) WHERE T1.[PacienteId] = ? ORDER BY T1.[PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002M4", "SELECT TOP 1 [PaisId], [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ORDER BY [PaisId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002M5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002M6", "SELECT T1.[PacienteId], T1.[SecUserId], T2.[SecUserName] FROM ([Paciente] T1 LEFT JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) WHERE T1.[PacienteId] = ? ORDER BY T1.[PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002M7", "SELECT TOP 1 [SecUserId], [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002M8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002M9", "SELECT T1.[PacienteId], T1.[UbigeoCode], T2.[UbigeoDistrito], T2.[UbigeoProvincia], T2.[UbigeoDepartamento] FROM ([Paciente] T1 LEFT JOIN [Ubigeo] T2 ON T2.[UbigeoCode] = T1.[UbigeoCode]) WHERE T1.[PacienteId] = ? ORDER BY T1.[PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002M10", "SELECT TOP 1 [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo] WHERE [UbigeoCode] = ? ORDER BY [UbigeoCode] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 10);
               return;
      }
   }

}

