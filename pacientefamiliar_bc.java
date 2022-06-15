package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pacientefamiliar_bc extends GXWebPanel implements IGxSilentTrn
{
   public pacientefamiliar_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pacientefamiliar_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacientefamiliar_bc.class ));
   }

   public pacientefamiliar_bc( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0S37( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0S37( ) ;
      standaloneModal( ) ;
      addRow0S37( ) ;
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
            Z45PacienteFamiliarId = A45PacienteFamiliarId ;
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

   public void confirm_0S0( )
   {
      beforeValidate0S37( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0S37( ) ;
         }
         else
         {
            checkExtendedTable0S37( ) ;
            if ( AnyError == 0 )
            {
               zm0S37( 4) ;
               zm0S37( 5) ;
            }
            closeExtendedTableCursors0S37( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0S37( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z235PacienteFamiliarParentesco = A235PacienteFamiliarParentesco ;
         Z236PacienteFamiliarEstado = A236PacienteFamiliarEstado ;
         Z20PacienteId = A20PacienteId ;
         Z46SGPacienteHijoPacienteId = A46SGPacienteHijoPacienteId ;
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z232SGPacienteHijoNombres = A232SGPacienteHijoNombres ;
         Z233SGPacienteHijoApellidoPaterno = A233SGPacienteHijoApellidoPaterno ;
         Z234SGPacienteHijoApellidoMaterno = A234SGPacienteHijoApellidoMaterno ;
      }
      if ( GX_JID == -3 )
      {
         Z45PacienteFamiliarId = A45PacienteFamiliarId ;
         Z235PacienteFamiliarParentesco = A235PacienteFamiliarParentesco ;
         Z236PacienteFamiliarEstado = A236PacienteFamiliarEstado ;
         Z20PacienteId = A20PacienteId ;
         Z46SGPacienteHijoPacienteId = A46SGPacienteHijoPacienteId ;
         Z232SGPacienteHijoNombres = A232SGPacienteHijoNombres ;
         Z233SGPacienteHijoApellidoPaterno = A233SGPacienteHijoApellidoPaterno ;
         Z234SGPacienteHijoApellidoMaterno = A234SGPacienteHijoApellidoMaterno ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0S37( )
   {
      /* Using cursor BC000S6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A232SGPacienteHijoNombres = BC000S6_A232SGPacienteHijoNombres[0] ;
         A233SGPacienteHijoApellidoPaterno = BC000S6_A233SGPacienteHijoApellidoPaterno[0] ;
         A234SGPacienteHijoApellidoMaterno = BC000S6_A234SGPacienteHijoApellidoMaterno[0] ;
         A235PacienteFamiliarParentesco = BC000S6_A235PacienteFamiliarParentesco[0] ;
         A236PacienteFamiliarEstado = BC000S6_A236PacienteFamiliarEstado[0] ;
         A20PacienteId = BC000S6_A20PacienteId[0] ;
         A46SGPacienteHijoPacienteId = BC000S6_A46SGPacienteHijoPacienteId[0] ;
         zm0S37( -3) ;
      }
      pr_default.close(4);
      onLoadActions0S37( ) ;
   }

   public void onLoadActions0S37( )
   {
   }

   public void checkExtendedTable0S37( )
   {
      nIsDirty_37 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000S7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC000S8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A46SGPacienteHijoPacienteId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente Hijo'.", "ForeignKeyNotFound", 1, "SGPACIENTEHIJOPACIENTEID");
         AnyError = (short)(1) ;
      }
      A232SGPacienteHijoNombres = BC000S8_A232SGPacienteHijoNombres[0] ;
      A233SGPacienteHijoApellidoPaterno = BC000S8_A233SGPacienteHijoApellidoPaterno[0] ;
      A234SGPacienteHijoApellidoMaterno = BC000S8_A234SGPacienteHijoApellidoMaterno[0] ;
      pr_default.close(6);
      if ( ! ( ( GXutil.strcmp(A235PacienteFamiliarParentesco, "H") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "P") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "M") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "HM") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "S") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "T") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "A") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "N") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "O") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Familiar Parentesco fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A236PacienteFamiliarEstado, "A") == 0 ) || ( GXutil.strcmp(A236PacienteFamiliarEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Familiar Estado fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0S37( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0S37( )
   {
      /* Using cursor BC000S9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound37 = (short)(1) ;
      }
      else
      {
         RcdFound37 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000S10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0S37( 3) ;
         RcdFound37 = (short)(1) ;
         A45PacienteFamiliarId = BC000S10_A45PacienteFamiliarId[0] ;
         A235PacienteFamiliarParentesco = BC000S10_A235PacienteFamiliarParentesco[0] ;
         A236PacienteFamiliarEstado = BC000S10_A236PacienteFamiliarEstado[0] ;
         A20PacienteId = BC000S10_A20PacienteId[0] ;
         A46SGPacienteHijoPacienteId = BC000S10_A46SGPacienteHijoPacienteId[0] ;
         Z45PacienteFamiliarId = A45PacienteFamiliarId ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0S37( ) ;
         if ( AnyError == 1 )
         {
            RcdFound37 = (short)(0) ;
            initializeNonKey0S37( ) ;
         }
         Gx_mode = sMode37 ;
      }
      else
      {
         RcdFound37 = (short)(0) ;
         initializeNonKey0S37( ) ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode37 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0S37( ) ;
      if ( RcdFound37 == 0 )
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
      confirm_0S0( ) ;
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

   public void checkOptimisticConcurrency0S37( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000S11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PacienteFamiliar"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z235PacienteFamiliarParentesco, BC000S11_A235PacienteFamiliarParentesco[0]) != 0 ) || ( GXutil.strcmp(Z236PacienteFamiliarEstado, BC000S11_A236PacienteFamiliarEstado[0]) != 0 ) || ( Z20PacienteId != BC000S11_A20PacienteId[0] ) || ( Z46SGPacienteHijoPacienteId != BC000S11_A46SGPacienteHijoPacienteId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PacienteFamiliar"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0S37( )
   {
      beforeValidate0S37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S37( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0S37( 0) ;
         checkOptimisticConcurrency0S37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S37( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0S37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000S12 */
                  pr_default.execute(10, new Object[] {A235PacienteFamiliarParentesco, A236PacienteFamiliarEstado, Integer.valueOf(A20PacienteId), Integer.valueOf(A46SGPacienteHijoPacienteId)});
                  A45PacienteFamiliarId = BC000S12_A45PacienteFamiliarId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PacienteFamiliar");
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
            load0S37( ) ;
         }
         endLevel0S37( ) ;
      }
      closeExtendedTableCursors0S37( ) ;
   }

   public void update0S37( )
   {
      beforeValidate0S37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S37( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S37( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0S37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000S13 */
                  pr_default.execute(11, new Object[] {A235PacienteFamiliarParentesco, A236PacienteFamiliarEstado, Integer.valueOf(A20PacienteId), Integer.valueOf(A46SGPacienteHijoPacienteId), Integer.valueOf(A45PacienteFamiliarId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PacienteFamiliar");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PacienteFamiliar"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0S37( ) ;
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
         endLevel0S37( ) ;
      }
      closeExtendedTableCursors0S37( ) ;
   }

   public void deferredUpdate0S37( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0S37( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S37( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0S37( ) ;
         afterConfirm0S37( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0S37( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000S14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PacienteFamiliar");
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
      sMode37 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0S37( ) ;
      Gx_mode = sMode37 ;
   }

   public void onDeleteControls0S37( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000S15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A46SGPacienteHijoPacienteId)});
         A232SGPacienteHijoNombres = BC000S15_A232SGPacienteHijoNombres[0] ;
         A233SGPacienteHijoApellidoPaterno = BC000S15_A233SGPacienteHijoApellidoPaterno[0] ;
         A234SGPacienteHijoApellidoMaterno = BC000S15_A234SGPacienteHijoApellidoMaterno[0] ;
         pr_default.close(13);
      }
   }

   public void endLevel0S37( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0S37( ) ;
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

   public void scanKeyStart0S37( )
   {
      /* Using cursor BC000S16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A45PacienteFamiliarId = BC000S16_A45PacienteFamiliarId[0] ;
         A232SGPacienteHijoNombres = BC000S16_A232SGPacienteHijoNombres[0] ;
         A233SGPacienteHijoApellidoPaterno = BC000S16_A233SGPacienteHijoApellidoPaterno[0] ;
         A234SGPacienteHijoApellidoMaterno = BC000S16_A234SGPacienteHijoApellidoMaterno[0] ;
         A235PacienteFamiliarParentesco = BC000S16_A235PacienteFamiliarParentesco[0] ;
         A236PacienteFamiliarEstado = BC000S16_A236PacienteFamiliarEstado[0] ;
         A20PacienteId = BC000S16_A20PacienteId[0] ;
         A46SGPacienteHijoPacienteId = BC000S16_A46SGPacienteHijoPacienteId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0S37( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound37 = (short)(0) ;
      scanKeyLoad0S37( ) ;
   }

   public void scanKeyLoad0S37( )
   {
      sMode37 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A45PacienteFamiliarId = BC000S16_A45PacienteFamiliarId[0] ;
         A232SGPacienteHijoNombres = BC000S16_A232SGPacienteHijoNombres[0] ;
         A233SGPacienteHijoApellidoPaterno = BC000S16_A233SGPacienteHijoApellidoPaterno[0] ;
         A234SGPacienteHijoApellidoMaterno = BC000S16_A234SGPacienteHijoApellidoMaterno[0] ;
         A235PacienteFamiliarParentesco = BC000S16_A235PacienteFamiliarParentesco[0] ;
         A236PacienteFamiliarEstado = BC000S16_A236PacienteFamiliarEstado[0] ;
         A20PacienteId = BC000S16_A20PacienteId[0] ;
         A46SGPacienteHijoPacienteId = BC000S16_A46SGPacienteHijoPacienteId[0] ;
      }
      Gx_mode = sMode37 ;
   }

   public void scanKeyEnd0S37( )
   {
      pr_default.close(14);
   }

   public void afterConfirm0S37( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0S37( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0S37( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0S37( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0S37( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0S37( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0S37( )
   {
   }

   public void send_integrity_lvl_hashes0S37( )
   {
   }

   public void addRow0S37( )
   {
      VarsToRow37( bcPacienteFamiliar) ;
   }

   public void readRow0S37( )
   {
      RowToVars37( bcPacienteFamiliar, 1) ;
   }

   public void initializeNonKey0S37( )
   {
      A20PacienteId = 0 ;
      A46SGPacienteHijoPacienteId = 0 ;
      A232SGPacienteHijoNombres = "" ;
      A233SGPacienteHijoApellidoPaterno = "" ;
      A234SGPacienteHijoApellidoMaterno = "" ;
      A235PacienteFamiliarParentesco = "" ;
      A236PacienteFamiliarEstado = "" ;
      Z235PacienteFamiliarParentesco = "" ;
      Z236PacienteFamiliarEstado = "" ;
      Z20PacienteId = 0 ;
      Z46SGPacienteHijoPacienteId = 0 ;
   }

   public void initAll0S37( )
   {
      A45PacienteFamiliarId = 0 ;
      initializeNonKey0S37( ) ;
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

   public void VarsToRow37( com.projectthani.SdtPacienteFamiliar obj37 )
   {
      obj37.setgxTv_SdtPacienteFamiliar_Mode( Gx_mode );
      obj37.setgxTv_SdtPacienteFamiliar_Pacienteid( A20PacienteId );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid( A46SGPacienteHijoPacienteId );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres( A232SGPacienteHijoNombres );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno( A233SGPacienteHijoApellidoPaterno );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno( A234SGPacienteHijoApellidoMaterno );
      obj37.setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco( A235PacienteFamiliarParentesco );
      obj37.setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado( A236PacienteFamiliarEstado );
      obj37.setgxTv_SdtPacienteFamiliar_Pacientefamiliarid( A45PacienteFamiliarId );
      obj37.setgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z( Z45PacienteFamiliarId );
      obj37.setgxTv_SdtPacienteFamiliar_Pacienteid_Z( Z20PacienteId );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z( Z46SGPacienteHijoPacienteId );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z( Z232SGPacienteHijoNombres );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z( Z233SGPacienteHijoApellidoPaterno );
      obj37.setgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z( Z234SGPacienteHijoApellidoMaterno );
      obj37.setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z( Z235PacienteFamiliarParentesco );
      obj37.setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z( Z236PacienteFamiliarEstado );
      obj37.setgxTv_SdtPacienteFamiliar_Mode( Gx_mode );
   }

   public void KeyVarsToRow37( com.projectthani.SdtPacienteFamiliar obj37 )
   {
      obj37.setgxTv_SdtPacienteFamiliar_Pacientefamiliarid( A45PacienteFamiliarId );
   }

   public void RowToVars37( com.projectthani.SdtPacienteFamiliar obj37 ,
                            int forceLoad )
   {
      Gx_mode = obj37.getgxTv_SdtPacienteFamiliar_Mode() ;
      A20PacienteId = obj37.getgxTv_SdtPacienteFamiliar_Pacienteid() ;
      A46SGPacienteHijoPacienteId = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid() ;
      A232SGPacienteHijoNombres = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres() ;
      A233SGPacienteHijoApellidoPaterno = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno() ;
      A234SGPacienteHijoApellidoMaterno = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno() ;
      A235PacienteFamiliarParentesco = obj37.getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco() ;
      A236PacienteFamiliarEstado = obj37.getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado() ;
      A45PacienteFamiliarId = obj37.getgxTv_SdtPacienteFamiliar_Pacientefamiliarid() ;
      Z45PacienteFamiliarId = obj37.getgxTv_SdtPacienteFamiliar_Pacientefamiliarid_Z() ;
      Z20PacienteId = obj37.getgxTv_SdtPacienteFamiliar_Pacienteid_Z() ;
      Z46SGPacienteHijoPacienteId = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid_Z() ;
      Z232SGPacienteHijoNombres = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijonombres_Z() ;
      Z233SGPacienteHijoApellidoPaterno = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidopaterno_Z() ;
      Z234SGPacienteHijoApellidoMaterno = obj37.getgxTv_SdtPacienteFamiliar_Sgpacientehijoapellidomaterno_Z() ;
      Z235PacienteFamiliarParentesco = obj37.getgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco_Z() ;
      Z236PacienteFamiliarEstado = obj37.getgxTv_SdtPacienteFamiliar_Pacientefamiliarestado_Z() ;
      Gx_mode = obj37.getgxTv_SdtPacienteFamiliar_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A45PacienteFamiliarId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0S37( ) ;
      scanKeyStart0S37( ) ;
      if ( RcdFound37 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z45PacienteFamiliarId = A45PacienteFamiliarId ;
      }
      zm0S37( -3) ;
      onLoadActions0S37( ) ;
      addRow0S37( ) ;
      scanKeyEnd0S37( ) ;
      if ( RcdFound37 == 0 )
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
      RowToVars37( bcPacienteFamiliar, 0) ;
      scanKeyStart0S37( ) ;
      if ( RcdFound37 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z45PacienteFamiliarId = A45PacienteFamiliarId ;
      }
      zm0S37( -3) ;
      onLoadActions0S37( ) ;
      addRow0S37( ) ;
      scanKeyEnd0S37( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0S37( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0S37( ) ;
      }
      else
      {
         if ( RcdFound37 == 1 )
         {
            if ( A45PacienteFamiliarId != Z45PacienteFamiliarId )
            {
               A45PacienteFamiliarId = Z45PacienteFamiliarId ;
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
               update0S37( ) ;
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
               if ( A45PacienteFamiliarId != Z45PacienteFamiliarId )
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
                     insert0S37( ) ;
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
                     insert0S37( ) ;
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
      RowToVars37( bcPacienteFamiliar, 1) ;
      saveImpl( ) ;
      VarsToRow37( bcPacienteFamiliar) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars37( bcPacienteFamiliar, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0S37( ) ;
      afterTrn( ) ;
      VarsToRow37( bcPacienteFamiliar) ;
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
         com.projectthani.SdtPacienteFamiliar auxBC = new com.projectthani.SdtPacienteFamiliar( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A45PacienteFamiliarId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcPacienteFamiliar);
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
      RowToVars37( bcPacienteFamiliar, 1) ;
      updateImpl( ) ;
      VarsToRow37( bcPacienteFamiliar) ;
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
      RowToVars37( bcPacienteFamiliar, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0S37( ) ;
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
      VarsToRow37( bcPacienteFamiliar) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars37( bcPacienteFamiliar, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0S37( ) ;
      if ( RcdFound37 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A45PacienteFamiliarId != Z45PacienteFamiliarId )
         {
            A45PacienteFamiliarId = Z45PacienteFamiliarId ;
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
         if ( A45PacienteFamiliarId != Z45PacienteFamiliarId )
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
      pr_default.close(13);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "pacientefamiliar_bc");
      VarsToRow37( bcPacienteFamiliar) ;
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
      Gx_mode = bcPacienteFamiliar.getgxTv_SdtPacienteFamiliar_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcPacienteFamiliar.setgxTv_SdtPacienteFamiliar_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtPacienteFamiliar sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcPacienteFamiliar )
      {
         bcPacienteFamiliar = sdt ;
         if ( GXutil.strcmp(bcPacienteFamiliar.getgxTv_SdtPacienteFamiliar_Mode(), "") == 0 )
         {
            bcPacienteFamiliar.setgxTv_SdtPacienteFamiliar_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow37( bcPacienteFamiliar) ;
         }
         else
         {
            RowToVars37( bcPacienteFamiliar, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcPacienteFamiliar.getgxTv_SdtPacienteFamiliar_Mode(), "") == 0 )
         {
            bcPacienteFamiliar.setgxTv_SdtPacienteFamiliar_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars37( bcPacienteFamiliar, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtPacienteFamiliar getPacienteFamiliar_BC( )
   {
      return bcPacienteFamiliar ;
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
      Z235PacienteFamiliarParentesco = "" ;
      A235PacienteFamiliarParentesco = "" ;
      Z236PacienteFamiliarEstado = "" ;
      A236PacienteFamiliarEstado = "" ;
      Z232SGPacienteHijoNombres = "" ;
      A232SGPacienteHijoNombres = "" ;
      Z233SGPacienteHijoApellidoPaterno = "" ;
      A233SGPacienteHijoApellidoPaterno = "" ;
      Z234SGPacienteHijoApellidoMaterno = "" ;
      A234SGPacienteHijoApellidoMaterno = "" ;
      BC000S6_A45PacienteFamiliarId = new int[1] ;
      BC000S6_A232SGPacienteHijoNombres = new String[] {""} ;
      BC000S6_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      BC000S6_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      BC000S6_A235PacienteFamiliarParentesco = new String[] {""} ;
      BC000S6_A236PacienteFamiliarEstado = new String[] {""} ;
      BC000S6_A20PacienteId = new int[1] ;
      BC000S6_A46SGPacienteHijoPacienteId = new int[1] ;
      BC000S7_A20PacienteId = new int[1] ;
      BC000S8_A232SGPacienteHijoNombres = new String[] {""} ;
      BC000S8_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      BC000S8_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      BC000S9_A45PacienteFamiliarId = new int[1] ;
      BC000S10_A45PacienteFamiliarId = new int[1] ;
      BC000S10_A235PacienteFamiliarParentesco = new String[] {""} ;
      BC000S10_A236PacienteFamiliarEstado = new String[] {""} ;
      BC000S10_A20PacienteId = new int[1] ;
      BC000S10_A46SGPacienteHijoPacienteId = new int[1] ;
      sMode37 = "" ;
      BC000S11_A45PacienteFamiliarId = new int[1] ;
      BC000S11_A235PacienteFamiliarParentesco = new String[] {""} ;
      BC000S11_A236PacienteFamiliarEstado = new String[] {""} ;
      BC000S11_A20PacienteId = new int[1] ;
      BC000S11_A46SGPacienteHijoPacienteId = new int[1] ;
      BC000S12_A45PacienteFamiliarId = new int[1] ;
      BC000S15_A232SGPacienteHijoNombres = new String[] {""} ;
      BC000S15_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      BC000S15_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      BC000S16_A45PacienteFamiliarId = new int[1] ;
      BC000S16_A232SGPacienteHijoNombres = new String[] {""} ;
      BC000S16_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      BC000S16_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      BC000S16_A235PacienteFamiliarParentesco = new String[] {""} ;
      BC000S16_A236PacienteFamiliarEstado = new String[] {""} ;
      BC000S16_A20PacienteId = new int[1] ;
      BC000S16_A46SGPacienteHijoPacienteId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacientefamiliar_bc__default(),
         new Object[] {
             new Object[] {
            BC000S2_A45PacienteFamiliarId, BC000S2_A235PacienteFamiliarParentesco, BC000S2_A236PacienteFamiliarEstado, BC000S2_A20PacienteId, BC000S2_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            BC000S3_A45PacienteFamiliarId, BC000S3_A235PacienteFamiliarParentesco, BC000S3_A236PacienteFamiliarEstado, BC000S3_A20PacienteId, BC000S3_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            BC000S4_A20PacienteId
            }
            , new Object[] {
            BC000S5_A232SGPacienteHijoNombres, BC000S5_A233SGPacienteHijoApellidoPaterno, BC000S5_A234SGPacienteHijoApellidoMaterno
            }
            , new Object[] {
            BC000S6_A45PacienteFamiliarId, BC000S6_A232SGPacienteHijoNombres, BC000S6_A233SGPacienteHijoApellidoPaterno, BC000S6_A234SGPacienteHijoApellidoMaterno, BC000S6_A235PacienteFamiliarParentesco, BC000S6_A236PacienteFamiliarEstado, BC000S6_A20PacienteId, BC000S6_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            BC000S7_A20PacienteId
            }
            , new Object[] {
            BC000S8_A232SGPacienteHijoNombres, BC000S8_A233SGPacienteHijoApellidoPaterno, BC000S8_A234SGPacienteHijoApellidoMaterno
            }
            , new Object[] {
            BC000S9_A45PacienteFamiliarId
            }
            , new Object[] {
            BC000S10_A45PacienteFamiliarId, BC000S10_A235PacienteFamiliarParentesco, BC000S10_A236PacienteFamiliarEstado, BC000S10_A20PacienteId, BC000S10_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            BC000S11_A45PacienteFamiliarId, BC000S11_A235PacienteFamiliarParentesco, BC000S11_A236PacienteFamiliarEstado, BC000S11_A20PacienteId, BC000S11_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            BC000S12_A45PacienteFamiliarId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000S15_A232SGPacienteHijoNombres, BC000S15_A233SGPacienteHijoApellidoPaterno, BC000S15_A234SGPacienteHijoApellidoMaterno
            }
            , new Object[] {
            BC000S16_A45PacienteFamiliarId, BC000S16_A232SGPacienteHijoNombres, BC000S16_A233SGPacienteHijoApellidoPaterno, BC000S16_A234SGPacienteHijoApellidoMaterno, BC000S16_A235PacienteFamiliarParentesco, BC000S16_A236PacienteFamiliarEstado, BC000S16_A20PacienteId, BC000S16_A46SGPacienteHijoPacienteId
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
   private short RcdFound37 ;
   private short nIsDirty_37 ;
   private int trnEnded ;
   private int Z45PacienteFamiliarId ;
   private int A45PacienteFamiliarId ;
   private int GX_JID ;
   private int Z20PacienteId ;
   private int A20PacienteId ;
   private int Z46SGPacienteHijoPacienteId ;
   private int A46SGPacienteHijoPacienteId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z235PacienteFamiliarParentesco ;
   private String A235PacienteFamiliarParentesco ;
   private String Z236PacienteFamiliarEstado ;
   private String A236PacienteFamiliarEstado ;
   private String sMode37 ;
   private boolean mustCommit ;
   private String Z232SGPacienteHijoNombres ;
   private String A232SGPacienteHijoNombres ;
   private String Z233SGPacienteHijoApellidoPaterno ;
   private String A233SGPacienteHijoApellidoPaterno ;
   private String Z234SGPacienteHijoApellidoMaterno ;
   private String A234SGPacienteHijoApellidoMaterno ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtPacienteFamiliar bcPacienteFamiliar ;
   private IDataStoreProvider pr_default ;
   private int[] BC000S6_A45PacienteFamiliarId ;
   private String[] BC000S6_A232SGPacienteHijoNombres ;
   private String[] BC000S6_A233SGPacienteHijoApellidoPaterno ;
   private String[] BC000S6_A234SGPacienteHijoApellidoMaterno ;
   private String[] BC000S6_A235PacienteFamiliarParentesco ;
   private String[] BC000S6_A236PacienteFamiliarEstado ;
   private int[] BC000S6_A20PacienteId ;
   private int[] BC000S6_A46SGPacienteHijoPacienteId ;
   private int[] BC000S7_A20PacienteId ;
   private String[] BC000S8_A232SGPacienteHijoNombres ;
   private String[] BC000S8_A233SGPacienteHijoApellidoPaterno ;
   private String[] BC000S8_A234SGPacienteHijoApellidoMaterno ;
   private int[] BC000S9_A45PacienteFamiliarId ;
   private int[] BC000S10_A45PacienteFamiliarId ;
   private String[] BC000S10_A235PacienteFamiliarParentesco ;
   private String[] BC000S10_A236PacienteFamiliarEstado ;
   private int[] BC000S10_A20PacienteId ;
   private int[] BC000S10_A46SGPacienteHijoPacienteId ;
   private int[] BC000S11_A45PacienteFamiliarId ;
   private String[] BC000S11_A235PacienteFamiliarParentesco ;
   private String[] BC000S11_A236PacienteFamiliarEstado ;
   private int[] BC000S11_A20PacienteId ;
   private int[] BC000S11_A46SGPacienteHijoPacienteId ;
   private int[] BC000S12_A45PacienteFamiliarId ;
   private String[] BC000S15_A232SGPacienteHijoNombres ;
   private String[] BC000S15_A233SGPacienteHijoApellidoPaterno ;
   private String[] BC000S15_A234SGPacienteHijoApellidoMaterno ;
   private int[] BC000S16_A45PacienteFamiliarId ;
   private String[] BC000S16_A232SGPacienteHijoNombres ;
   private String[] BC000S16_A233SGPacienteHijoApellidoPaterno ;
   private String[] BC000S16_A234SGPacienteHijoApellidoMaterno ;
   private String[] BC000S16_A235PacienteFamiliarParentesco ;
   private String[] BC000S16_A236PacienteFamiliarEstado ;
   private int[] BC000S16_A20PacienteId ;
   private int[] BC000S16_A46SGPacienteHijoPacienteId ;
   private int[] BC000S2_A45PacienteFamiliarId ;
   private String[] BC000S2_A235PacienteFamiliarParentesco ;
   private String[] BC000S2_A236PacienteFamiliarEstado ;
   private int[] BC000S2_A20PacienteId ;
   private int[] BC000S2_A46SGPacienteHijoPacienteId ;
   private int[] BC000S3_A45PacienteFamiliarId ;
   private String[] BC000S3_A235PacienteFamiliarParentesco ;
   private String[] BC000S3_A236PacienteFamiliarEstado ;
   private int[] BC000S3_A20PacienteId ;
   private int[] BC000S3_A46SGPacienteHijoPacienteId ;
   private int[] BC000S4_A20PacienteId ;
   private String[] BC000S5_A232SGPacienteHijoNombres ;
   private String[] BC000S5_A233SGPacienteHijoApellidoPaterno ;
   private String[] BC000S5_A234SGPacienteHijoApellidoMaterno ;
}

final  class pacientefamiliar_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000S2", "SELECT [PacienteFamiliarId], [PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM [PacienteFamiliar] WITH (UPDLOCK) WHERE [PacienteFamiliarId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S3", "SELECT [PacienteFamiliarId], [PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM [PacienteFamiliar] WHERE [PacienteFamiliarId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S4", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S5", "SELECT [PacienteNombres] AS SGPacienteHijoNombres, [PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, [PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S6", "SELECT TM1.[PacienteFamiliarId], T2.[PacienteNombres] AS SGPacienteHijoNombres, T2.[PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, T2.[PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno, TM1.[PacienteFamiliarParentesco], TM1.[PacienteFamiliarEstado], TM1.[PacienteId], TM1.[SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM ([PacienteFamiliar] TM1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = TM1.[SGPacienteHijoPacienteId]) WHERE TM1.[PacienteFamiliarId] = ? ORDER BY TM1.[PacienteFamiliarId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S7", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S8", "SELECT [PacienteNombres] AS SGPacienteHijoNombres, [PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, [PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S9", "SELECT [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [PacienteFamiliarId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S10", "SELECT [PacienteFamiliarId], [PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM [PacienteFamiliar] WHERE [PacienteFamiliarId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S11", "SELECT [PacienteFamiliarId], [PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM [PacienteFamiliar] WITH (UPDLOCK) WHERE [PacienteFamiliarId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S12", "INSERT INTO [PacienteFamiliar]([PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC000S13", "UPDATE [PacienteFamiliar] SET [PacienteFamiliarParentesco]=?, [PacienteFamiliarEstado]=?, [PacienteId]=?, [SGPacienteHijoPacienteId]=?  WHERE [PacienteFamiliarId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000S14", "DELETE FROM [PacienteFamiliar]  WHERE [PacienteFamiliarId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000S15", "SELECT [PacienteNombres] AS SGPacienteHijoNombres, [PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, [PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S16", "SELECT TM1.[PacienteFamiliarId], T2.[PacienteNombres] AS SGPacienteHijoNombres, T2.[PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, T2.[PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno, TM1.[PacienteFamiliarParentesco], TM1.[PacienteFamiliarEstado], TM1.[PacienteId], TM1.[SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM ([PacienteFamiliar] TM1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = TM1.[SGPacienteHijoPacienteId]) WHERE TM1.[PacienteFamiliarId] = ? ORDER BY TM1.[PacienteFamiliarId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 2);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 2);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
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
               stmt.setString(1, (String)parms[0], 2);
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 2);
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

