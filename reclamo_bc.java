package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class reclamo_bc extends GXWebPanel implements IGxSilentTrn
{
   public reclamo_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public reclamo_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reclamo_bc.class ));
   }

   public reclamo_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0H24( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0H24( ) ;
      standaloneModal( ) ;
      addRow0H24( ) ;
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
         e110H2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z51ReclamoId = A51ReclamoId ;
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

   public void confirm_0H0( )
   {
      beforeValidate0H24( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0H24( ) ;
         }
         else
         {
            checkExtendedTable0H24( ) ;
            if ( AnyError == 0 )
            {
               zm0H24( 3) ;
            }
            closeExtendedTableCursors0H24( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120H2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e110H2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0H24( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z275ReclamoFecha = A275ReclamoFecha ;
         Z20PacienteId = A20PacienteId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z51ReclamoId = A51ReclamoId ;
         Z274ReclamoDescripcion = A274ReclamoDescripcion ;
         Z275ReclamoFecha = A275ReclamoFecha ;
         Z20PacienteId = A20PacienteId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0H24( )
   {
      /* Using cursor BC000H5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A51ReclamoId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A274ReclamoDescripcion = BC000H5_A274ReclamoDescripcion[0] ;
         A275ReclamoFecha = BC000H5_A275ReclamoFecha[0] ;
         A20PacienteId = BC000H5_A20PacienteId[0] ;
         zm0H24( -2) ;
      }
      pr_default.close(3);
      onLoadActions0H24( ) ;
   }

   public void onLoadActions0H24( )
   {
   }

   public void checkExtendedTable0H24( )
   {
      nIsDirty_24 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000H6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A275ReclamoFecha) || (( A275ReclamoFecha.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A275ReclamoFecha, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Reclamo Fecha fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0H24( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0H24( )
   {
      /* Using cursor BC000H7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A51ReclamoId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound24 = (short)(1) ;
      }
      else
      {
         RcdFound24 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000H8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A51ReclamoId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0H24( 2) ;
         RcdFound24 = (short)(1) ;
         A51ReclamoId = BC000H8_A51ReclamoId[0] ;
         A274ReclamoDescripcion = BC000H8_A274ReclamoDescripcion[0] ;
         A275ReclamoFecha = BC000H8_A275ReclamoFecha[0] ;
         A20PacienteId = BC000H8_A20PacienteId[0] ;
         Z51ReclamoId = A51ReclamoId ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0H24( ) ;
         if ( AnyError == 1 )
         {
            RcdFound24 = (short)(0) ;
            initializeNonKey0H24( ) ;
         }
         Gx_mode = sMode24 ;
      }
      else
      {
         RcdFound24 = (short)(0) ;
         initializeNonKey0H24( ) ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode24 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0H24( ) ;
      if ( RcdFound24 == 0 )
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
      confirm_0H0( ) ;
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

   public void checkOptimisticConcurrency0H24( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000H9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A51ReclamoId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Reclamo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || !( GXutil.dateCompare(Z275ReclamoFecha, BC000H9_A275ReclamoFecha[0]) ) || ( Z20PacienteId != BC000H9_A20PacienteId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Reclamo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0H24( )
   {
      beforeValidate0H24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0H24( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0H24( 0) ;
         checkOptimisticConcurrency0H24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0H24( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0H24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000H10 */
                  pr_default.execute(8, new Object[] {A274ReclamoDescripcion, A275ReclamoFecha, Integer.valueOf(A20PacienteId)});
                  A51ReclamoId = BC000H10_A51ReclamoId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Reclamo");
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
            load0H24( ) ;
         }
         endLevel0H24( ) ;
      }
      closeExtendedTableCursors0H24( ) ;
   }

   public void update0H24( )
   {
      beforeValidate0H24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0H24( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0H24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0H24( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0H24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000H11 */
                  pr_default.execute(9, new Object[] {A274ReclamoDescripcion, A275ReclamoFecha, Integer.valueOf(A20PacienteId), Integer.valueOf(A51ReclamoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Reclamo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Reclamo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0H24( ) ;
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
         endLevel0H24( ) ;
      }
      closeExtendedTableCursors0H24( ) ;
   }

   public void deferredUpdate0H24( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0H24( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0H24( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0H24( ) ;
         afterConfirm0H24( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0H24( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000H12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A51ReclamoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Reclamo");
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
      sMode24 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0H24( ) ;
      Gx_mode = sMode24 ;
   }

   public void onDeleteControls0H24( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0H24( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0H24( ) ;
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

   public void scanKeyStart0H24( )
   {
      /* Scan By routine */
      /* Using cursor BC000H13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A51ReclamoId)});
      RcdFound24 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A51ReclamoId = BC000H13_A51ReclamoId[0] ;
         A274ReclamoDescripcion = BC000H13_A274ReclamoDescripcion[0] ;
         A275ReclamoFecha = BC000H13_A275ReclamoFecha[0] ;
         A20PacienteId = BC000H13_A20PacienteId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0H24( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound24 = (short)(0) ;
      scanKeyLoad0H24( ) ;
   }

   public void scanKeyLoad0H24( )
   {
      sMode24 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A51ReclamoId = BC000H13_A51ReclamoId[0] ;
         A274ReclamoDescripcion = BC000H13_A274ReclamoDescripcion[0] ;
         A275ReclamoFecha = BC000H13_A275ReclamoFecha[0] ;
         A20PacienteId = BC000H13_A20PacienteId[0] ;
      }
      Gx_mode = sMode24 ;
   }

   public void scanKeyEnd0H24( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0H24( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0H24( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0H24( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0H24( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0H24( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0H24( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0H24( )
   {
   }

   public void send_integrity_lvl_hashes0H24( )
   {
   }

   public void addRow0H24( )
   {
      VarsToRow24( bcReclamo) ;
   }

   public void readRow0H24( )
   {
      RowToVars24( bcReclamo, 1) ;
   }

   public void initializeNonKey0H24( )
   {
      A20PacienteId = 0 ;
      A274ReclamoDescripcion = "" ;
      A275ReclamoFecha = GXutil.resetTime( GXutil.nullDate() );
      Z275ReclamoFecha = GXutil.resetTime( GXutil.nullDate() );
      Z20PacienteId = 0 ;
   }

   public void initAll0H24( )
   {
      A51ReclamoId = 0 ;
      initializeNonKey0H24( ) ;
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

   public void VarsToRow24( com.projectthani.SdtReclamo obj24 )
   {
      obj24.setgxTv_SdtReclamo_Mode( Gx_mode );
      obj24.setgxTv_SdtReclamo_Pacienteid( A20PacienteId );
      obj24.setgxTv_SdtReclamo_Reclamodescripcion( A274ReclamoDescripcion );
      obj24.setgxTv_SdtReclamo_Reclamofecha( A275ReclamoFecha );
      obj24.setgxTv_SdtReclamo_Reclamoid( A51ReclamoId );
      obj24.setgxTv_SdtReclamo_Reclamoid_Z( Z51ReclamoId );
      obj24.setgxTv_SdtReclamo_Pacienteid_Z( Z20PacienteId );
      obj24.setgxTv_SdtReclamo_Reclamofecha_Z( Z275ReclamoFecha );
      obj24.setgxTv_SdtReclamo_Mode( Gx_mode );
   }

   public void KeyVarsToRow24( com.projectthani.SdtReclamo obj24 )
   {
      obj24.setgxTv_SdtReclamo_Reclamoid( A51ReclamoId );
   }

   public void RowToVars24( com.projectthani.SdtReclamo obj24 ,
                            int forceLoad )
   {
      Gx_mode = obj24.getgxTv_SdtReclamo_Mode() ;
      A20PacienteId = obj24.getgxTv_SdtReclamo_Pacienteid() ;
      A274ReclamoDescripcion = obj24.getgxTv_SdtReclamo_Reclamodescripcion() ;
      A275ReclamoFecha = obj24.getgxTv_SdtReclamo_Reclamofecha() ;
      A51ReclamoId = obj24.getgxTv_SdtReclamo_Reclamoid() ;
      Z51ReclamoId = obj24.getgxTv_SdtReclamo_Reclamoid_Z() ;
      Z20PacienteId = obj24.getgxTv_SdtReclamo_Pacienteid_Z() ;
      Z275ReclamoFecha = obj24.getgxTv_SdtReclamo_Reclamofecha_Z() ;
      Gx_mode = obj24.getgxTv_SdtReclamo_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A51ReclamoId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0H24( ) ;
      scanKeyStart0H24( ) ;
      if ( RcdFound24 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z51ReclamoId = A51ReclamoId ;
      }
      zm0H24( -2) ;
      onLoadActions0H24( ) ;
      addRow0H24( ) ;
      scanKeyEnd0H24( ) ;
      if ( RcdFound24 == 0 )
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
      RowToVars24( bcReclamo, 0) ;
      scanKeyStart0H24( ) ;
      if ( RcdFound24 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z51ReclamoId = A51ReclamoId ;
      }
      zm0H24( -2) ;
      onLoadActions0H24( ) ;
      addRow0H24( ) ;
      scanKeyEnd0H24( ) ;
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0H24( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0H24( ) ;
      }
      else
      {
         if ( RcdFound24 == 1 )
         {
            if ( A51ReclamoId != Z51ReclamoId )
            {
               A51ReclamoId = Z51ReclamoId ;
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
               update0H24( ) ;
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
               if ( A51ReclamoId != Z51ReclamoId )
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
                     insert0H24( ) ;
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
                     insert0H24( ) ;
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
      RowToVars24( bcReclamo, 1) ;
      saveImpl( ) ;
      VarsToRow24( bcReclamo) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars24( bcReclamo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0H24( ) ;
      afterTrn( ) ;
      VarsToRow24( bcReclamo) ;
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
         com.projectthani.SdtReclamo auxBC = new com.projectthani.SdtReclamo( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A51ReclamoId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcReclamo);
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
      RowToVars24( bcReclamo, 1) ;
      updateImpl( ) ;
      VarsToRow24( bcReclamo) ;
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
      RowToVars24( bcReclamo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0H24( ) ;
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
      VarsToRow24( bcReclamo) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars24( bcReclamo, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0H24( ) ;
      if ( RcdFound24 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A51ReclamoId != Z51ReclamoId )
         {
            A51ReclamoId = Z51ReclamoId ;
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
         if ( A51ReclamoId != Z51ReclamoId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "reclamo_bc");
      VarsToRow24( bcReclamo) ;
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
      Gx_mode = bcReclamo.getgxTv_SdtReclamo_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcReclamo.setgxTv_SdtReclamo_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtReclamo sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcReclamo )
      {
         bcReclamo = sdt ;
         if ( GXutil.strcmp(bcReclamo.getgxTv_SdtReclamo_Mode(), "") == 0 )
         {
            bcReclamo.setgxTv_SdtReclamo_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow24( bcReclamo) ;
         }
         else
         {
            RowToVars24( bcReclamo, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcReclamo.getgxTv_SdtReclamo_Mode(), "") == 0 )
         {
            bcReclamo.setgxTv_SdtReclamo_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars24( bcReclamo, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtReclamo getReclamo_BC( )
   {
      return bcReclamo ;
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
      Z275ReclamoFecha = GXutil.resetTime( GXutil.nullDate() );
      A275ReclamoFecha = GXutil.resetTime( GXutil.nullDate() );
      Z274ReclamoDescripcion = "" ;
      A274ReclamoDescripcion = "" ;
      BC000H5_A51ReclamoId = new int[1] ;
      BC000H5_A274ReclamoDescripcion = new String[] {""} ;
      BC000H5_A275ReclamoFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000H5_A20PacienteId = new int[1] ;
      BC000H6_A20PacienteId = new int[1] ;
      BC000H7_A51ReclamoId = new int[1] ;
      BC000H8_A51ReclamoId = new int[1] ;
      BC000H8_A274ReclamoDescripcion = new String[] {""} ;
      BC000H8_A275ReclamoFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000H8_A20PacienteId = new int[1] ;
      sMode24 = "" ;
      BC000H9_A51ReclamoId = new int[1] ;
      BC000H9_A274ReclamoDescripcion = new String[] {""} ;
      BC000H9_A275ReclamoFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000H9_A20PacienteId = new int[1] ;
      BC000H10_A51ReclamoId = new int[1] ;
      BC000H13_A51ReclamoId = new int[1] ;
      BC000H13_A274ReclamoDescripcion = new String[] {""} ;
      BC000H13_A275ReclamoFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000H13_A20PacienteId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.reclamo_bc__default(),
         new Object[] {
             new Object[] {
            BC000H2_A51ReclamoId, BC000H2_A274ReclamoDescripcion, BC000H2_A275ReclamoFecha, BC000H2_A20PacienteId
            }
            , new Object[] {
            BC000H3_A51ReclamoId, BC000H3_A274ReclamoDescripcion, BC000H3_A275ReclamoFecha, BC000H3_A20PacienteId
            }
            , new Object[] {
            BC000H4_A20PacienteId
            }
            , new Object[] {
            BC000H5_A51ReclamoId, BC000H5_A274ReclamoDescripcion, BC000H5_A275ReclamoFecha, BC000H5_A20PacienteId
            }
            , new Object[] {
            BC000H6_A20PacienteId
            }
            , new Object[] {
            BC000H7_A51ReclamoId
            }
            , new Object[] {
            BC000H8_A51ReclamoId, BC000H8_A274ReclamoDescripcion, BC000H8_A275ReclamoFecha, BC000H8_A20PacienteId
            }
            , new Object[] {
            BC000H9_A51ReclamoId, BC000H9_A274ReclamoDescripcion, BC000H9_A275ReclamoFecha, BC000H9_A20PacienteId
            }
            , new Object[] {
            BC000H10_A51ReclamoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000H13_A51ReclamoId, BC000H13_A274ReclamoDescripcion, BC000H13_A275ReclamoFecha, BC000H13_A20PacienteId
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120H2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound24 ;
   private short nIsDirty_24 ;
   private int trnEnded ;
   private int Z51ReclamoId ;
   private int A51ReclamoId ;
   private int GX_JID ;
   private int Z20PacienteId ;
   private int A20PacienteId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode24 ;
   private java.util.Date Z275ReclamoFecha ;
   private java.util.Date A275ReclamoFecha ;
   private boolean returnInSub ;
   private boolean mustCommit ;
   private String Z274ReclamoDescripcion ;
   private String A274ReclamoDescripcion ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtReclamo bcReclamo ;
   private IDataStoreProvider pr_default ;
   private int[] BC000H5_A51ReclamoId ;
   private String[] BC000H5_A274ReclamoDescripcion ;
   private java.util.Date[] BC000H5_A275ReclamoFecha ;
   private int[] BC000H5_A20PacienteId ;
   private int[] BC000H6_A20PacienteId ;
   private int[] BC000H7_A51ReclamoId ;
   private int[] BC000H8_A51ReclamoId ;
   private String[] BC000H8_A274ReclamoDescripcion ;
   private java.util.Date[] BC000H8_A275ReclamoFecha ;
   private int[] BC000H8_A20PacienteId ;
   private int[] BC000H9_A51ReclamoId ;
   private String[] BC000H9_A274ReclamoDescripcion ;
   private java.util.Date[] BC000H9_A275ReclamoFecha ;
   private int[] BC000H9_A20PacienteId ;
   private int[] BC000H10_A51ReclamoId ;
   private int[] BC000H13_A51ReclamoId ;
   private String[] BC000H13_A274ReclamoDescripcion ;
   private java.util.Date[] BC000H13_A275ReclamoFecha ;
   private int[] BC000H13_A20PacienteId ;
   private int[] BC000H2_A51ReclamoId ;
   private String[] BC000H2_A274ReclamoDescripcion ;
   private java.util.Date[] BC000H2_A275ReclamoFecha ;
   private int[] BC000H2_A20PacienteId ;
   private int[] BC000H3_A51ReclamoId ;
   private String[] BC000H3_A274ReclamoDescripcion ;
   private java.util.Date[] BC000H3_A275ReclamoFecha ;
   private int[] BC000H3_A20PacienteId ;
   private int[] BC000H4_A20PacienteId ;
}

final  class reclamo_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000H2", "SELECT [ReclamoId], [ReclamoDescripcion], [ReclamoFecha], [PacienteId] FROM [Reclamo] WITH (UPDLOCK) WHERE [ReclamoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H3", "SELECT [ReclamoId], [ReclamoDescripcion], [ReclamoFecha], [PacienteId] FROM [Reclamo] WHERE [ReclamoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H4", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H5", "SELECT TM1.[ReclamoId], TM1.[ReclamoDescripcion], TM1.[ReclamoFecha], TM1.[PacienteId] FROM [Reclamo] TM1 WHERE TM1.[ReclamoId] = ? ORDER BY TM1.[ReclamoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H6", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H7", "SELECT [ReclamoId] FROM [Reclamo] WHERE [ReclamoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H8", "SELECT [ReclamoId], [ReclamoDescripcion], [ReclamoFecha], [PacienteId] FROM [Reclamo] WHERE [ReclamoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H9", "SELECT [ReclamoId], [ReclamoDescripcion], [ReclamoFecha], [PacienteId] FROM [Reclamo] WITH (UPDLOCK) WHERE [ReclamoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000H10", "INSERT INTO [Reclamo]([ReclamoDescripcion], [ReclamoFecha], [PacienteId]) VALUES(?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000H11", "UPDATE [Reclamo] SET [ReclamoDescripcion]=?, [ReclamoFecha]=?, [PacienteId]=?  WHERE [ReclamoId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000H12", "DELETE FROM [Reclamo]  WHERE [ReclamoId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000H13", "SELECT TM1.[ReclamoId], TM1.[ReclamoDescripcion], TM1.[ReclamoFecha], TM1.[PacienteId] FROM [Reclamo] TM1 WHERE TM1.[ReclamoId] = ? ORDER BY TM1.[ReclamoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
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
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

