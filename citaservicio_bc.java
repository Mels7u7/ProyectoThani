package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citaservicio_bc extends GXWebPanel implements IGxSilentTrn
{
   public citaservicio_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public citaservicio_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citaservicio_bc.class ));
   }

   public citaservicio_bc( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0D20( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0D20( ) ;
      standaloneModal( ) ;
      addRow0D20( ) ;
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
         e110D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z26CitaServicioId = A26CitaServicioId ;
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

   public void confirm_0D0( )
   {
      beforeValidate0D20( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0D20( ) ;
         }
         else
         {
            checkExtendedTable0D20( ) ;
            if ( AnyError == 0 )
            {
               zm0D20( 3) ;
               zm0D20( 4) ;
            }
            closeExtendedTableCursors0D20( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120D2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e110D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0D20( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z115CitaServicioFlag = A115CitaServicioFlag ;
         Z114CitaServicioEstado = A114CitaServicioEstado ;
         Z19CitaId = A19CitaId ;
         Z27ServicioId = A27ServicioId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z26CitaServicioId = A26CitaServicioId ;
         Z115CitaServicioFlag = A115CitaServicioFlag ;
         Z114CitaServicioEstado = A114CitaServicioEstado ;
         Z19CitaId = A19CitaId ;
         Z27ServicioId = A27ServicioId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0D20( )
   {
      /* Using cursor BC000D6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A115CitaServicioFlag = BC000D6_A115CitaServicioFlag[0] ;
         A114CitaServicioEstado = BC000D6_A114CitaServicioEstado[0] ;
         A19CitaId = BC000D6_A19CitaId[0] ;
         A27ServicioId = BC000D6_A27ServicioId[0] ;
         zm0D20( -2) ;
      }
      pr_default.close(4);
      onLoadActions0D20( ) ;
   }

   public void onLoadActions0D20( )
   {
   }

   public void checkExtendedTable0D20( )
   {
      nIsDirty_20 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000D7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC000D8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Servicio'.", "ForeignKeyNotFound", 1, "SERVICIOID");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( ! ( ( GXutil.strcmp(A114CitaServicioEstado, "P") == 0 ) || ( GXutil.strcmp(A114CitaServicioEstado, "G") == 0 ) || ( GXutil.strcmp(A114CitaServicioEstado, "R") == 0 ) || ( GXutil.strcmp(A114CitaServicioEstado, "F") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Servicio Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0D20( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0D20( )
   {
      /* Using cursor BC000D9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound20 = (short)(1) ;
      }
      else
      {
         RcdFound20 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000D10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0D20( 2) ;
         RcdFound20 = (short)(1) ;
         A26CitaServicioId = BC000D10_A26CitaServicioId[0] ;
         A115CitaServicioFlag = BC000D10_A115CitaServicioFlag[0] ;
         A114CitaServicioEstado = BC000D10_A114CitaServicioEstado[0] ;
         A19CitaId = BC000D10_A19CitaId[0] ;
         A27ServicioId = BC000D10_A27ServicioId[0] ;
         Z26CitaServicioId = A26CitaServicioId ;
         sMode20 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0D20( ) ;
         if ( AnyError == 1 )
         {
            RcdFound20 = (short)(0) ;
            initializeNonKey0D20( ) ;
         }
         Gx_mode = sMode20 ;
      }
      else
      {
         RcdFound20 = (short)(0) ;
         initializeNonKey0D20( ) ;
         sMode20 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode20 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0D20( ) ;
      if ( RcdFound20 == 0 )
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
      confirm_0D0( ) ;
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

   public void checkOptimisticConcurrency0D20( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000D11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A26CitaServicioId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaServicio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( Z115CitaServicioFlag != BC000D11_A115CitaServicioFlag[0] ) || ( GXutil.strcmp(Z114CitaServicioEstado, BC000D11_A114CitaServicioEstado[0]) != 0 ) || ( Z19CitaId != BC000D11_A19CitaId[0] ) || ( Z27ServicioId != BC000D11_A27ServicioId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CitaServicio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0D20( )
   {
      beforeValidate0D20( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D20( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0D20( 0) ;
         checkOptimisticConcurrency0D20( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D20( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0D20( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000D12 */
                  pr_default.execute(10, new Object[] {Byte.valueOf(A115CitaServicioFlag), A114CitaServicioEstado, Integer.valueOf(A19CitaId), Short.valueOf(A27ServicioId)});
                  A26CitaServicioId = BC000D12_A26CitaServicioId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaServicio");
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
            load0D20( ) ;
         }
         endLevel0D20( ) ;
      }
      closeExtendedTableCursors0D20( ) ;
   }

   public void update0D20( )
   {
      beforeValidate0D20( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D20( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D20( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D20( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0D20( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000D13 */
                  pr_default.execute(11, new Object[] {Byte.valueOf(A115CitaServicioFlag), A114CitaServicioEstado, Integer.valueOf(A19CitaId), Short.valueOf(A27ServicioId), Integer.valueOf(A26CitaServicioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaServicio");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaServicio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0D20( ) ;
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
         endLevel0D20( ) ;
      }
      closeExtendedTableCursors0D20( ) ;
   }

   public void deferredUpdate0D20( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0D20( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D20( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0D20( ) ;
         afterConfirm0D20( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0D20( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000D14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A26CitaServicioId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaServicio");
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
      sMode20 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0D20( ) ;
      Gx_mode = sMode20 ;
   }

   public void onDeleteControls0D20( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0D20( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0D20( ) ;
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

   public void scanKeyStart0D20( )
   {
      /* Scan By routine */
      /* Using cursor BC000D15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A26CitaServicioId)});
      RcdFound20 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A26CitaServicioId = BC000D15_A26CitaServicioId[0] ;
         A115CitaServicioFlag = BC000D15_A115CitaServicioFlag[0] ;
         A114CitaServicioEstado = BC000D15_A114CitaServicioEstado[0] ;
         A19CitaId = BC000D15_A19CitaId[0] ;
         A27ServicioId = BC000D15_A27ServicioId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0D20( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound20 = (short)(0) ;
      scanKeyLoad0D20( ) ;
   }

   public void scanKeyLoad0D20( )
   {
      sMode20 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A26CitaServicioId = BC000D15_A26CitaServicioId[0] ;
         A115CitaServicioFlag = BC000D15_A115CitaServicioFlag[0] ;
         A114CitaServicioEstado = BC000D15_A114CitaServicioEstado[0] ;
         A19CitaId = BC000D15_A19CitaId[0] ;
         A27ServicioId = BC000D15_A27ServicioId[0] ;
      }
      Gx_mode = sMode20 ;
   }

   public void scanKeyEnd0D20( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0D20( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0D20( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0D20( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0D20( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0D20( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0D20( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0D20( )
   {
   }

   public void send_integrity_lvl_hashes0D20( )
   {
   }

   public void addRow0D20( )
   {
      VarsToRow20( bcCitaServicio) ;
   }

   public void readRow0D20( )
   {
      RowToVars20( bcCitaServicio, 1) ;
   }

   public void initializeNonKey0D20( )
   {
      A19CitaId = 0 ;
      A27ServicioId = (short)(0) ;
      A115CitaServicioFlag = (byte)(0) ;
      A114CitaServicioEstado = "" ;
      Z115CitaServicioFlag = (byte)(0) ;
      Z114CitaServicioEstado = "" ;
      Z19CitaId = 0 ;
      Z27ServicioId = (short)(0) ;
   }

   public void initAll0D20( )
   {
      A26CitaServicioId = 0 ;
      initializeNonKey0D20( ) ;
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

   public void VarsToRow20( com.projectthani.SdtCitaServicio obj20 )
   {
      obj20.setgxTv_SdtCitaServicio_Mode( Gx_mode );
      obj20.setgxTv_SdtCitaServicio_Citaid( A19CitaId );
      obj20.setgxTv_SdtCitaServicio_Servicioid( A27ServicioId );
      obj20.setgxTv_SdtCitaServicio_Citaservicioflag( A115CitaServicioFlag );
      obj20.setgxTv_SdtCitaServicio_Citaservicioestado( A114CitaServicioEstado );
      obj20.setgxTv_SdtCitaServicio_Citaservicioid( A26CitaServicioId );
      obj20.setgxTv_SdtCitaServicio_Citaservicioid_Z( Z26CitaServicioId );
      obj20.setgxTv_SdtCitaServicio_Citaid_Z( Z19CitaId );
      obj20.setgxTv_SdtCitaServicio_Servicioid_Z( Z27ServicioId );
      obj20.setgxTv_SdtCitaServicio_Citaservicioflag_Z( Z115CitaServicioFlag );
      obj20.setgxTv_SdtCitaServicio_Citaservicioestado_Z( Z114CitaServicioEstado );
      obj20.setgxTv_SdtCitaServicio_Mode( Gx_mode );
   }

   public void KeyVarsToRow20( com.projectthani.SdtCitaServicio obj20 )
   {
      obj20.setgxTv_SdtCitaServicio_Citaservicioid( A26CitaServicioId );
   }

   public void RowToVars20( com.projectthani.SdtCitaServicio obj20 ,
                            int forceLoad )
   {
      Gx_mode = obj20.getgxTv_SdtCitaServicio_Mode() ;
      A19CitaId = obj20.getgxTv_SdtCitaServicio_Citaid() ;
      A27ServicioId = obj20.getgxTv_SdtCitaServicio_Servicioid() ;
      A115CitaServicioFlag = obj20.getgxTv_SdtCitaServicio_Citaservicioflag() ;
      A114CitaServicioEstado = obj20.getgxTv_SdtCitaServicio_Citaservicioestado() ;
      A26CitaServicioId = obj20.getgxTv_SdtCitaServicio_Citaservicioid() ;
      Z26CitaServicioId = obj20.getgxTv_SdtCitaServicio_Citaservicioid_Z() ;
      Z19CitaId = obj20.getgxTv_SdtCitaServicio_Citaid_Z() ;
      Z27ServicioId = obj20.getgxTv_SdtCitaServicio_Servicioid_Z() ;
      Z115CitaServicioFlag = obj20.getgxTv_SdtCitaServicio_Citaservicioflag_Z() ;
      Z114CitaServicioEstado = obj20.getgxTv_SdtCitaServicio_Citaservicioestado_Z() ;
      Gx_mode = obj20.getgxTv_SdtCitaServicio_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A26CitaServicioId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0D20( ) ;
      scanKeyStart0D20( ) ;
      if ( RcdFound20 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z26CitaServicioId = A26CitaServicioId ;
      }
      zm0D20( -2) ;
      onLoadActions0D20( ) ;
      addRow0D20( ) ;
      scanKeyEnd0D20( ) ;
      if ( RcdFound20 == 0 )
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
      RowToVars20( bcCitaServicio, 0) ;
      scanKeyStart0D20( ) ;
      if ( RcdFound20 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z26CitaServicioId = A26CitaServicioId ;
      }
      zm0D20( -2) ;
      onLoadActions0D20( ) ;
      addRow0D20( ) ;
      scanKeyEnd0D20( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0D20( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0D20( ) ;
      }
      else
      {
         if ( RcdFound20 == 1 )
         {
            if ( A26CitaServicioId != Z26CitaServicioId )
            {
               A26CitaServicioId = Z26CitaServicioId ;
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
               update0D20( ) ;
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
               if ( A26CitaServicioId != Z26CitaServicioId )
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
                     insert0D20( ) ;
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
                     insert0D20( ) ;
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
      RowToVars20( bcCitaServicio, 1) ;
      saveImpl( ) ;
      VarsToRow20( bcCitaServicio) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars20( bcCitaServicio, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0D20( ) ;
      afterTrn( ) ;
      VarsToRow20( bcCitaServicio) ;
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
         com.projectthani.SdtCitaServicio auxBC = new com.projectthani.SdtCitaServicio( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A26CitaServicioId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcCitaServicio);
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
      RowToVars20( bcCitaServicio, 1) ;
      updateImpl( ) ;
      VarsToRow20( bcCitaServicio) ;
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
      RowToVars20( bcCitaServicio, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0D20( ) ;
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
      VarsToRow20( bcCitaServicio) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars20( bcCitaServicio, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0D20( ) ;
      if ( RcdFound20 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A26CitaServicioId != Z26CitaServicioId )
         {
            A26CitaServicioId = Z26CitaServicioId ;
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
         if ( A26CitaServicioId != Z26CitaServicioId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "citaservicio_bc");
      VarsToRow20( bcCitaServicio) ;
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
      Gx_mode = bcCitaServicio.getgxTv_SdtCitaServicio_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcCitaServicio.setgxTv_SdtCitaServicio_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtCitaServicio sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcCitaServicio )
      {
         bcCitaServicio = sdt ;
         if ( GXutil.strcmp(bcCitaServicio.getgxTv_SdtCitaServicio_Mode(), "") == 0 )
         {
            bcCitaServicio.setgxTv_SdtCitaServicio_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow20( bcCitaServicio) ;
         }
         else
         {
            RowToVars20( bcCitaServicio, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcCitaServicio.getgxTv_SdtCitaServicio_Mode(), "") == 0 )
         {
            bcCitaServicio.setgxTv_SdtCitaServicio_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars20( bcCitaServicio, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtCitaServicio getCitaServicio_BC( )
   {
      return bcCitaServicio ;
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
      Z114CitaServicioEstado = "" ;
      A114CitaServicioEstado = "" ;
      BC000D6_A26CitaServicioId = new int[1] ;
      BC000D6_A115CitaServicioFlag = new byte[1] ;
      BC000D6_A114CitaServicioEstado = new String[] {""} ;
      BC000D6_A19CitaId = new int[1] ;
      BC000D6_A27ServicioId = new short[1] ;
      BC000D7_A19CitaId = new int[1] ;
      BC000D8_A27ServicioId = new short[1] ;
      BC000D9_A26CitaServicioId = new int[1] ;
      BC000D10_A26CitaServicioId = new int[1] ;
      BC000D10_A115CitaServicioFlag = new byte[1] ;
      BC000D10_A114CitaServicioEstado = new String[] {""} ;
      BC000D10_A19CitaId = new int[1] ;
      BC000D10_A27ServicioId = new short[1] ;
      sMode20 = "" ;
      BC000D11_A26CitaServicioId = new int[1] ;
      BC000D11_A115CitaServicioFlag = new byte[1] ;
      BC000D11_A114CitaServicioEstado = new String[] {""} ;
      BC000D11_A19CitaId = new int[1] ;
      BC000D11_A27ServicioId = new short[1] ;
      BC000D12_A26CitaServicioId = new int[1] ;
      BC000D15_A26CitaServicioId = new int[1] ;
      BC000D15_A115CitaServicioFlag = new byte[1] ;
      BC000D15_A114CitaServicioEstado = new String[] {""} ;
      BC000D15_A19CitaId = new int[1] ;
      BC000D15_A27ServicioId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citaservicio_bc__default(),
         new Object[] {
             new Object[] {
            BC000D2_A26CitaServicioId, BC000D2_A115CitaServicioFlag, BC000D2_A114CitaServicioEstado, BC000D2_A19CitaId, BC000D2_A27ServicioId
            }
            , new Object[] {
            BC000D3_A26CitaServicioId, BC000D3_A115CitaServicioFlag, BC000D3_A114CitaServicioEstado, BC000D3_A19CitaId, BC000D3_A27ServicioId
            }
            , new Object[] {
            BC000D4_A19CitaId
            }
            , new Object[] {
            BC000D5_A27ServicioId
            }
            , new Object[] {
            BC000D6_A26CitaServicioId, BC000D6_A115CitaServicioFlag, BC000D6_A114CitaServicioEstado, BC000D6_A19CitaId, BC000D6_A27ServicioId
            }
            , new Object[] {
            BC000D7_A19CitaId
            }
            , new Object[] {
            BC000D8_A27ServicioId
            }
            , new Object[] {
            BC000D9_A26CitaServicioId
            }
            , new Object[] {
            BC000D10_A26CitaServicioId, BC000D10_A115CitaServicioFlag, BC000D10_A114CitaServicioEstado, BC000D10_A19CitaId, BC000D10_A27ServicioId
            }
            , new Object[] {
            BC000D11_A26CitaServicioId, BC000D11_A115CitaServicioFlag, BC000D11_A114CitaServicioEstado, BC000D11_A19CitaId, BC000D11_A27ServicioId
            }
            , new Object[] {
            BC000D12_A26CitaServicioId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000D15_A26CitaServicioId, BC000D15_A115CitaServicioFlag, BC000D15_A114CitaServicioEstado, BC000D15_A19CitaId, BC000D15_A27ServicioId
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120D2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z115CitaServicioFlag ;
   private byte A115CitaServicioFlag ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z27ServicioId ;
   private short A27ServicioId ;
   private short RcdFound20 ;
   private short nIsDirty_20 ;
   private int trnEnded ;
   private int Z26CitaServicioId ;
   private int A26CitaServicioId ;
   private int GX_JID ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z114CitaServicioEstado ;
   private String A114CitaServicioEstado ;
   private String sMode20 ;
   private boolean returnInSub ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtCitaServicio bcCitaServicio ;
   private IDataStoreProvider pr_default ;
   private int[] BC000D6_A26CitaServicioId ;
   private byte[] BC000D6_A115CitaServicioFlag ;
   private String[] BC000D6_A114CitaServicioEstado ;
   private int[] BC000D6_A19CitaId ;
   private short[] BC000D6_A27ServicioId ;
   private int[] BC000D7_A19CitaId ;
   private short[] BC000D8_A27ServicioId ;
   private int[] BC000D9_A26CitaServicioId ;
   private int[] BC000D10_A26CitaServicioId ;
   private byte[] BC000D10_A115CitaServicioFlag ;
   private String[] BC000D10_A114CitaServicioEstado ;
   private int[] BC000D10_A19CitaId ;
   private short[] BC000D10_A27ServicioId ;
   private int[] BC000D11_A26CitaServicioId ;
   private byte[] BC000D11_A115CitaServicioFlag ;
   private String[] BC000D11_A114CitaServicioEstado ;
   private int[] BC000D11_A19CitaId ;
   private short[] BC000D11_A27ServicioId ;
   private int[] BC000D12_A26CitaServicioId ;
   private int[] BC000D15_A26CitaServicioId ;
   private byte[] BC000D15_A115CitaServicioFlag ;
   private String[] BC000D15_A114CitaServicioEstado ;
   private int[] BC000D15_A19CitaId ;
   private short[] BC000D15_A27ServicioId ;
   private int[] BC000D2_A26CitaServicioId ;
   private byte[] BC000D2_A115CitaServicioFlag ;
   private String[] BC000D2_A114CitaServicioEstado ;
   private int[] BC000D2_A19CitaId ;
   private short[] BC000D2_A27ServicioId ;
   private int[] BC000D3_A26CitaServicioId ;
   private byte[] BC000D3_A115CitaServicioFlag ;
   private String[] BC000D3_A114CitaServicioEstado ;
   private int[] BC000D3_A19CitaId ;
   private short[] BC000D3_A27ServicioId ;
   private int[] BC000D4_A19CitaId ;
   private short[] BC000D5_A27ServicioId ;
}

final  class citaservicio_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000D2", "SELECT [CitaServicioId], [CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId] FROM [CitaServicio] WITH (UPDLOCK) WHERE [CitaServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D3", "SELECT [CitaServicioId], [CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId] FROM [CitaServicio] WHERE [CitaServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D4", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D5", "SELECT [ServicioId] FROM [Servicio] WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D6", "SELECT TM1.[CitaServicioId], TM1.[CitaServicioFlag], TM1.[CitaServicioEstado], TM1.[CitaId], TM1.[ServicioId] FROM [CitaServicio] TM1 WHERE TM1.[CitaServicioId] = ? ORDER BY TM1.[CitaServicioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D7", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D8", "SELECT [ServicioId] FROM [Servicio] WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D9", "SELECT [CitaServicioId] FROM [CitaServicio] WHERE [CitaServicioId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D10", "SELECT [CitaServicioId], [CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId] FROM [CitaServicio] WHERE [CitaServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D11", "SELECT [CitaServicioId], [CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId] FROM [CitaServicio] WITH (UPDLOCK) WHERE [CitaServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D12", "INSERT INTO [CitaServicio]([CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000D13", "UPDATE [CitaServicio] SET [CitaServicioFlag]=?, [CitaServicioEstado]=?, [CitaId]=?, [ServicioId]=?  WHERE [CitaServicioId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000D14", "DELETE FROM [CitaServicio]  WHERE [CitaServicioId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000D15", "SELECT TM1.[CitaServicioId], TM1.[CitaServicioFlag], TM1.[CitaServicioEstado], TM1.[CitaId], TM1.[ServicioId] FROM [CitaServicio] TM1 WHERE TM1.[CitaServicioId] = ? ORDER BY TM1.[CitaServicioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
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

