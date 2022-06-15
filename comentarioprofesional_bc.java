package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class comentarioprofesional_bc extends GXWebPanel implements IGxSilentTrn
{
   public comentarioprofesional_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public comentarioprofesional_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( comentarioprofesional_bc.class ));
   }

   public comentarioprofesional_bc( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1551( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1551( ) ;
      standaloneModal( ) ;
      addRow1551( ) ;
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
            Z63ComentarioProfesionalId = A63ComentarioProfesionalId ;
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

   public void confirm_150( )
   {
      beforeValidate1551( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1551( ) ;
         }
         else
         {
            checkExtendedTable1551( ) ;
            if ( AnyError == 0 )
            {
               zm1551( 3) ;
               zm1551( 4) ;
            }
            closeExtendedTableCursors1551( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm1551( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z384ComentarioProfesionalCitaId = A384ComentarioProfesionalCitaId ;
         Z386ComentarioProfesionalFechaRegistro = A386ComentarioProfesionalFechaRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
         Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z63ComentarioProfesionalId = A63ComentarioProfesionalId ;
         Z384ComentarioProfesionalCitaId = A384ComentarioProfesionalCitaId ;
         Z385ComentarioProfesionalComentario = A385ComentarioProfesionalComentario ;
         Z386ComentarioProfesionalFechaRegistro = A386ComentarioProfesionalFechaRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
         Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1551( )
   {
      /* Using cursor BC00156 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A384ComentarioProfesionalCitaId = BC00156_A384ComentarioProfesionalCitaId[0] ;
         A385ComentarioProfesionalComentario = BC00156_A385ComentarioProfesionalComentario[0] ;
         A386ComentarioProfesionalFechaRegistro = BC00156_A386ComentarioProfesionalFechaRegistro[0] ;
         A61SGPacientePacienteId = BC00156_A61SGPacientePacienteId[0] ;
         A62SGProfesionalProfesionalId = BC00156_A62SGProfesionalProfesionalId[0] ;
         zm1551( -2) ;
      }
      pr_default.close(4);
      onLoadActions1551( ) ;
   }

   public void onLoadActions1551( )
   {
   }

   public void checkExtendedTable1551( )
   {
      nIsDirty_51 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00157 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC00158 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A62SGProfesionalProfesionalId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGProfesional'.", "ForeignKeyNotFound", 1, "SGPROFESIONALPROFESIONALID");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A386ComentarioProfesionalFechaRegistro)) || (( GXutil.resetTime(A386ComentarioProfesionalFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A386ComentarioProfesionalFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Comentario Profesional Fecha Registro fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1551( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1551( )
   {
      /* Using cursor BC00159 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound51 = (short)(1) ;
      }
      else
      {
         RcdFound51 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001510 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1551( 2) ;
         RcdFound51 = (short)(1) ;
         A63ComentarioProfesionalId = BC001510_A63ComentarioProfesionalId[0] ;
         A384ComentarioProfesionalCitaId = BC001510_A384ComentarioProfesionalCitaId[0] ;
         A385ComentarioProfesionalComentario = BC001510_A385ComentarioProfesionalComentario[0] ;
         A386ComentarioProfesionalFechaRegistro = BC001510_A386ComentarioProfesionalFechaRegistro[0] ;
         A61SGPacientePacienteId = BC001510_A61SGPacientePacienteId[0] ;
         A62SGProfesionalProfesionalId = BC001510_A62SGProfesionalProfesionalId[0] ;
         Z63ComentarioProfesionalId = A63ComentarioProfesionalId ;
         sMode51 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1551( ) ;
         if ( AnyError == 1 )
         {
            RcdFound51 = (short)(0) ;
            initializeNonKey1551( ) ;
         }
         Gx_mode = sMode51 ;
      }
      else
      {
         RcdFound51 = (short)(0) ;
         initializeNonKey1551( ) ;
         sMode51 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode51 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1551( ) ;
      if ( RcdFound51 == 0 )
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
      confirm_150( ) ;
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

   public void checkOptimisticConcurrency1551( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001511 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ComentarioProfesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( Z384ComentarioProfesionalCitaId != BC001511_A384ComentarioProfesionalCitaId[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z386ComentarioProfesionalFechaRegistro), GXutil.resetTime(BC001511_A386ComentarioProfesionalFechaRegistro[0])) ) || ( Z61SGPacientePacienteId != BC001511_A61SGPacientePacienteId[0] ) || ( Z62SGProfesionalProfesionalId != BC001511_A62SGProfesionalProfesionalId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ComentarioProfesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1551( )
   {
      beforeValidate1551( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1551( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1551( 0) ;
         checkOptimisticConcurrency1551( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1551( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1551( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001512 */
                  pr_default.execute(10, new Object[] {Short.valueOf(A384ComentarioProfesionalCitaId), A385ComentarioProfesionalComentario, A386ComentarioProfesionalFechaRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A62SGProfesionalProfesionalId)});
                  A63ComentarioProfesionalId = BC001512_A63ComentarioProfesionalId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ComentarioProfesional");
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
            load1551( ) ;
         }
         endLevel1551( ) ;
      }
      closeExtendedTableCursors1551( ) ;
   }

   public void update1551( )
   {
      beforeValidate1551( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1551( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1551( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1551( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1551( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001513 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A384ComentarioProfesionalCitaId), A385ComentarioProfesionalComentario, A386ComentarioProfesionalFechaRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A62SGProfesionalProfesionalId), Integer.valueOf(A63ComentarioProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ComentarioProfesional");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ComentarioProfesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1551( ) ;
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
         endLevel1551( ) ;
      }
      closeExtendedTableCursors1551( ) ;
   }

   public void deferredUpdate1551( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1551( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1551( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1551( ) ;
         afterConfirm1551( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1551( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001514 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ComentarioProfesional");
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
      sMode51 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1551( ) ;
      Gx_mode = sMode51 ;
   }

   public void onDeleteControls1551( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1551( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1551( ) ;
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

   public void scanKeyStart1551( )
   {
      /* Using cursor BC001515 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      RcdFound51 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A63ComentarioProfesionalId = BC001515_A63ComentarioProfesionalId[0] ;
         A384ComentarioProfesionalCitaId = BC001515_A384ComentarioProfesionalCitaId[0] ;
         A385ComentarioProfesionalComentario = BC001515_A385ComentarioProfesionalComentario[0] ;
         A386ComentarioProfesionalFechaRegistro = BC001515_A386ComentarioProfesionalFechaRegistro[0] ;
         A61SGPacientePacienteId = BC001515_A61SGPacientePacienteId[0] ;
         A62SGProfesionalProfesionalId = BC001515_A62SGProfesionalProfesionalId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1551( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound51 = (short)(0) ;
      scanKeyLoad1551( ) ;
   }

   public void scanKeyLoad1551( )
   {
      sMode51 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A63ComentarioProfesionalId = BC001515_A63ComentarioProfesionalId[0] ;
         A384ComentarioProfesionalCitaId = BC001515_A384ComentarioProfesionalCitaId[0] ;
         A385ComentarioProfesionalComentario = BC001515_A385ComentarioProfesionalComentario[0] ;
         A386ComentarioProfesionalFechaRegistro = BC001515_A386ComentarioProfesionalFechaRegistro[0] ;
         A61SGPacientePacienteId = BC001515_A61SGPacientePacienteId[0] ;
         A62SGProfesionalProfesionalId = BC001515_A62SGProfesionalProfesionalId[0] ;
      }
      Gx_mode = sMode51 ;
   }

   public void scanKeyEnd1551( )
   {
      pr_default.close(13);
   }

   public void afterConfirm1551( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1551( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1551( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1551( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1551( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1551( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1551( )
   {
   }

   public void send_integrity_lvl_hashes1551( )
   {
   }

   public void addRow1551( )
   {
      VarsToRow51( bcComentarioProfesional) ;
   }

   public void readRow1551( )
   {
      RowToVars51( bcComentarioProfesional, 1) ;
   }

   public void initializeNonKey1551( )
   {
      A61SGPacientePacienteId = 0 ;
      A62SGProfesionalProfesionalId = 0 ;
      A384ComentarioProfesionalCitaId = (short)(0) ;
      A385ComentarioProfesionalComentario = "" ;
      A386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      Z384ComentarioProfesionalCitaId = (short)(0) ;
      Z386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      Z61SGPacientePacienteId = 0 ;
      Z62SGProfesionalProfesionalId = 0 ;
   }

   public void initAll1551( )
   {
      A63ComentarioProfesionalId = 0 ;
      initializeNonKey1551( ) ;
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

   public void VarsToRow51( com.projectthani.SdtComentarioProfesional obj51 )
   {
      obj51.setgxTv_SdtComentarioProfesional_Mode( Gx_mode );
      obj51.setgxTv_SdtComentarioProfesional_Sgpacientepacienteid( A61SGPacientePacienteId );
      obj51.setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid( A62SGProfesionalProfesionalId );
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid( A384ComentarioProfesionalCitaId );
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario( A385ComentarioProfesionalComentario );
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro( A386ComentarioProfesionalFechaRegistro );
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalid( A63ComentarioProfesionalId );
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z( Z63ComentarioProfesionalId );
      obj51.setgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z( Z61SGPacientePacienteId );
      obj51.setgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z( Z62SGProfesionalProfesionalId );
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z( Z384ComentarioProfesionalCitaId );
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z( Z386ComentarioProfesionalFechaRegistro );
      obj51.setgxTv_SdtComentarioProfesional_Mode( Gx_mode );
   }

   public void KeyVarsToRow51( com.projectthani.SdtComentarioProfesional obj51 )
   {
      obj51.setgxTv_SdtComentarioProfesional_Comentarioprofesionalid( A63ComentarioProfesionalId );
   }

   public void RowToVars51( com.projectthani.SdtComentarioProfesional obj51 ,
                            int forceLoad )
   {
      Gx_mode = obj51.getgxTv_SdtComentarioProfesional_Mode() ;
      A61SGPacientePacienteId = obj51.getgxTv_SdtComentarioProfesional_Sgpacientepacienteid() ;
      A62SGProfesionalProfesionalId = obj51.getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid() ;
      A384ComentarioProfesionalCitaId = obj51.getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid() ;
      A385ComentarioProfesionalComentario = obj51.getgxTv_SdtComentarioProfesional_Comentarioprofesionalcomentario() ;
      A386ComentarioProfesionalFechaRegistro = obj51.getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro() ;
      A63ComentarioProfesionalId = obj51.getgxTv_SdtComentarioProfesional_Comentarioprofesionalid() ;
      Z63ComentarioProfesionalId = obj51.getgxTv_SdtComentarioProfesional_Comentarioprofesionalid_Z() ;
      Z61SGPacientePacienteId = obj51.getgxTv_SdtComentarioProfesional_Sgpacientepacienteid_Z() ;
      Z62SGProfesionalProfesionalId = obj51.getgxTv_SdtComentarioProfesional_Sgprofesionalprofesionalid_Z() ;
      Z384ComentarioProfesionalCitaId = obj51.getgxTv_SdtComentarioProfesional_Comentarioprofesionalcitaid_Z() ;
      Z386ComentarioProfesionalFechaRegistro = obj51.getgxTv_SdtComentarioProfesional_Comentarioprofesionalfecharegistro_Z() ;
      Gx_mode = obj51.getgxTv_SdtComentarioProfesional_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A63ComentarioProfesionalId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1551( ) ;
      scanKeyStart1551( ) ;
      if ( RcdFound51 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z63ComentarioProfesionalId = A63ComentarioProfesionalId ;
      }
      zm1551( -2) ;
      onLoadActions1551( ) ;
      addRow1551( ) ;
      scanKeyEnd1551( ) ;
      if ( RcdFound51 == 0 )
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
      RowToVars51( bcComentarioProfesional, 0) ;
      scanKeyStart1551( ) ;
      if ( RcdFound51 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z63ComentarioProfesionalId = A63ComentarioProfesionalId ;
      }
      zm1551( -2) ;
      onLoadActions1551( ) ;
      addRow1551( ) ;
      scanKeyEnd1551( ) ;
      if ( RcdFound51 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1551( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1551( ) ;
      }
      else
      {
         if ( RcdFound51 == 1 )
         {
            if ( A63ComentarioProfesionalId != Z63ComentarioProfesionalId )
            {
               A63ComentarioProfesionalId = Z63ComentarioProfesionalId ;
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
               update1551( ) ;
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
               if ( A63ComentarioProfesionalId != Z63ComentarioProfesionalId )
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
                     insert1551( ) ;
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
                     insert1551( ) ;
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
      RowToVars51( bcComentarioProfesional, 1) ;
      saveImpl( ) ;
      VarsToRow51( bcComentarioProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars51( bcComentarioProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1551( ) ;
      afterTrn( ) ;
      VarsToRow51( bcComentarioProfesional) ;
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
         com.projectthani.SdtComentarioProfesional auxBC = new com.projectthani.SdtComentarioProfesional( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A63ComentarioProfesionalId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcComentarioProfesional);
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
      RowToVars51( bcComentarioProfesional, 1) ;
      updateImpl( ) ;
      VarsToRow51( bcComentarioProfesional) ;
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
      RowToVars51( bcComentarioProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1551( ) ;
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
      VarsToRow51( bcComentarioProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars51( bcComentarioProfesional, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1551( ) ;
      if ( RcdFound51 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A63ComentarioProfesionalId != Z63ComentarioProfesionalId )
         {
            A63ComentarioProfesionalId = Z63ComentarioProfesionalId ;
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
         if ( A63ComentarioProfesionalId != Z63ComentarioProfesionalId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "comentarioprofesional_bc");
      VarsToRow51( bcComentarioProfesional) ;
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
      Gx_mode = bcComentarioProfesional.getgxTv_SdtComentarioProfesional_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcComentarioProfesional.setgxTv_SdtComentarioProfesional_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtComentarioProfesional sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcComentarioProfesional )
      {
         bcComentarioProfesional = sdt ;
         if ( GXutil.strcmp(bcComentarioProfesional.getgxTv_SdtComentarioProfesional_Mode(), "") == 0 )
         {
            bcComentarioProfesional.setgxTv_SdtComentarioProfesional_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow51( bcComentarioProfesional) ;
         }
         else
         {
            RowToVars51( bcComentarioProfesional, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcComentarioProfesional.getgxTv_SdtComentarioProfesional_Mode(), "") == 0 )
         {
            bcComentarioProfesional.setgxTv_SdtComentarioProfesional_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars51( bcComentarioProfesional, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtComentarioProfesional getComentarioProfesional_BC( )
   {
      return bcComentarioProfesional ;
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
      Z386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      A386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      Z385ComentarioProfesionalComentario = "" ;
      A385ComentarioProfesionalComentario = "" ;
      BC00156_A63ComentarioProfesionalId = new int[1] ;
      BC00156_A384ComentarioProfesionalCitaId = new short[1] ;
      BC00156_A385ComentarioProfesionalComentario = new String[] {""} ;
      BC00156_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00156_A61SGPacientePacienteId = new int[1] ;
      BC00156_A62SGProfesionalProfesionalId = new int[1] ;
      BC00157_A61SGPacientePacienteId = new int[1] ;
      BC00158_A62SGProfesionalProfesionalId = new int[1] ;
      BC00159_A63ComentarioProfesionalId = new int[1] ;
      BC001510_A63ComentarioProfesionalId = new int[1] ;
      BC001510_A384ComentarioProfesionalCitaId = new short[1] ;
      BC001510_A385ComentarioProfesionalComentario = new String[] {""} ;
      BC001510_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001510_A61SGPacientePacienteId = new int[1] ;
      BC001510_A62SGProfesionalProfesionalId = new int[1] ;
      sMode51 = "" ;
      BC001511_A63ComentarioProfesionalId = new int[1] ;
      BC001511_A384ComentarioProfesionalCitaId = new short[1] ;
      BC001511_A385ComentarioProfesionalComentario = new String[] {""} ;
      BC001511_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001511_A61SGPacientePacienteId = new int[1] ;
      BC001511_A62SGProfesionalProfesionalId = new int[1] ;
      BC001512_A63ComentarioProfesionalId = new int[1] ;
      BC001515_A63ComentarioProfesionalId = new int[1] ;
      BC001515_A384ComentarioProfesionalCitaId = new short[1] ;
      BC001515_A385ComentarioProfesionalComentario = new String[] {""} ;
      BC001515_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001515_A61SGPacientePacienteId = new int[1] ;
      BC001515_A62SGProfesionalProfesionalId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.comentarioprofesional_bc__default(),
         new Object[] {
             new Object[] {
            BC00152_A63ComentarioProfesionalId, BC00152_A384ComentarioProfesionalCitaId, BC00152_A385ComentarioProfesionalComentario, BC00152_A386ComentarioProfesionalFechaRegistro, BC00152_A61SGPacientePacienteId, BC00152_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC00153_A63ComentarioProfesionalId, BC00153_A384ComentarioProfesionalCitaId, BC00153_A385ComentarioProfesionalComentario, BC00153_A386ComentarioProfesionalFechaRegistro, BC00153_A61SGPacientePacienteId, BC00153_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC00154_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00155_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC00156_A63ComentarioProfesionalId, BC00156_A384ComentarioProfesionalCitaId, BC00156_A385ComentarioProfesionalComentario, BC00156_A386ComentarioProfesionalFechaRegistro, BC00156_A61SGPacientePacienteId, BC00156_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC00157_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00158_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC00159_A63ComentarioProfesionalId
            }
            , new Object[] {
            BC001510_A63ComentarioProfesionalId, BC001510_A384ComentarioProfesionalCitaId, BC001510_A385ComentarioProfesionalComentario, BC001510_A386ComentarioProfesionalFechaRegistro, BC001510_A61SGPacientePacienteId, BC001510_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC001511_A63ComentarioProfesionalId, BC001511_A384ComentarioProfesionalCitaId, BC001511_A385ComentarioProfesionalComentario, BC001511_A386ComentarioProfesionalFechaRegistro, BC001511_A61SGPacientePacienteId, BC001511_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC001512_A63ComentarioProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001515_A63ComentarioProfesionalId, BC001515_A384ComentarioProfesionalCitaId, BC001515_A385ComentarioProfesionalComentario, BC001515_A386ComentarioProfesionalFechaRegistro, BC001515_A61SGPacientePacienteId, BC001515_A62SGProfesionalProfesionalId
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
   private short Z384ComentarioProfesionalCitaId ;
   private short A384ComentarioProfesionalCitaId ;
   private short RcdFound51 ;
   private short nIsDirty_51 ;
   private int trnEnded ;
   private int Z63ComentarioProfesionalId ;
   private int A63ComentarioProfesionalId ;
   private int GX_JID ;
   private int Z61SGPacientePacienteId ;
   private int A61SGPacientePacienteId ;
   private int Z62SGProfesionalProfesionalId ;
   private int A62SGProfesionalProfesionalId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode51 ;
   private java.util.Date Z386ComentarioProfesionalFechaRegistro ;
   private java.util.Date A386ComentarioProfesionalFechaRegistro ;
   private boolean mustCommit ;
   private String Z385ComentarioProfesionalComentario ;
   private String A385ComentarioProfesionalComentario ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtComentarioProfesional bcComentarioProfesional ;
   private IDataStoreProvider pr_default ;
   private int[] BC00156_A63ComentarioProfesionalId ;
   private short[] BC00156_A384ComentarioProfesionalCitaId ;
   private String[] BC00156_A385ComentarioProfesionalComentario ;
   private java.util.Date[] BC00156_A386ComentarioProfesionalFechaRegistro ;
   private int[] BC00156_A61SGPacientePacienteId ;
   private int[] BC00156_A62SGProfesionalProfesionalId ;
   private int[] BC00157_A61SGPacientePacienteId ;
   private int[] BC00158_A62SGProfesionalProfesionalId ;
   private int[] BC00159_A63ComentarioProfesionalId ;
   private int[] BC001510_A63ComentarioProfesionalId ;
   private short[] BC001510_A384ComentarioProfesionalCitaId ;
   private String[] BC001510_A385ComentarioProfesionalComentario ;
   private java.util.Date[] BC001510_A386ComentarioProfesionalFechaRegistro ;
   private int[] BC001510_A61SGPacientePacienteId ;
   private int[] BC001510_A62SGProfesionalProfesionalId ;
   private int[] BC001511_A63ComentarioProfesionalId ;
   private short[] BC001511_A384ComentarioProfesionalCitaId ;
   private String[] BC001511_A385ComentarioProfesionalComentario ;
   private java.util.Date[] BC001511_A386ComentarioProfesionalFechaRegistro ;
   private int[] BC001511_A61SGPacientePacienteId ;
   private int[] BC001511_A62SGProfesionalProfesionalId ;
   private int[] BC001512_A63ComentarioProfesionalId ;
   private int[] BC001515_A63ComentarioProfesionalId ;
   private short[] BC001515_A384ComentarioProfesionalCitaId ;
   private String[] BC001515_A385ComentarioProfesionalComentario ;
   private java.util.Date[] BC001515_A386ComentarioProfesionalFechaRegistro ;
   private int[] BC001515_A61SGPacientePacienteId ;
   private int[] BC001515_A62SGProfesionalProfesionalId ;
   private int[] BC00152_A63ComentarioProfesionalId ;
   private short[] BC00152_A384ComentarioProfesionalCitaId ;
   private String[] BC00152_A385ComentarioProfesionalComentario ;
   private java.util.Date[] BC00152_A386ComentarioProfesionalFechaRegistro ;
   private int[] BC00152_A61SGPacientePacienteId ;
   private int[] BC00152_A62SGProfesionalProfesionalId ;
   private int[] BC00153_A63ComentarioProfesionalId ;
   private short[] BC00153_A384ComentarioProfesionalCitaId ;
   private String[] BC00153_A385ComentarioProfesionalComentario ;
   private java.util.Date[] BC00153_A386ComentarioProfesionalFechaRegistro ;
   private int[] BC00153_A61SGPacientePacienteId ;
   private int[] BC00153_A62SGProfesionalProfesionalId ;
   private int[] BC00154_A61SGPacientePacienteId ;
   private int[] BC00155_A62SGProfesionalProfesionalId ;
}

final  class comentarioprofesional_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00152", "SELECT [ComentarioProfesionalId], [ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId, [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] WITH (UPDLOCK) WHERE [ComentarioProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00153", "SELECT [ComentarioProfesionalId], [ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId, [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] WHERE [ComentarioProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00154", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00155", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00156", "SELECT TM1.[ComentarioProfesionalId], TM1.[ComentarioProfesionalCitaId], TM1.[ComentarioProfesionalComentario], TM1.[ComentarioProfesionalFechaRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId, TM1.[SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] TM1 WHERE TM1.[ComentarioProfesionalId] = ? ORDER BY TM1.[ComentarioProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00157", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00158", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00159", "SELECT [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE [ComentarioProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001510", "SELECT [ComentarioProfesionalId], [ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId, [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] WHERE [ComentarioProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001511", "SELECT [ComentarioProfesionalId], [ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId, [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] WITH (UPDLOCK) WHERE [ComentarioProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001512", "INSERT INTO [ComentarioProfesional]([ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId], [SGProfesionalProfesionalId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC001513", "UPDATE [ComentarioProfesional] SET [ComentarioProfesionalCitaId]=?, [ComentarioProfesionalComentario]=?, [ComentarioProfesionalFechaRegistro]=?, [SGPacientePacienteId]=?, [SGProfesionalProfesionalId]=?  WHERE [ComentarioProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001514", "DELETE FROM [ComentarioProfesional]  WHERE [ComentarioProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001515", "SELECT TM1.[ComentarioProfesionalId], TM1.[ComentarioProfesionalCitaId], TM1.[ComentarioProfesionalComentario], TM1.[ComentarioProfesionalFechaRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId, TM1.[SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] TM1 WHERE TM1.[ComentarioProfesionalId] = ? ORDER BY TM1.[ComentarioProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
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

