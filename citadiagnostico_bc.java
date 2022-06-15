package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citadiagnostico_bc extends GXWebPanel implements IGxSilentTrn
{
   public citadiagnostico_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public citadiagnostico_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citadiagnostico_bc.class ));
   }

   public citadiagnostico_bc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0B18( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0B18( ) ;
      standaloneModal( ) ;
      addRow0B18( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z22CitaDiagnosticoId = A22CitaDiagnosticoId ;
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

   public void confirm_0B0( )
   {
      beforeValidate0B18( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0B18( ) ;
         }
         else
         {
            checkExtendedTable0B18( ) ;
            if ( AnyError == 0 )
            {
               zm0B18( 3) ;
               zm0B18( 4) ;
            }
            closeExtendedTableCursors0B18( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0B18( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z109CitaDiagnosticoEstado = A109CitaDiagnosticoEstado ;
         Z19CitaId = A19CitaId ;
         Z23DiagnosticoId = A23DiagnosticoId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z22CitaDiagnosticoId = A22CitaDiagnosticoId ;
         Z109CitaDiagnosticoEstado = A109CitaDiagnosticoEstado ;
         Z19CitaId = A19CitaId ;
         Z23DiagnosticoId = A23DiagnosticoId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0B18( )
   {
      /* Using cursor BC000B6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A22CitaDiagnosticoId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound18 = (short)(1) ;
         A109CitaDiagnosticoEstado = BC000B6_A109CitaDiagnosticoEstado[0] ;
         A19CitaId = BC000B6_A19CitaId[0] ;
         A23DiagnosticoId = BC000B6_A23DiagnosticoId[0] ;
         zm0B18( -2) ;
      }
      pr_default.close(4);
      onLoadActions0B18( ) ;
   }

   public void onLoadActions0B18( )
   {
   }

   public void checkExtendedTable0B18( )
   {
      nIsDirty_18 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000B7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC000B8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Diagnostico'.", "ForeignKeyNotFound", 1, "DIAGNOSTICOID");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( ! ( ( GXutil.strcmp(A109CitaDiagnosticoEstado, "A") == 0 ) || ( GXutil.strcmp(A109CitaDiagnosticoEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Diagnostico Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0B18( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0B18( )
   {
      /* Using cursor BC000B9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A22CitaDiagnosticoId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound18 = (short)(1) ;
      }
      else
      {
         RcdFound18 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000B10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A22CitaDiagnosticoId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0B18( 2) ;
         RcdFound18 = (short)(1) ;
         A22CitaDiagnosticoId = BC000B10_A22CitaDiagnosticoId[0] ;
         A109CitaDiagnosticoEstado = BC000B10_A109CitaDiagnosticoEstado[0] ;
         A19CitaId = BC000B10_A19CitaId[0] ;
         A23DiagnosticoId = BC000B10_A23DiagnosticoId[0] ;
         Z22CitaDiagnosticoId = A22CitaDiagnosticoId ;
         sMode18 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0B18( ) ;
         if ( AnyError == 1 )
         {
            RcdFound18 = (short)(0) ;
            initializeNonKey0B18( ) ;
         }
         Gx_mode = sMode18 ;
      }
      else
      {
         RcdFound18 = (short)(0) ;
         initializeNonKey0B18( ) ;
         sMode18 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode18 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0B18( ) ;
      if ( RcdFound18 == 0 )
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
      confirm_0B0( ) ;
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

   public void checkOptimisticConcurrency0B18( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000B11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A22CitaDiagnosticoId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaDiagnostico"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z109CitaDiagnosticoEstado, BC000B11_A109CitaDiagnosticoEstado[0]) != 0 ) || ( Z19CitaId != BC000B11_A19CitaId[0] ) || ( Z23DiagnosticoId != BC000B11_A23DiagnosticoId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CitaDiagnostico"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0B18( )
   {
      beforeValidate0B18( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B18( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0B18( 0) ;
         checkOptimisticConcurrency0B18( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B18( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0B18( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000B12 */
                  pr_default.execute(10, new Object[] {A109CitaDiagnosticoEstado, Integer.valueOf(A19CitaId), Integer.valueOf(A23DiagnosticoId)});
                  A22CitaDiagnosticoId = BC000B12_A22CitaDiagnosticoId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaDiagnostico");
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
            load0B18( ) ;
         }
         endLevel0B18( ) ;
      }
      closeExtendedTableCursors0B18( ) ;
   }

   public void update0B18( )
   {
      beforeValidate0B18( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B18( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B18( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B18( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0B18( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000B13 */
                  pr_default.execute(11, new Object[] {A109CitaDiagnosticoEstado, Integer.valueOf(A19CitaId), Integer.valueOf(A23DiagnosticoId), Integer.valueOf(A22CitaDiagnosticoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaDiagnostico");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaDiagnostico"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0B18( ) ;
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
         endLevel0B18( ) ;
      }
      closeExtendedTableCursors0B18( ) ;
   }

   public void deferredUpdate0B18( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0B18( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B18( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0B18( ) ;
         afterConfirm0B18( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0B18( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000B14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A22CitaDiagnosticoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaDiagnostico");
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
      sMode18 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0B18( ) ;
      Gx_mode = sMode18 ;
   }

   public void onDeleteControls0B18( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0B18( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0B18( ) ;
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

   public void scanKeyStart0B18( )
   {
      /* Using cursor BC000B15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A22CitaDiagnosticoId)});
      RcdFound18 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound18 = (short)(1) ;
         A22CitaDiagnosticoId = BC000B15_A22CitaDiagnosticoId[0] ;
         A109CitaDiagnosticoEstado = BC000B15_A109CitaDiagnosticoEstado[0] ;
         A19CitaId = BC000B15_A19CitaId[0] ;
         A23DiagnosticoId = BC000B15_A23DiagnosticoId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0B18( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound18 = (short)(0) ;
      scanKeyLoad0B18( ) ;
   }

   public void scanKeyLoad0B18( )
   {
      sMode18 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound18 = (short)(1) ;
         A22CitaDiagnosticoId = BC000B15_A22CitaDiagnosticoId[0] ;
         A109CitaDiagnosticoEstado = BC000B15_A109CitaDiagnosticoEstado[0] ;
         A19CitaId = BC000B15_A19CitaId[0] ;
         A23DiagnosticoId = BC000B15_A23DiagnosticoId[0] ;
      }
      Gx_mode = sMode18 ;
   }

   public void scanKeyEnd0B18( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0B18( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0B18( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0B18( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0B18( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0B18( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0B18( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0B18( )
   {
   }

   public void send_integrity_lvl_hashes0B18( )
   {
   }

   public void addRow0B18( )
   {
      VarsToRow18( bcCitaDiagnostico) ;
   }

   public void readRow0B18( )
   {
      RowToVars18( bcCitaDiagnostico, 1) ;
   }

   public void initializeNonKey0B18( )
   {
      A19CitaId = 0 ;
      A23DiagnosticoId = 0 ;
      A109CitaDiagnosticoEstado = "" ;
      Z109CitaDiagnosticoEstado = "" ;
      Z19CitaId = 0 ;
      Z23DiagnosticoId = 0 ;
   }

   public void initAll0B18( )
   {
      A22CitaDiagnosticoId = 0 ;
      initializeNonKey0B18( ) ;
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

   public void VarsToRow18( com.projectthani.SdtCitaDiagnostico obj18 )
   {
      obj18.setgxTv_SdtCitaDiagnostico_Mode( Gx_mode );
      obj18.setgxTv_SdtCitaDiagnostico_Citaid( A19CitaId );
      obj18.setgxTv_SdtCitaDiagnostico_Diagnosticoid( A23DiagnosticoId );
      obj18.setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado( A109CitaDiagnosticoEstado );
      obj18.setgxTv_SdtCitaDiagnostico_Citadiagnosticoid( A22CitaDiagnosticoId );
      obj18.setgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z( Z22CitaDiagnosticoId );
      obj18.setgxTv_SdtCitaDiagnostico_Citaid_Z( Z19CitaId );
      obj18.setgxTv_SdtCitaDiagnostico_Diagnosticoid_Z( Z23DiagnosticoId );
      obj18.setgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z( Z109CitaDiagnosticoEstado );
      obj18.setgxTv_SdtCitaDiagnostico_Mode( Gx_mode );
   }

   public void KeyVarsToRow18( com.projectthani.SdtCitaDiagnostico obj18 )
   {
      obj18.setgxTv_SdtCitaDiagnostico_Citadiagnosticoid( A22CitaDiagnosticoId );
   }

   public void RowToVars18( com.projectthani.SdtCitaDiagnostico obj18 ,
                            int forceLoad )
   {
      Gx_mode = obj18.getgxTv_SdtCitaDiagnostico_Mode() ;
      A19CitaId = obj18.getgxTv_SdtCitaDiagnostico_Citaid() ;
      A23DiagnosticoId = obj18.getgxTv_SdtCitaDiagnostico_Diagnosticoid() ;
      A109CitaDiagnosticoEstado = obj18.getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado() ;
      A22CitaDiagnosticoId = obj18.getgxTv_SdtCitaDiagnostico_Citadiagnosticoid() ;
      Z22CitaDiagnosticoId = obj18.getgxTv_SdtCitaDiagnostico_Citadiagnosticoid_Z() ;
      Z19CitaId = obj18.getgxTv_SdtCitaDiagnostico_Citaid_Z() ;
      Z23DiagnosticoId = obj18.getgxTv_SdtCitaDiagnostico_Diagnosticoid_Z() ;
      Z109CitaDiagnosticoEstado = obj18.getgxTv_SdtCitaDiagnostico_Citadiagnosticoestado_Z() ;
      Gx_mode = obj18.getgxTv_SdtCitaDiagnostico_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A22CitaDiagnosticoId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0B18( ) ;
      scanKeyStart0B18( ) ;
      if ( RcdFound18 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z22CitaDiagnosticoId = A22CitaDiagnosticoId ;
      }
      zm0B18( -2) ;
      onLoadActions0B18( ) ;
      addRow0B18( ) ;
      scanKeyEnd0B18( ) ;
      if ( RcdFound18 == 0 )
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
      RowToVars18( bcCitaDiagnostico, 0) ;
      scanKeyStart0B18( ) ;
      if ( RcdFound18 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z22CitaDiagnosticoId = A22CitaDiagnosticoId ;
      }
      zm0B18( -2) ;
      onLoadActions0B18( ) ;
      addRow0B18( ) ;
      scanKeyEnd0B18( ) ;
      if ( RcdFound18 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0B18( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0B18( ) ;
      }
      else
      {
         if ( RcdFound18 == 1 )
         {
            if ( A22CitaDiagnosticoId != Z22CitaDiagnosticoId )
            {
               A22CitaDiagnosticoId = Z22CitaDiagnosticoId ;
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
               update0B18( ) ;
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
               if ( A22CitaDiagnosticoId != Z22CitaDiagnosticoId )
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
                     insert0B18( ) ;
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
                     insert0B18( ) ;
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
      RowToVars18( bcCitaDiagnostico, 1) ;
      saveImpl( ) ;
      VarsToRow18( bcCitaDiagnostico) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars18( bcCitaDiagnostico, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0B18( ) ;
      afterTrn( ) ;
      VarsToRow18( bcCitaDiagnostico) ;
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
         com.projectthani.SdtCitaDiagnostico auxBC = new com.projectthani.SdtCitaDiagnostico( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A22CitaDiagnosticoId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcCitaDiagnostico);
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
      RowToVars18( bcCitaDiagnostico, 1) ;
      updateImpl( ) ;
      VarsToRow18( bcCitaDiagnostico) ;
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
      RowToVars18( bcCitaDiagnostico, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0B18( ) ;
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
      VarsToRow18( bcCitaDiagnostico) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars18( bcCitaDiagnostico, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0B18( ) ;
      if ( RcdFound18 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A22CitaDiagnosticoId != Z22CitaDiagnosticoId )
         {
            A22CitaDiagnosticoId = Z22CitaDiagnosticoId ;
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
         if ( A22CitaDiagnosticoId != Z22CitaDiagnosticoId )
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
      pr_default.close(2);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "citadiagnostico_bc");
      VarsToRow18( bcCitaDiagnostico) ;
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
      Gx_mode = bcCitaDiagnostico.getgxTv_SdtCitaDiagnostico_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcCitaDiagnostico.setgxTv_SdtCitaDiagnostico_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtCitaDiagnostico sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcCitaDiagnostico )
      {
         bcCitaDiagnostico = sdt ;
         if ( GXutil.strcmp(bcCitaDiagnostico.getgxTv_SdtCitaDiagnostico_Mode(), "") == 0 )
         {
            bcCitaDiagnostico.setgxTv_SdtCitaDiagnostico_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow18( bcCitaDiagnostico) ;
         }
         else
         {
            RowToVars18( bcCitaDiagnostico, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcCitaDiagnostico.getgxTv_SdtCitaDiagnostico_Mode(), "") == 0 )
         {
            bcCitaDiagnostico.setgxTv_SdtCitaDiagnostico_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars18( bcCitaDiagnostico, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtCitaDiagnostico getCitaDiagnostico_BC( )
   {
      return bcCitaDiagnostico ;
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
      Z109CitaDiagnosticoEstado = "" ;
      A109CitaDiagnosticoEstado = "" ;
      BC000B6_A22CitaDiagnosticoId = new int[1] ;
      BC000B6_A109CitaDiagnosticoEstado = new String[] {""} ;
      BC000B6_A19CitaId = new int[1] ;
      BC000B6_A23DiagnosticoId = new int[1] ;
      BC000B7_A19CitaId = new int[1] ;
      BC000B8_A23DiagnosticoId = new int[1] ;
      BC000B9_A22CitaDiagnosticoId = new int[1] ;
      BC000B10_A22CitaDiagnosticoId = new int[1] ;
      BC000B10_A109CitaDiagnosticoEstado = new String[] {""} ;
      BC000B10_A19CitaId = new int[1] ;
      BC000B10_A23DiagnosticoId = new int[1] ;
      sMode18 = "" ;
      BC000B11_A22CitaDiagnosticoId = new int[1] ;
      BC000B11_A109CitaDiagnosticoEstado = new String[] {""} ;
      BC000B11_A19CitaId = new int[1] ;
      BC000B11_A23DiagnosticoId = new int[1] ;
      BC000B12_A22CitaDiagnosticoId = new int[1] ;
      BC000B15_A22CitaDiagnosticoId = new int[1] ;
      BC000B15_A109CitaDiagnosticoEstado = new String[] {""} ;
      BC000B15_A19CitaId = new int[1] ;
      BC000B15_A23DiagnosticoId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citadiagnostico_bc__default(),
         new Object[] {
             new Object[] {
            BC000B2_A22CitaDiagnosticoId, BC000B2_A109CitaDiagnosticoEstado, BC000B2_A19CitaId, BC000B2_A23DiagnosticoId
            }
            , new Object[] {
            BC000B3_A22CitaDiagnosticoId, BC000B3_A109CitaDiagnosticoEstado, BC000B3_A19CitaId, BC000B3_A23DiagnosticoId
            }
            , new Object[] {
            BC000B4_A19CitaId
            }
            , new Object[] {
            BC000B5_A23DiagnosticoId
            }
            , new Object[] {
            BC000B6_A22CitaDiagnosticoId, BC000B6_A109CitaDiagnosticoEstado, BC000B6_A19CitaId, BC000B6_A23DiagnosticoId
            }
            , new Object[] {
            BC000B7_A19CitaId
            }
            , new Object[] {
            BC000B8_A23DiagnosticoId
            }
            , new Object[] {
            BC000B9_A22CitaDiagnosticoId
            }
            , new Object[] {
            BC000B10_A22CitaDiagnosticoId, BC000B10_A109CitaDiagnosticoEstado, BC000B10_A19CitaId, BC000B10_A23DiagnosticoId
            }
            , new Object[] {
            BC000B11_A22CitaDiagnosticoId, BC000B11_A109CitaDiagnosticoEstado, BC000B11_A19CitaId, BC000B11_A23DiagnosticoId
            }
            , new Object[] {
            BC000B12_A22CitaDiagnosticoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000B15_A22CitaDiagnosticoId, BC000B15_A109CitaDiagnosticoEstado, BC000B15_A19CitaId, BC000B15_A23DiagnosticoId
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound18 ;
   private short nIsDirty_18 ;
   private int trnEnded ;
   private int Z22CitaDiagnosticoId ;
   private int A22CitaDiagnosticoId ;
   private int GX_JID ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private int Z23DiagnosticoId ;
   private int A23DiagnosticoId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode18 ;
   private boolean mustCommit ;
   private String Z109CitaDiagnosticoEstado ;
   private String A109CitaDiagnosticoEstado ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtCitaDiagnostico bcCitaDiagnostico ;
   private IDataStoreProvider pr_default ;
   private int[] BC000B6_A22CitaDiagnosticoId ;
   private String[] BC000B6_A109CitaDiagnosticoEstado ;
   private int[] BC000B6_A19CitaId ;
   private int[] BC000B6_A23DiagnosticoId ;
   private int[] BC000B7_A19CitaId ;
   private int[] BC000B8_A23DiagnosticoId ;
   private int[] BC000B9_A22CitaDiagnosticoId ;
   private int[] BC000B10_A22CitaDiagnosticoId ;
   private String[] BC000B10_A109CitaDiagnosticoEstado ;
   private int[] BC000B10_A19CitaId ;
   private int[] BC000B10_A23DiagnosticoId ;
   private int[] BC000B11_A22CitaDiagnosticoId ;
   private String[] BC000B11_A109CitaDiagnosticoEstado ;
   private int[] BC000B11_A19CitaId ;
   private int[] BC000B11_A23DiagnosticoId ;
   private int[] BC000B12_A22CitaDiagnosticoId ;
   private int[] BC000B15_A22CitaDiagnosticoId ;
   private String[] BC000B15_A109CitaDiagnosticoEstado ;
   private int[] BC000B15_A19CitaId ;
   private int[] BC000B15_A23DiagnosticoId ;
   private int[] BC000B2_A22CitaDiagnosticoId ;
   private String[] BC000B2_A109CitaDiagnosticoEstado ;
   private int[] BC000B2_A19CitaId ;
   private int[] BC000B2_A23DiagnosticoId ;
   private int[] BC000B3_A22CitaDiagnosticoId ;
   private String[] BC000B3_A109CitaDiagnosticoEstado ;
   private int[] BC000B3_A19CitaId ;
   private int[] BC000B3_A23DiagnosticoId ;
   private int[] BC000B4_A19CitaId ;
   private int[] BC000B5_A23DiagnosticoId ;
}

final  class citadiagnostico_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000B2", "SELECT [CitaDiagnosticoId], [CitaDiagnosticoEstado], [CitaId], [DiagnosticoId] FROM [CitaDiagnostico] WITH (UPDLOCK) WHERE [CitaDiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B3", "SELECT [CitaDiagnosticoId], [CitaDiagnosticoEstado], [CitaId], [DiagnosticoId] FROM [CitaDiagnostico] WHERE [CitaDiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B4", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B5", "SELECT [DiagnosticoId] FROM [Diagnostico] WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B6", "SELECT TM1.[CitaDiagnosticoId], TM1.[CitaDiagnosticoEstado], TM1.[CitaId], TM1.[DiagnosticoId] FROM [CitaDiagnostico] TM1 WHERE TM1.[CitaDiagnosticoId] = ? ORDER BY TM1.[CitaDiagnosticoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B7", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B8", "SELECT [DiagnosticoId] FROM [Diagnostico] WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B9", "SELECT [CitaDiagnosticoId] FROM [CitaDiagnostico] WHERE [CitaDiagnosticoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B10", "SELECT [CitaDiagnosticoId], [CitaDiagnosticoEstado], [CitaId], [DiagnosticoId] FROM [CitaDiagnostico] WHERE [CitaDiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B11", "SELECT [CitaDiagnosticoId], [CitaDiagnosticoEstado], [CitaId], [DiagnosticoId] FROM [CitaDiagnostico] WITH (UPDLOCK) WHERE [CitaDiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B12", "INSERT INTO [CitaDiagnostico]([CitaDiagnosticoEstado], [CitaId], [DiagnosticoId]) VALUES(?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000B13", "UPDATE [CitaDiagnostico] SET [CitaDiagnosticoEstado]=?, [CitaId]=?, [DiagnosticoId]=?  WHERE [CitaDiagnosticoId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000B14", "DELETE FROM [CitaDiagnostico]  WHERE [CitaDiagnosticoId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000B15", "SELECT TM1.[CitaDiagnosticoId], TM1.[CitaDiagnosticoEstado], TM1.[CitaId], TM1.[DiagnosticoId] FROM [CitaDiagnostico] TM1 WHERE TM1.[CitaDiagnosticoId] = ? ORDER BY TM1.[CitaDiagnosticoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 1, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 1, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

