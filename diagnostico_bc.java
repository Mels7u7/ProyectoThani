package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class diagnostico_bc extends GXWebPanel implements IGxSilentTrn
{
   public diagnostico_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public diagnostico_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diagnostico_bc.class ));
   }

   public diagnostico_bc( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0I25( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0I25( ) ;
      standaloneModal( ) ;
      addRow0I25( ) ;
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
         e110I2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z23DiagnosticoId = A23DiagnosticoId ;
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

   public void confirm_0I0( )
   {
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0I25( ) ;
         }
         else
         {
            checkExtendedTable0I25( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0I25( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      AV8IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico_Insert", GXv_boolean3) ;
         diagnostico_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico_Update", GXv_boolean3) ;
         diagnostico_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico_Delete", GXv_boolean3) ;
         diagnostico_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e110I2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0I25( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z107DiagnosticoCodigo = A107DiagnosticoCodigo ;
         Z108DiagnosticoDescripcion = A108DiagnosticoDescripcion ;
         Z130DiagnosticoTipoSexo = A130DiagnosticoTipoSexo ;
         Z131DiagnosticoEstado = A131DiagnosticoEstado ;
         Z132DiagnosticoLongDesc = A132DiagnosticoLongDesc ;
      }
      if ( GX_JID == -4 )
      {
         Z23DiagnosticoId = A23DiagnosticoId ;
         Z107DiagnosticoCodigo = A107DiagnosticoCodigo ;
         Z108DiagnosticoDescripcion = A108DiagnosticoDescripcion ;
         Z130DiagnosticoTipoSexo = A130DiagnosticoTipoSexo ;
         Z131DiagnosticoEstado = A131DiagnosticoEstado ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0I25( )
   {
      /* Using cursor BC000I4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A107DiagnosticoCodigo = BC000I4_A107DiagnosticoCodigo[0] ;
         A108DiagnosticoDescripcion = BC000I4_A108DiagnosticoDescripcion[0] ;
         A130DiagnosticoTipoSexo = BC000I4_A130DiagnosticoTipoSexo[0] ;
         A131DiagnosticoEstado = BC000I4_A131DiagnosticoEstado[0] ;
         zm0I25( -4) ;
      }
      pr_default.close(2);
      onLoadActions0I25( ) ;
   }

   public void onLoadActions0I25( )
   {
      AV13Pgmname = "Diagnostico_BC" ;
      A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
   }

   public void checkExtendedTable0I25( )
   {
      nIsDirty_25 = (short)(0) ;
      standaloneModal( ) ;
      AV13Pgmname = "Diagnostico_BC" ;
      nIsDirty_25 = (short)(1) ;
      A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
      if ( ! ( ( GXutil.strcmp(A130DiagnosticoTipoSexo, "M") == 0 ) || ( GXutil.strcmp(A130DiagnosticoTipoSexo, "F") == 0 ) || ( GXutil.strcmp(A130DiagnosticoTipoSexo, "A") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Diagnostico Tipo Sexo fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A131DiagnosticoEstado, "A") == 0 ) || ( GXutil.strcmp(A131DiagnosticoEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Diagnostico Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0I25( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0I25( )
   {
      /* Using cursor BC000I5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound25 = (short)(1) ;
      }
      else
      {
         RcdFound25 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000I6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0I25( 4) ;
         RcdFound25 = (short)(1) ;
         A23DiagnosticoId = BC000I6_A23DiagnosticoId[0] ;
         A107DiagnosticoCodigo = BC000I6_A107DiagnosticoCodigo[0] ;
         A108DiagnosticoDescripcion = BC000I6_A108DiagnosticoDescripcion[0] ;
         A130DiagnosticoTipoSexo = BC000I6_A130DiagnosticoTipoSexo[0] ;
         A131DiagnosticoEstado = BC000I6_A131DiagnosticoEstado[0] ;
         Z23DiagnosticoId = A23DiagnosticoId ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0I25( ) ;
         if ( AnyError == 1 )
         {
            RcdFound25 = (short)(0) ;
            initializeNonKey0I25( ) ;
         }
         Gx_mode = sMode25 ;
      }
      else
      {
         RcdFound25 = (short)(0) ;
         initializeNonKey0I25( ) ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode25 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0I25( ) ;
      if ( RcdFound25 == 0 )
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
      confirm_0I0( ) ;
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

   public void checkOptimisticConcurrency0I25( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000I7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A23DiagnosticoId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Diagnostico"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z107DiagnosticoCodigo, BC000I7_A107DiagnosticoCodigo[0]) != 0 ) || ( GXutil.strcmp(Z108DiagnosticoDescripcion, BC000I7_A108DiagnosticoDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z130DiagnosticoTipoSexo, BC000I7_A130DiagnosticoTipoSexo[0]) != 0 ) || ( GXutil.strcmp(Z131DiagnosticoEstado, BC000I7_A131DiagnosticoEstado[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Diagnostico"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0I25( )
   {
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0I25( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0I25( 0) ;
         checkOptimisticConcurrency0I25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0I25( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0I25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000I8 */
                  pr_default.execute(6, new Object[] {A107DiagnosticoCodigo, A108DiagnosticoDescripcion, A130DiagnosticoTipoSexo, A131DiagnosticoEstado});
                  A23DiagnosticoId = BC000I8_A23DiagnosticoId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Diagnostico");
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
            load0I25( ) ;
         }
         endLevel0I25( ) ;
      }
      closeExtendedTableCursors0I25( ) ;
   }

   public void update0I25( )
   {
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0I25( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0I25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0I25( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0I25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000I9 */
                  pr_default.execute(7, new Object[] {A107DiagnosticoCodigo, A108DiagnosticoDescripcion, A130DiagnosticoTipoSexo, A131DiagnosticoEstado, Integer.valueOf(A23DiagnosticoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Diagnostico");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Diagnostico"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0I25( ) ;
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
         endLevel0I25( ) ;
      }
      closeExtendedTableCursors0I25( ) ;
   }

   public void deferredUpdate0I25( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0I25( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0I25( ) ;
         afterConfirm0I25( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0I25( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000I10 */
               pr_default.execute(8, new Object[] {Integer.valueOf(A23DiagnosticoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Diagnostico");
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
      sMode25 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0I25( ) ;
      Gx_mode = sMode25 ;
   }

   public void onDeleteControls0I25( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "Diagnostico_BC" ;
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000I11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A23DiagnosticoId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Diagnostico"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
      }
   }

   public void endLevel0I25( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0I25( ) ;
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

   public void scanKeyStart0I25( )
   {
      /* Scan By routine */
      /* Using cursor BC000I12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A23DiagnosticoId = BC000I12_A23DiagnosticoId[0] ;
         A107DiagnosticoCodigo = BC000I12_A107DiagnosticoCodigo[0] ;
         A108DiagnosticoDescripcion = BC000I12_A108DiagnosticoDescripcion[0] ;
         A130DiagnosticoTipoSexo = BC000I12_A130DiagnosticoTipoSexo[0] ;
         A131DiagnosticoEstado = BC000I12_A131DiagnosticoEstado[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0I25( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound25 = (short)(0) ;
      scanKeyLoad0I25( ) ;
   }

   public void scanKeyLoad0I25( )
   {
      sMode25 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A23DiagnosticoId = BC000I12_A23DiagnosticoId[0] ;
         A107DiagnosticoCodigo = BC000I12_A107DiagnosticoCodigo[0] ;
         A108DiagnosticoDescripcion = BC000I12_A108DiagnosticoDescripcion[0] ;
         A130DiagnosticoTipoSexo = BC000I12_A130DiagnosticoTipoSexo[0] ;
         A131DiagnosticoEstado = BC000I12_A131DiagnosticoEstado[0] ;
      }
      Gx_mode = sMode25 ;
   }

   public void scanKeyEnd0I25( )
   {
      pr_default.close(10);
   }

   public void afterConfirm0I25( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0I25( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0I25( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0I25( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0I25( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0I25( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0I25( )
   {
   }

   public void send_integrity_lvl_hashes0I25( )
   {
   }

   public void addRow0I25( )
   {
      VarsToRow25( bcDiagnostico) ;
   }

   public void readRow0I25( )
   {
      RowToVars25( bcDiagnostico, 1) ;
   }

   public void initializeNonKey0I25( )
   {
      A132DiagnosticoLongDesc = "" ;
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      A130DiagnosticoTipoSexo = "" ;
      A131DiagnosticoEstado = "" ;
      Z107DiagnosticoCodigo = "" ;
      Z108DiagnosticoDescripcion = "" ;
      Z130DiagnosticoTipoSexo = "" ;
      Z131DiagnosticoEstado = "" ;
   }

   public void initAll0I25( )
   {
      A23DiagnosticoId = 0 ;
      initializeNonKey0I25( ) ;
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

   public void VarsToRow25( com.projectthani.SdtDiagnostico obj25 )
   {
      obj25.setgxTv_SdtDiagnostico_Mode( Gx_mode );
      obj25.setgxTv_SdtDiagnostico_Diagnosticolongdesc( A132DiagnosticoLongDesc );
      obj25.setgxTv_SdtDiagnostico_Diagnosticocodigo( A107DiagnosticoCodigo );
      obj25.setgxTv_SdtDiagnostico_Diagnosticodescripcion( A108DiagnosticoDescripcion );
      obj25.setgxTv_SdtDiagnostico_Diagnosticotiposexo( A130DiagnosticoTipoSexo );
      obj25.setgxTv_SdtDiagnostico_Diagnosticoestado( A131DiagnosticoEstado );
      obj25.setgxTv_SdtDiagnostico_Diagnosticoid( A23DiagnosticoId );
      obj25.setgxTv_SdtDiagnostico_Diagnosticoid_Z( Z23DiagnosticoId );
      obj25.setgxTv_SdtDiagnostico_Diagnosticocodigo_Z( Z107DiagnosticoCodigo );
      obj25.setgxTv_SdtDiagnostico_Diagnosticodescripcion_Z( Z108DiagnosticoDescripcion );
      obj25.setgxTv_SdtDiagnostico_Diagnosticotiposexo_Z( Z130DiagnosticoTipoSexo );
      obj25.setgxTv_SdtDiagnostico_Diagnosticoestado_Z( Z131DiagnosticoEstado );
      obj25.setgxTv_SdtDiagnostico_Diagnosticolongdesc_Z( Z132DiagnosticoLongDesc );
      obj25.setgxTv_SdtDiagnostico_Mode( Gx_mode );
   }

   public void KeyVarsToRow25( com.projectthani.SdtDiagnostico obj25 )
   {
      obj25.setgxTv_SdtDiagnostico_Diagnosticoid( A23DiagnosticoId );
   }

   public void RowToVars25( com.projectthani.SdtDiagnostico obj25 ,
                            int forceLoad )
   {
      Gx_mode = obj25.getgxTv_SdtDiagnostico_Mode() ;
      A132DiagnosticoLongDesc = obj25.getgxTv_SdtDiagnostico_Diagnosticolongdesc() ;
      A107DiagnosticoCodigo = obj25.getgxTv_SdtDiagnostico_Diagnosticocodigo() ;
      A108DiagnosticoDescripcion = obj25.getgxTv_SdtDiagnostico_Diagnosticodescripcion() ;
      A130DiagnosticoTipoSexo = obj25.getgxTv_SdtDiagnostico_Diagnosticotiposexo() ;
      A131DiagnosticoEstado = obj25.getgxTv_SdtDiagnostico_Diagnosticoestado() ;
      A23DiagnosticoId = obj25.getgxTv_SdtDiagnostico_Diagnosticoid() ;
      Z23DiagnosticoId = obj25.getgxTv_SdtDiagnostico_Diagnosticoid_Z() ;
      Z107DiagnosticoCodigo = obj25.getgxTv_SdtDiagnostico_Diagnosticocodigo_Z() ;
      Z108DiagnosticoDescripcion = obj25.getgxTv_SdtDiagnostico_Diagnosticodescripcion_Z() ;
      Z130DiagnosticoTipoSexo = obj25.getgxTv_SdtDiagnostico_Diagnosticotiposexo_Z() ;
      Z131DiagnosticoEstado = obj25.getgxTv_SdtDiagnostico_Diagnosticoestado_Z() ;
      Z132DiagnosticoLongDesc = obj25.getgxTv_SdtDiagnostico_Diagnosticolongdesc_Z() ;
      Gx_mode = obj25.getgxTv_SdtDiagnostico_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A23DiagnosticoId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0I25( ) ;
      scanKeyStart0I25( ) ;
      if ( RcdFound25 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z23DiagnosticoId = A23DiagnosticoId ;
      }
      zm0I25( -4) ;
      onLoadActions0I25( ) ;
      addRow0I25( ) ;
      scanKeyEnd0I25( ) ;
      if ( RcdFound25 == 0 )
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
      RowToVars25( bcDiagnostico, 0) ;
      scanKeyStart0I25( ) ;
      if ( RcdFound25 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z23DiagnosticoId = A23DiagnosticoId ;
      }
      zm0I25( -4) ;
      onLoadActions0I25( ) ;
      addRow0I25( ) ;
      scanKeyEnd0I25( ) ;
      if ( RcdFound25 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0I25( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0I25( ) ;
      }
      else
      {
         if ( RcdFound25 == 1 )
         {
            if ( A23DiagnosticoId != Z23DiagnosticoId )
            {
               A23DiagnosticoId = Z23DiagnosticoId ;
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
               update0I25( ) ;
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
               if ( A23DiagnosticoId != Z23DiagnosticoId )
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
                     insert0I25( ) ;
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
                     insert0I25( ) ;
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
      RowToVars25( bcDiagnostico, 1) ;
      saveImpl( ) ;
      VarsToRow25( bcDiagnostico) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars25( bcDiagnostico, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0I25( ) ;
      afterTrn( ) ;
      VarsToRow25( bcDiagnostico) ;
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
         com.projectthani.SdtDiagnostico auxBC = new com.projectthani.SdtDiagnostico( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A23DiagnosticoId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcDiagnostico);
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
      RowToVars25( bcDiagnostico, 1) ;
      updateImpl( ) ;
      VarsToRow25( bcDiagnostico) ;
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
      RowToVars25( bcDiagnostico, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0I25( ) ;
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
      VarsToRow25( bcDiagnostico) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars25( bcDiagnostico, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0I25( ) ;
      if ( RcdFound25 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A23DiagnosticoId != Z23DiagnosticoId )
         {
            A23DiagnosticoId = Z23DiagnosticoId ;
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
         if ( A23DiagnosticoId != Z23DiagnosticoId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "diagnostico_bc");
      VarsToRow25( bcDiagnostico) ;
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
      Gx_mode = bcDiagnostico.getgxTv_SdtDiagnostico_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcDiagnostico.setgxTv_SdtDiagnostico_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtDiagnostico sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcDiagnostico )
      {
         bcDiagnostico = sdt ;
         if ( GXutil.strcmp(bcDiagnostico.getgxTv_SdtDiagnostico_Mode(), "") == 0 )
         {
            bcDiagnostico.setgxTv_SdtDiagnostico_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow25( bcDiagnostico) ;
         }
         else
         {
            RowToVars25( bcDiagnostico, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcDiagnostico.getgxTv_SdtDiagnostico_Mode(), "") == 0 )
         {
            bcDiagnostico.setgxTv_SdtDiagnostico_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars25( bcDiagnostico, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtDiagnostico getDiagnostico_BC( )
   {
      return bcDiagnostico ;
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
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13Pgmname = "" ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      Z107DiagnosticoCodigo = "" ;
      A107DiagnosticoCodigo = "" ;
      Z108DiagnosticoDescripcion = "" ;
      A108DiagnosticoDescripcion = "" ;
      Z130DiagnosticoTipoSexo = "" ;
      A130DiagnosticoTipoSexo = "" ;
      Z131DiagnosticoEstado = "" ;
      A131DiagnosticoEstado = "" ;
      Z132DiagnosticoLongDesc = "" ;
      A132DiagnosticoLongDesc = "" ;
      BC000I4_A23DiagnosticoId = new int[1] ;
      BC000I4_A107DiagnosticoCodigo = new String[] {""} ;
      BC000I4_A108DiagnosticoDescripcion = new String[] {""} ;
      BC000I4_A130DiagnosticoTipoSexo = new String[] {""} ;
      BC000I4_A131DiagnosticoEstado = new String[] {""} ;
      BC000I5_A23DiagnosticoId = new int[1] ;
      BC000I6_A23DiagnosticoId = new int[1] ;
      BC000I6_A107DiagnosticoCodigo = new String[] {""} ;
      BC000I6_A108DiagnosticoDescripcion = new String[] {""} ;
      BC000I6_A130DiagnosticoTipoSexo = new String[] {""} ;
      BC000I6_A131DiagnosticoEstado = new String[] {""} ;
      sMode25 = "" ;
      BC000I7_A23DiagnosticoId = new int[1] ;
      BC000I7_A107DiagnosticoCodigo = new String[] {""} ;
      BC000I7_A108DiagnosticoDescripcion = new String[] {""} ;
      BC000I7_A130DiagnosticoTipoSexo = new String[] {""} ;
      BC000I7_A131DiagnosticoEstado = new String[] {""} ;
      BC000I8_A23DiagnosticoId = new int[1] ;
      BC000I11_A22CitaDiagnosticoId = new int[1] ;
      BC000I12_A23DiagnosticoId = new int[1] ;
      BC000I12_A107DiagnosticoCodigo = new String[] {""} ;
      BC000I12_A108DiagnosticoDescripcion = new String[] {""} ;
      BC000I12_A130DiagnosticoTipoSexo = new String[] {""} ;
      BC000I12_A131DiagnosticoEstado = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.diagnostico_bc__default(),
         new Object[] {
             new Object[] {
            BC000I2_A23DiagnosticoId, BC000I2_A107DiagnosticoCodigo, BC000I2_A108DiagnosticoDescripcion, BC000I2_A130DiagnosticoTipoSexo, BC000I2_A131DiagnosticoEstado
            }
            , new Object[] {
            BC000I3_A23DiagnosticoId, BC000I3_A107DiagnosticoCodigo, BC000I3_A108DiagnosticoDescripcion, BC000I3_A130DiagnosticoTipoSexo, BC000I3_A131DiagnosticoEstado
            }
            , new Object[] {
            BC000I4_A23DiagnosticoId, BC000I4_A107DiagnosticoCodigo, BC000I4_A108DiagnosticoDescripcion, BC000I4_A130DiagnosticoTipoSexo, BC000I4_A131DiagnosticoEstado
            }
            , new Object[] {
            BC000I5_A23DiagnosticoId
            }
            , new Object[] {
            BC000I6_A23DiagnosticoId, BC000I6_A107DiagnosticoCodigo, BC000I6_A108DiagnosticoDescripcion, BC000I6_A130DiagnosticoTipoSexo, BC000I6_A131DiagnosticoEstado
            }
            , new Object[] {
            BC000I7_A23DiagnosticoId, BC000I7_A107DiagnosticoCodigo, BC000I7_A108DiagnosticoDescripcion, BC000I7_A130DiagnosticoTipoSexo, BC000I7_A131DiagnosticoEstado
            }
            , new Object[] {
            BC000I8_A23DiagnosticoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000I11_A22CitaDiagnosticoId
            }
            , new Object[] {
            BC000I12_A23DiagnosticoId, BC000I12_A107DiagnosticoCodigo, BC000I12_A108DiagnosticoDescripcion, BC000I12_A130DiagnosticoTipoSexo, BC000I12_A131DiagnosticoEstado
            }
         }
      );
      AV13Pgmname = "Diagnostico_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120I2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound25 ;
   private short nIsDirty_25 ;
   private int trnEnded ;
   private int Z23DiagnosticoId ;
   private int A23DiagnosticoId ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV13Pgmname ;
   private String Z130DiagnosticoTipoSexo ;
   private String A130DiagnosticoTipoSexo ;
   private String Z131DiagnosticoEstado ;
   private String A131DiagnosticoEstado ;
   private String sMode25 ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private String Z107DiagnosticoCodigo ;
   private String A107DiagnosticoCodigo ;
   private String Z108DiagnosticoDescripcion ;
   private String A108DiagnosticoDescripcion ;
   private String Z132DiagnosticoLongDesc ;
   private String A132DiagnosticoLongDesc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.projectthani.SdtDiagnostico bcDiagnostico ;
   private IDataStoreProvider pr_default ;
   private int[] BC000I4_A23DiagnosticoId ;
   private String[] BC000I4_A107DiagnosticoCodigo ;
   private String[] BC000I4_A108DiagnosticoDescripcion ;
   private String[] BC000I4_A130DiagnosticoTipoSexo ;
   private String[] BC000I4_A131DiagnosticoEstado ;
   private int[] BC000I5_A23DiagnosticoId ;
   private int[] BC000I6_A23DiagnosticoId ;
   private String[] BC000I6_A107DiagnosticoCodigo ;
   private String[] BC000I6_A108DiagnosticoDescripcion ;
   private String[] BC000I6_A130DiagnosticoTipoSexo ;
   private String[] BC000I6_A131DiagnosticoEstado ;
   private int[] BC000I7_A23DiagnosticoId ;
   private String[] BC000I7_A107DiagnosticoCodigo ;
   private String[] BC000I7_A108DiagnosticoDescripcion ;
   private String[] BC000I7_A130DiagnosticoTipoSexo ;
   private String[] BC000I7_A131DiagnosticoEstado ;
   private int[] BC000I8_A23DiagnosticoId ;
   private int[] BC000I11_A22CitaDiagnosticoId ;
   private int[] BC000I12_A23DiagnosticoId ;
   private String[] BC000I12_A107DiagnosticoCodigo ;
   private String[] BC000I12_A108DiagnosticoDescripcion ;
   private String[] BC000I12_A130DiagnosticoTipoSexo ;
   private String[] BC000I12_A131DiagnosticoEstado ;
   private int[] BC000I2_A23DiagnosticoId ;
   private String[] BC000I2_A107DiagnosticoCodigo ;
   private String[] BC000I2_A108DiagnosticoDescripcion ;
   private String[] BC000I2_A130DiagnosticoTipoSexo ;
   private String[] BC000I2_A131DiagnosticoEstado ;
   private int[] BC000I3_A23DiagnosticoId ;
   private String[] BC000I3_A107DiagnosticoCodigo ;
   private String[] BC000I3_A108DiagnosticoDescripcion ;
   private String[] BC000I3_A130DiagnosticoTipoSexo ;
   private String[] BC000I3_A131DiagnosticoEstado ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
}

final  class diagnostico_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000I2", "SELECT [DiagnosticoId], [DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado] FROM [Diagnostico] WITH (UPDLOCK) WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000I3", "SELECT [DiagnosticoId], [DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado] FROM [Diagnostico] WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000I4", "SELECT TM1.[DiagnosticoId], TM1.[DiagnosticoCodigo], TM1.[DiagnosticoDescripcion], TM1.[DiagnosticoTipoSexo], TM1.[DiagnosticoEstado] FROM [Diagnostico] TM1 WHERE TM1.[DiagnosticoId] = ? ORDER BY TM1.[DiagnosticoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000I5", "SELECT [DiagnosticoId] FROM [Diagnostico] WHERE [DiagnosticoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000I6", "SELECT [DiagnosticoId], [DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado] FROM [Diagnostico] WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000I7", "SELECT [DiagnosticoId], [DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado] FROM [Diagnostico] WITH (UPDLOCK) WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000I8", "INSERT INTO [Diagnostico]([DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000I9", "UPDATE [Diagnostico] SET [DiagnosticoCodigo]=?, [DiagnosticoDescripcion]=?, [DiagnosticoTipoSexo]=?, [DiagnosticoEstado]=?  WHERE [DiagnosticoId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000I10", "DELETE FROM [Diagnostico]  WHERE [DiagnosticoId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000I11", "SELECT TOP 1 [CitaDiagnosticoId] FROM [CitaDiagnostico] WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000I12", "SELECT TM1.[DiagnosticoId], TM1.[DiagnosticoCodigo], TM1.[DiagnosticoDescripcion], TM1.[DiagnosticoTipoSexo], TM1.[DiagnosticoEstado] FROM [Diagnostico] TM1 WHERE TM1.[DiagnosticoId] = ? ORDER BY TM1.[DiagnosticoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
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
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

