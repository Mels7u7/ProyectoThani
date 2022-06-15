package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class medicamento_bc extends GXWebPanel implements IGxSilentTrn
{
   public medicamento_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public medicamento_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( medicamento_bc.class ));
   }

   public medicamento_bc( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0R36( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0R36( ) ;
      standaloneModal( ) ;
      addRow0R36( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e110R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z42MedicamentoId = A42MedicamentoId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0R0( )
   {
      beforeValidate0R36( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0R36( ) ;
         }
         else
         {
            checkExtendedTable0R36( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0R36( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMedicamento_Insert", GXv_boolean3) ;
         medicamento_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMedicamento_Update", GXv_boolean3) ;
         medicamento_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMedicamento_Delete", GXv_boolean3) ;
         medicamento_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e110R2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0R36( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z229MedicamentoCodigo = A229MedicamentoCodigo ;
         Z230MedicamentoNombre = A230MedicamentoNombre ;
         Z231MedicamentoFormaFarm = A231MedicamentoFormaFarm ;
      }
      if ( GX_JID == -1 )
      {
         Z42MedicamentoId = A42MedicamentoId ;
         Z229MedicamentoCodigo = A229MedicamentoCodigo ;
         Z230MedicamentoNombre = A230MedicamentoNombre ;
         Z231MedicamentoFormaFarm = A231MedicamentoFormaFarm ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0R36( )
   {
      /* Using cursor BC000R4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A229MedicamentoCodigo = BC000R4_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000R4_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000R4_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000R4_n231MedicamentoFormaFarm[0] ;
         zm0R36( -1) ;
      }
      pr_default.close(2);
      onLoadActions0R36( ) ;
   }

   public void onLoadActions0R36( )
   {
      AV13Pgmname = "Medicamento_BC" ;
   }

   public void checkExtendedTable0R36( )
   {
      nIsDirty_36 = (short)(0) ;
      standaloneModal( ) ;
      AV13Pgmname = "Medicamento_BC" ;
   }

   public void closeExtendedTableCursors0R36( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0R36( )
   {
      /* Using cursor BC000R5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound36 = (short)(1) ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000R6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0R36( 1) ;
         RcdFound36 = (short)(1) ;
         A42MedicamentoId = BC000R6_A42MedicamentoId[0] ;
         n42MedicamentoId = BC000R6_n42MedicamentoId[0] ;
         A229MedicamentoCodigo = BC000R6_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000R6_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000R6_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000R6_n231MedicamentoFormaFarm[0] ;
         Z42MedicamentoId = A42MedicamentoId ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0R36( ) ;
         if ( AnyError == 1 )
         {
            RcdFound36 = (short)(0) ;
            initializeNonKey0R36( ) ;
         }
         Gx_mode = sMode36 ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
         initializeNonKey0R36( ) ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode36 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0R36( ) ;
      if ( RcdFound36 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0R0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0R36( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000R7 */
         pr_default.execute(5, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Medicamento"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z229MedicamentoCodigo, BC000R7_A229MedicamentoCodigo[0]) != 0 ) || ( GXutil.strcmp(Z230MedicamentoNombre, BC000R7_A230MedicamentoNombre[0]) != 0 ) || ( GXutil.strcmp(Z231MedicamentoFormaFarm, BC000R7_A231MedicamentoFormaFarm[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Medicamento"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0R36( )
   {
      beforeValidate0R36( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R36( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0R36( 0) ;
         checkOptimisticConcurrency0R36( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R36( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0R36( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000R8 */
                  pr_default.execute(6, new Object[] {A229MedicamentoCodigo, A230MedicamentoNombre, Boolean.valueOf(n231MedicamentoFormaFarm), A231MedicamentoFormaFarm});
                  A42MedicamentoId = BC000R8_A42MedicamentoId[0] ;
                  n42MedicamentoId = BC000R8_n42MedicamentoId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Medicamento");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0R36( ) ;
         }
         endLevel0R36( ) ;
      }
      closeExtendedTableCursors0R36( ) ;
   }

   public void update0R36( )
   {
      beforeValidate0R36( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R36( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R36( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R36( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0R36( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000R9 */
                  pr_default.execute(7, new Object[] {A229MedicamentoCodigo, A230MedicamentoNombre, Boolean.valueOf(n231MedicamentoFormaFarm), A231MedicamentoFormaFarm, Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Medicamento");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Medicamento"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0R36( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0R36( ) ;
      }
      closeExtendedTableCursors0R36( ) ;
   }

   public void deferredUpdate0R36( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0R36( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R36( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0R36( ) ;
         afterConfirm0R36( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0R36( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000R10 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Medicamento");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode36 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0R36( ) ;
      Gx_mode = sMode36 ;
   }

   public void onDeleteControls0R36( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "Medicamento_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000R11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Receta Medica"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
      }
   }

   public void endLevel0R36( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0R36( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0R36( )
   {
      /* Scan By routine */
      /* Using cursor BC000R12 */
      pr_default.execute(10, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      RcdFound36 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A42MedicamentoId = BC000R12_A42MedicamentoId[0] ;
         n42MedicamentoId = BC000R12_n42MedicamentoId[0] ;
         A229MedicamentoCodigo = BC000R12_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000R12_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000R12_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000R12_n231MedicamentoFormaFarm[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0R36( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound36 = (short)(0) ;
      scanKeyLoad0R36( ) ;
   }

   public void scanKeyLoad0R36( )
   {
      sMode36 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A42MedicamentoId = BC000R12_A42MedicamentoId[0] ;
         n42MedicamentoId = BC000R12_n42MedicamentoId[0] ;
         A229MedicamentoCodigo = BC000R12_A229MedicamentoCodigo[0] ;
         A230MedicamentoNombre = BC000R12_A230MedicamentoNombre[0] ;
         A231MedicamentoFormaFarm = BC000R12_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = BC000R12_n231MedicamentoFormaFarm[0] ;
      }
      Gx_mode = sMode36 ;
   }

   public void scanKeyEnd0R36( )
   {
      pr_default.close(10);
   }

   public void afterConfirm0R36( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0R36( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0R36( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0R36( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0R36( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0R36( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0R36( )
   {
   }

   public void send_integrity_lvl_hashes0R36( )
   {
   }

   public void addRow0R36( )
   {
      VarsToRow36( bcMedicamento) ;
   }

   public void readRow0R36( )
   {
      RowToVars36( bcMedicamento, 1) ;
   }

   public void initializeNonKey0R36( )
   {
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      n231MedicamentoFormaFarm = false ;
      Z229MedicamentoCodigo = "" ;
      Z230MedicamentoNombre = "" ;
      Z231MedicamentoFormaFarm = "" ;
   }

   public void initAll0R36( )
   {
      A42MedicamentoId = (short)(0) ;
      n42MedicamentoId = false ;
      initializeNonKey0R36( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow36( com.projectthani.SdtMedicamento obj36 )
   {
      obj36.setgxTv_SdtMedicamento_Mode( Gx_mode );
      obj36.setgxTv_SdtMedicamento_Medicamentocodigo( A229MedicamentoCodigo );
      obj36.setgxTv_SdtMedicamento_Medicamentonombre( A230MedicamentoNombre );
      obj36.setgxTv_SdtMedicamento_Medicamentoformafarm( A231MedicamentoFormaFarm );
      obj36.setgxTv_SdtMedicamento_Medicamentoid( A42MedicamentoId );
      obj36.setgxTv_SdtMedicamento_Medicamentoid_Z( Z42MedicamentoId );
      obj36.setgxTv_SdtMedicamento_Medicamentocodigo_Z( Z229MedicamentoCodigo );
      obj36.setgxTv_SdtMedicamento_Medicamentonombre_Z( Z230MedicamentoNombre );
      obj36.setgxTv_SdtMedicamento_Medicamentoformafarm_Z( Z231MedicamentoFormaFarm );
      obj36.setgxTv_SdtMedicamento_Medicamentoid_N( (byte)((byte)((n42MedicamentoId)?1:0)) );
      obj36.setgxTv_SdtMedicamento_Medicamentoformafarm_N( (byte)((byte)((n231MedicamentoFormaFarm)?1:0)) );
      obj36.setgxTv_SdtMedicamento_Mode( Gx_mode );
   }

   public void KeyVarsToRow36( com.projectthani.SdtMedicamento obj36 )
   {
      obj36.setgxTv_SdtMedicamento_Medicamentoid( A42MedicamentoId );
   }

   public void RowToVars36( com.projectthani.SdtMedicamento obj36 ,
                            int forceLoad )
   {
      Gx_mode = obj36.getgxTv_SdtMedicamento_Mode() ;
      A229MedicamentoCodigo = obj36.getgxTv_SdtMedicamento_Medicamentocodigo() ;
      A230MedicamentoNombre = obj36.getgxTv_SdtMedicamento_Medicamentonombre() ;
      A231MedicamentoFormaFarm = obj36.getgxTv_SdtMedicamento_Medicamentoformafarm() ;
      n231MedicamentoFormaFarm = false ;
      A42MedicamentoId = obj36.getgxTv_SdtMedicamento_Medicamentoid() ;
      n42MedicamentoId = false ;
      Z42MedicamentoId = obj36.getgxTv_SdtMedicamento_Medicamentoid_Z() ;
      Z229MedicamentoCodigo = obj36.getgxTv_SdtMedicamento_Medicamentocodigo_Z() ;
      Z230MedicamentoNombre = obj36.getgxTv_SdtMedicamento_Medicamentonombre_Z() ;
      Z231MedicamentoFormaFarm = obj36.getgxTv_SdtMedicamento_Medicamentoformafarm_Z() ;
      n42MedicamentoId = (boolean)((obj36.getgxTv_SdtMedicamento_Medicamentoid_N()==0)?false:true) ;
      n231MedicamentoFormaFarm = (boolean)((obj36.getgxTv_SdtMedicamento_Medicamentoformafarm_N()==0)?false:true) ;
      Gx_mode = obj36.getgxTv_SdtMedicamento_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A42MedicamentoId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      n42MedicamentoId = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0R36( ) ;
      scanKeyStart0R36( ) ;
      if ( RcdFound36 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z42MedicamentoId = A42MedicamentoId ;
      }
      zm0R36( -1) ;
      onLoadActions0R36( ) ;
      addRow0R36( ) ;
      scanKeyEnd0R36( ) ;
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars36( bcMedicamento, 0) ;
      scanKeyStart0R36( ) ;
      if ( RcdFound36 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z42MedicamentoId = A42MedicamentoId ;
      }
      zm0R36( -1) ;
      onLoadActions0R36( ) ;
      addRow0R36( ) ;
      scanKeyEnd0R36( ) ;
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0R36( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0R36( ) ;
      }
      else
      {
         if ( RcdFound36 == 1 )
         {
            if ( A42MedicamentoId != Z42MedicamentoId )
            {
               A42MedicamentoId = Z42MedicamentoId ;
               n42MedicamentoId = false ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0R36( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A42MedicamentoId != Z42MedicamentoId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0R36( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0R36( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars36( bcMedicamento, 1) ;
      saveImpl( ) ;
      VarsToRow36( bcMedicamento) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars36( bcMedicamento, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0R36( ) ;
      afterTrn( ) ;
      VarsToRow36( bcMedicamento) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.projectthani.SdtMedicamento auxBC = new com.projectthani.SdtMedicamento( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A42MedicamentoId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcMedicamento);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars36( bcMedicamento, 1) ;
      updateImpl( ) ;
      VarsToRow36( bcMedicamento) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars36( bcMedicamento, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0R36( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow36( bcMedicamento) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars36( bcMedicamento, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0R36( ) ;
      if ( RcdFound36 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A42MedicamentoId != Z42MedicamentoId )
         {
            A42MedicamentoId = Z42MedicamentoId ;
            n42MedicamentoId = false ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A42MedicamentoId != Z42MedicamentoId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      pr_default.close(1);
      pr_default.close(0);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "medicamento_bc");
      VarsToRow36( bcMedicamento) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcMedicamento.getgxTv_SdtMedicamento_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcMedicamento.setgxTv_SdtMedicamento_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtMedicamento sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcMedicamento )
      {
         bcMedicamento = sdt ;
         if ( GXutil.strcmp(bcMedicamento.getgxTv_SdtMedicamento_Mode(), "") == 0 )
         {
            bcMedicamento.setgxTv_SdtMedicamento_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow36( bcMedicamento) ;
         }
         else
         {
            RowToVars36( bcMedicamento, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcMedicamento.getgxTv_SdtMedicamento_Mode(), "") == 0 )
         {
            bcMedicamento.setgxTv_SdtMedicamento_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars36( bcMedicamento, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtMedicamento getMedicamento_BC( )
   {
      return bcMedicamento ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13Pgmname = "" ;
      AV11TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      Z229MedicamentoCodigo = "" ;
      A229MedicamentoCodigo = "" ;
      Z230MedicamentoNombre = "" ;
      A230MedicamentoNombre = "" ;
      Z231MedicamentoFormaFarm = "" ;
      A231MedicamentoFormaFarm = "" ;
      BC000R4_A42MedicamentoId = new short[1] ;
      BC000R4_n42MedicamentoId = new boolean[] {false} ;
      BC000R4_A229MedicamentoCodigo = new String[] {""} ;
      BC000R4_A230MedicamentoNombre = new String[] {""} ;
      BC000R4_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000R4_n231MedicamentoFormaFarm = new boolean[] {false} ;
      BC000R5_A42MedicamentoId = new short[1] ;
      BC000R5_n42MedicamentoId = new boolean[] {false} ;
      BC000R6_A42MedicamentoId = new short[1] ;
      BC000R6_n42MedicamentoId = new boolean[] {false} ;
      BC000R6_A229MedicamentoCodigo = new String[] {""} ;
      BC000R6_A230MedicamentoNombre = new String[] {""} ;
      BC000R6_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000R6_n231MedicamentoFormaFarm = new boolean[] {false} ;
      sMode36 = "" ;
      BC000R7_A42MedicamentoId = new short[1] ;
      BC000R7_n42MedicamentoId = new boolean[] {false} ;
      BC000R7_A229MedicamentoCodigo = new String[] {""} ;
      BC000R7_A230MedicamentoNombre = new String[] {""} ;
      BC000R7_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000R7_n231MedicamentoFormaFarm = new boolean[] {false} ;
      BC000R8_A42MedicamentoId = new short[1] ;
      BC000R8_n42MedicamentoId = new boolean[] {false} ;
      BC000R11_A50RecetaMedicaId = new short[1] ;
      BC000R12_A42MedicamentoId = new short[1] ;
      BC000R12_n42MedicamentoId = new boolean[] {false} ;
      BC000R12_A229MedicamentoCodigo = new String[] {""} ;
      BC000R12_A230MedicamentoNombre = new String[] {""} ;
      BC000R12_A231MedicamentoFormaFarm = new String[] {""} ;
      BC000R12_n231MedicamentoFormaFarm = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.medicamento_bc__default(),
         new Object[] {
             new Object[] {
            BC000R2_A42MedicamentoId, BC000R2_A229MedicamentoCodigo, BC000R2_A230MedicamentoNombre, BC000R2_A231MedicamentoFormaFarm, BC000R2_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000R3_A42MedicamentoId, BC000R3_A229MedicamentoCodigo, BC000R3_A230MedicamentoNombre, BC000R3_A231MedicamentoFormaFarm, BC000R3_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000R4_A42MedicamentoId, BC000R4_A229MedicamentoCodigo, BC000R4_A230MedicamentoNombre, BC000R4_A231MedicamentoFormaFarm, BC000R4_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000R5_A42MedicamentoId
            }
            , new Object[] {
            BC000R6_A42MedicamentoId, BC000R6_A229MedicamentoCodigo, BC000R6_A230MedicamentoNombre, BC000R6_A231MedicamentoFormaFarm, BC000R6_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000R7_A42MedicamentoId, BC000R7_A229MedicamentoCodigo, BC000R7_A230MedicamentoNombre, BC000R7_A231MedicamentoFormaFarm, BC000R7_n231MedicamentoFormaFarm
            }
            , new Object[] {
            BC000R8_A42MedicamentoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000R11_A50RecetaMedicaId
            }
            , new Object[] {
            BC000R12_A42MedicamentoId, BC000R12_A229MedicamentoCodigo, BC000R12_A230MedicamentoNombre, BC000R12_A231MedicamentoFormaFarm, BC000R12_n231MedicamentoFormaFarm
            }
         }
      );
      AV13Pgmname = "Medicamento_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120R2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z42MedicamentoId ;
   private short A42MedicamentoId ;
   private short RcdFound36 ;
   private short nIsDirty_36 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV13Pgmname ;
   private String sMode36 ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n42MedicamentoId ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean mustCommit ;
   private String Z229MedicamentoCodigo ;
   private String A229MedicamentoCodigo ;
   private String Z230MedicamentoNombre ;
   private String A230MedicamentoNombre ;
   private String Z231MedicamentoFormaFarm ;
   private String A231MedicamentoFormaFarm ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.projectthani.SdtMedicamento bcMedicamento ;
   private IDataStoreProvider pr_default ;
   private short[] BC000R4_A42MedicamentoId ;
   private boolean[] BC000R4_n42MedicamentoId ;
   private String[] BC000R4_A229MedicamentoCodigo ;
   private String[] BC000R4_A230MedicamentoNombre ;
   private String[] BC000R4_A231MedicamentoFormaFarm ;
   private boolean[] BC000R4_n231MedicamentoFormaFarm ;
   private short[] BC000R5_A42MedicamentoId ;
   private boolean[] BC000R5_n42MedicamentoId ;
   private short[] BC000R6_A42MedicamentoId ;
   private boolean[] BC000R6_n42MedicamentoId ;
   private String[] BC000R6_A229MedicamentoCodigo ;
   private String[] BC000R6_A230MedicamentoNombre ;
   private String[] BC000R6_A231MedicamentoFormaFarm ;
   private boolean[] BC000R6_n231MedicamentoFormaFarm ;
   private short[] BC000R7_A42MedicamentoId ;
   private boolean[] BC000R7_n42MedicamentoId ;
   private String[] BC000R7_A229MedicamentoCodigo ;
   private String[] BC000R7_A230MedicamentoNombre ;
   private String[] BC000R7_A231MedicamentoFormaFarm ;
   private boolean[] BC000R7_n231MedicamentoFormaFarm ;
   private short[] BC000R8_A42MedicamentoId ;
   private boolean[] BC000R8_n42MedicamentoId ;
   private short[] BC000R11_A50RecetaMedicaId ;
   private short[] BC000R12_A42MedicamentoId ;
   private boolean[] BC000R12_n42MedicamentoId ;
   private String[] BC000R12_A229MedicamentoCodigo ;
   private String[] BC000R12_A230MedicamentoNombre ;
   private String[] BC000R12_A231MedicamentoFormaFarm ;
   private boolean[] BC000R12_n231MedicamentoFormaFarm ;
   private short[] BC000R2_A42MedicamentoId ;
   private String[] BC000R2_A229MedicamentoCodigo ;
   private String[] BC000R2_A230MedicamentoNombre ;
   private String[] BC000R2_A231MedicamentoFormaFarm ;
   private short[] BC000R3_A42MedicamentoId ;
   private String[] BC000R3_A229MedicamentoCodigo ;
   private String[] BC000R3_A230MedicamentoNombre ;
   private String[] BC000R3_A231MedicamentoFormaFarm ;
   private boolean[] BC000R2_n231MedicamentoFormaFarm ;
   private boolean[] BC000R3_n231MedicamentoFormaFarm ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class medicamento_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000R2", "SELECT [MedicamentoId], [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WITH (UPDLOCK) WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R3", "SELECT [MedicamentoId], [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R4", "SELECT TM1.[MedicamentoId], TM1.[MedicamentoCodigo], TM1.[MedicamentoNombre], TM1.[MedicamentoFormaFarm] FROM [Medicamento] TM1 WHERE TM1.[MedicamentoId] = ? ORDER BY TM1.[MedicamentoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R5", "SELECT [MedicamentoId] FROM [Medicamento] WHERE [MedicamentoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R6", "SELECT [MedicamentoId], [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R7", "SELECT [MedicamentoId], [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WITH (UPDLOCK) WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R8", "INSERT INTO [Medicamento]([MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm]) VALUES(?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000R9", "UPDATE [Medicamento] SET [MedicamentoCodigo]=?, [MedicamentoNombre]=?, [MedicamentoFormaFarm]=?  WHERE [MedicamentoId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000R10", "DELETE FROM [Medicamento]  WHERE [MedicamentoId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000R11", "SELECT TOP 1 [RecetaMedicaId] FROM [RecetaMedica] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R12", "SELECT TM1.[MedicamentoId], TM1.[MedicamentoCodigo], TM1.[MedicamentoNombre], TM1.[MedicamentoFormaFarm] FROM [Medicamento] TM1 WHERE TM1.[MedicamentoId] = ? ORDER BY TM1.[MedicamentoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 15, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[3], 40);
               }
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 15, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[3], 40);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[5]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

