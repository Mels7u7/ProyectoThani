package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sugerenciasmejorasplataforma_bc extends GXWebPanel implements IGxSilentTrn
{
   public sugerenciasmejorasplataforma_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sugerenciasmejorasplataforma_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sugerenciasmejorasplataforma_bc.class ));
   }

   public sugerenciasmejorasplataforma_bc( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1652( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1652( ) ;
      standaloneModal( ) ;
      addRow1652( ) ;
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
            Z397SugerenciasMejorasPlataformaId = A397SugerenciasMejorasPlataformaId ;
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

   public void confirm_160( )
   {
      beforeValidate1652( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1652( ) ;
         }
         else
         {
            checkExtendedTable1652( ) ;
            if ( AnyError == 0 )
            {
               zm1652( 3) ;
            }
            closeExtendedTableCursors1652( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm1652( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z403SugerenciasMejorasPlataformaCitaId = A403SugerenciasMejorasPlataformaCitaId ;
         Z399SugerenciasMejorasPlataformaFecRegistro = A399SugerenciasMejorasPlataformaFecRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z397SugerenciasMejorasPlataformaId = A397SugerenciasMejorasPlataformaId ;
         Z403SugerenciasMejorasPlataformaCitaId = A403SugerenciasMejorasPlataformaCitaId ;
         Z400SugerenciasMejorasPlataformaOp = A400SugerenciasMejorasPlataformaOp ;
         Z402SugerenciasMejorasPlataformaMej = A402SugerenciasMejorasPlataformaMej ;
         Z399SugerenciasMejorasPlataformaFecRegistro = A399SugerenciasMejorasPlataformaFecRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1652( )
   {
      /* Using cursor BC00165 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A403SugerenciasMejorasPlataformaCitaId = BC00165_A403SugerenciasMejorasPlataformaCitaId[0] ;
         A400SugerenciasMejorasPlataformaOp = BC00165_A400SugerenciasMejorasPlataformaOp[0] ;
         A402SugerenciasMejorasPlataformaMej = BC00165_A402SugerenciasMejorasPlataformaMej[0] ;
         A399SugerenciasMejorasPlataformaFecRegistro = BC00165_A399SugerenciasMejorasPlataformaFecRegistro[0] ;
         A61SGPacientePacienteId = BC00165_A61SGPacientePacienteId[0] ;
         zm1652( -2) ;
      }
      pr_default.close(3);
      onLoadActions1652( ) ;
   }

   public void onLoadActions1652( )
   {
   }

   public void checkExtendedTable1652( )
   {
      nIsDirty_52 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00166 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A399SugerenciasMejorasPlataformaFecRegistro)) || (( GXutil.resetTime(A399SugerenciasMejorasPlataformaFecRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A399SugerenciasMejorasPlataformaFecRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sugerencias Mejoras Plataforma Fec Registro fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1652( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey1652( )
   {
      /* Using cursor BC00167 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound52 = (short)(1) ;
      }
      else
      {
         RcdFound52 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00168 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm1652( 2) ;
         RcdFound52 = (short)(1) ;
         A397SugerenciasMejorasPlataformaId = BC00168_A397SugerenciasMejorasPlataformaId[0] ;
         A403SugerenciasMejorasPlataformaCitaId = BC00168_A403SugerenciasMejorasPlataformaCitaId[0] ;
         A400SugerenciasMejorasPlataformaOp = BC00168_A400SugerenciasMejorasPlataformaOp[0] ;
         A402SugerenciasMejorasPlataformaMej = BC00168_A402SugerenciasMejorasPlataformaMej[0] ;
         A399SugerenciasMejorasPlataformaFecRegistro = BC00168_A399SugerenciasMejorasPlataformaFecRegistro[0] ;
         A61SGPacientePacienteId = BC00168_A61SGPacientePacienteId[0] ;
         Z397SugerenciasMejorasPlataformaId = A397SugerenciasMejorasPlataformaId ;
         sMode52 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1652( ) ;
         if ( AnyError == 1 )
         {
            RcdFound52 = (short)(0) ;
            initializeNonKey1652( ) ;
         }
         Gx_mode = sMode52 ;
      }
      else
      {
         RcdFound52 = (short)(0) ;
         initializeNonKey1652( ) ;
         sMode52 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode52 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey1652( ) ;
      if ( RcdFound52 == 0 )
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
      confirm_160( ) ;
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

   public void checkOptimisticConcurrency1652( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00169 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SugerenciasMejorasPlataforma"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( Z403SugerenciasMejorasPlataformaCitaId != BC00169_A403SugerenciasMejorasPlataformaCitaId[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z399SugerenciasMejorasPlataformaFecRegistro), GXutil.resetTime(BC00169_A399SugerenciasMejorasPlataformaFecRegistro[0])) ) || ( Z61SGPacientePacienteId != BC00169_A61SGPacientePacienteId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SugerenciasMejorasPlataforma"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1652( )
   {
      beforeValidate1652( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1652( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1652( 0) ;
         checkOptimisticConcurrency1652( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1652( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1652( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001610 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A403SugerenciasMejorasPlataformaCitaId), A400SugerenciasMejorasPlataformaOp, A402SugerenciasMejorasPlataformaMej, A399SugerenciasMejorasPlataformaFecRegistro, Integer.valueOf(A61SGPacientePacienteId)});
                  A397SugerenciasMejorasPlataformaId = BC001610_A397SugerenciasMejorasPlataformaId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SugerenciasMejorasPlataforma");
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
            load1652( ) ;
         }
         endLevel1652( ) ;
      }
      closeExtendedTableCursors1652( ) ;
   }

   public void update1652( )
   {
      beforeValidate1652( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1652( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1652( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1652( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1652( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001611 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A403SugerenciasMejorasPlataformaCitaId), A400SugerenciasMejorasPlataformaOp, A402SugerenciasMejorasPlataformaMej, A399SugerenciasMejorasPlataformaFecRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SugerenciasMejorasPlataforma");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SugerenciasMejorasPlataforma"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1652( ) ;
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
         endLevel1652( ) ;
      }
      closeExtendedTableCursors1652( ) ;
   }

   public void deferredUpdate1652( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1652( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1652( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1652( ) ;
         afterConfirm1652( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1652( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001612 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SugerenciasMejorasPlataforma");
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
      sMode52 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1652( ) ;
      Gx_mode = sMode52 ;
   }

   public void onDeleteControls1652( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1652( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1652( ) ;
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

   public void scanKeyStart1652( )
   {
      /* Using cursor BC001613 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      RcdFound52 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A397SugerenciasMejorasPlataformaId = BC001613_A397SugerenciasMejorasPlataformaId[0] ;
         A403SugerenciasMejorasPlataformaCitaId = BC001613_A403SugerenciasMejorasPlataformaCitaId[0] ;
         A400SugerenciasMejorasPlataformaOp = BC001613_A400SugerenciasMejorasPlataformaOp[0] ;
         A402SugerenciasMejorasPlataformaMej = BC001613_A402SugerenciasMejorasPlataformaMej[0] ;
         A399SugerenciasMejorasPlataformaFecRegistro = BC001613_A399SugerenciasMejorasPlataformaFecRegistro[0] ;
         A61SGPacientePacienteId = BC001613_A61SGPacientePacienteId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1652( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound52 = (short)(0) ;
      scanKeyLoad1652( ) ;
   }

   public void scanKeyLoad1652( )
   {
      sMode52 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A397SugerenciasMejorasPlataformaId = BC001613_A397SugerenciasMejorasPlataformaId[0] ;
         A403SugerenciasMejorasPlataformaCitaId = BC001613_A403SugerenciasMejorasPlataformaCitaId[0] ;
         A400SugerenciasMejorasPlataformaOp = BC001613_A400SugerenciasMejorasPlataformaOp[0] ;
         A402SugerenciasMejorasPlataformaMej = BC001613_A402SugerenciasMejorasPlataformaMej[0] ;
         A399SugerenciasMejorasPlataformaFecRegistro = BC001613_A399SugerenciasMejorasPlataformaFecRegistro[0] ;
         A61SGPacientePacienteId = BC001613_A61SGPacientePacienteId[0] ;
      }
      Gx_mode = sMode52 ;
   }

   public void scanKeyEnd1652( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1652( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1652( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1652( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1652( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1652( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1652( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1652( )
   {
   }

   public void send_integrity_lvl_hashes1652( )
   {
   }

   public void addRow1652( )
   {
      VarsToRow52( bcSugerenciasMejorasPlataforma) ;
   }

   public void readRow1652( )
   {
      RowToVars52( bcSugerenciasMejorasPlataforma, 1) ;
   }

   public void initializeNonKey1652( )
   {
      A61SGPacientePacienteId = 0 ;
      A403SugerenciasMejorasPlataformaCitaId = (short)(0) ;
      A400SugerenciasMejorasPlataformaOp = "" ;
      A402SugerenciasMejorasPlataformaMej = "" ;
      A399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      Z403SugerenciasMejorasPlataformaCitaId = (short)(0) ;
      Z399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      Z61SGPacientePacienteId = 0 ;
   }

   public void initAll1652( )
   {
      A397SugerenciasMejorasPlataformaId = 0 ;
      initializeNonKey1652( ) ;
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

   public void VarsToRow52( com.projectthani.SdtSugerenciasMejorasPlataforma obj52 )
   {
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Mode( Gx_mode );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid( A61SGPacientePacienteId );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid( A403SugerenciasMejorasPlataformaCitaId );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop( A400SugerenciasMejorasPlataformaOp );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej( A402SugerenciasMejorasPlataformaMej );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro( A399SugerenciasMejorasPlataformaFecRegistro );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid( A397SugerenciasMejorasPlataformaId );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z( Z397SugerenciasMejorasPlataformaId );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z( Z61SGPacientePacienteId );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z( Z403SugerenciasMejorasPlataformaCitaId );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z( Z399SugerenciasMejorasPlataformaFecRegistro );
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Mode( Gx_mode );
   }

   public void KeyVarsToRow52( com.projectthani.SdtSugerenciasMejorasPlataforma obj52 )
   {
      obj52.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid( A397SugerenciasMejorasPlataformaId );
   }

   public void RowToVars52( com.projectthani.SdtSugerenciasMejorasPlataforma obj52 ,
                            int forceLoad )
   {
      Gx_mode = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Mode() ;
      A61SGPacientePacienteId = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid() ;
      A403SugerenciasMejorasPlataformaCitaId = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid() ;
      A400SugerenciasMejorasPlataformaOp = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop() ;
      A402SugerenciasMejorasPlataformaMej = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej() ;
      A399SugerenciasMejorasPlataformaFecRegistro = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro() ;
      A397SugerenciasMejorasPlataformaId = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid() ;
      Z397SugerenciasMejorasPlataformaId = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaid_Z() ;
      Z61SGPacientePacienteId = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid_Z() ;
      Z403SugerenciasMejorasPlataformaCitaId = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid_Z() ;
      Z399SugerenciasMejorasPlataformaFecRegistro = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro_Z() ;
      Gx_mode = obj52.getgxTv_SdtSugerenciasMejorasPlataforma_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A397SugerenciasMejorasPlataformaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1652( ) ;
      scanKeyStart1652( ) ;
      if ( RcdFound52 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z397SugerenciasMejorasPlataformaId = A397SugerenciasMejorasPlataformaId ;
      }
      zm1652( -2) ;
      onLoadActions1652( ) ;
      addRow1652( ) ;
      scanKeyEnd1652( ) ;
      if ( RcdFound52 == 0 )
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
      RowToVars52( bcSugerenciasMejorasPlataforma, 0) ;
      scanKeyStart1652( ) ;
      if ( RcdFound52 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z397SugerenciasMejorasPlataformaId = A397SugerenciasMejorasPlataformaId ;
      }
      zm1652( -2) ;
      onLoadActions1652( ) ;
      addRow1652( ) ;
      scanKeyEnd1652( ) ;
      if ( RcdFound52 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1652( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1652( ) ;
      }
      else
      {
         if ( RcdFound52 == 1 )
         {
            if ( A397SugerenciasMejorasPlataformaId != Z397SugerenciasMejorasPlataformaId )
            {
               A397SugerenciasMejorasPlataformaId = Z397SugerenciasMejorasPlataformaId ;
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
               update1652( ) ;
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
               if ( A397SugerenciasMejorasPlataformaId != Z397SugerenciasMejorasPlataformaId )
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
                     insert1652( ) ;
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
                     insert1652( ) ;
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
      RowToVars52( bcSugerenciasMejorasPlataforma, 1) ;
      saveImpl( ) ;
      VarsToRow52( bcSugerenciasMejorasPlataforma) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars52( bcSugerenciasMejorasPlataforma, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1652( ) ;
      afterTrn( ) ;
      VarsToRow52( bcSugerenciasMejorasPlataforma) ;
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
         com.projectthani.SdtSugerenciasMejorasPlataforma auxBC = new com.projectthani.SdtSugerenciasMejorasPlataforma( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A397SugerenciasMejorasPlataformaId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcSugerenciasMejorasPlataforma);
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
      RowToVars52( bcSugerenciasMejorasPlataforma, 1) ;
      updateImpl( ) ;
      VarsToRow52( bcSugerenciasMejorasPlataforma) ;
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
      RowToVars52( bcSugerenciasMejorasPlataforma, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1652( ) ;
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
      VarsToRow52( bcSugerenciasMejorasPlataforma) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars52( bcSugerenciasMejorasPlataforma, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1652( ) ;
      if ( RcdFound52 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A397SugerenciasMejorasPlataformaId != Z397SugerenciasMejorasPlataformaId )
         {
            A397SugerenciasMejorasPlataformaId = Z397SugerenciasMejorasPlataformaId ;
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
         if ( A397SugerenciasMejorasPlataformaId != Z397SugerenciasMejorasPlataformaId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "sugerenciasmejorasplataforma_bc");
      VarsToRow52( bcSugerenciasMejorasPlataforma) ;
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
      Gx_mode = bcSugerenciasMejorasPlataforma.getgxTv_SdtSugerenciasMejorasPlataforma_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcSugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtSugerenciasMejorasPlataforma sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcSugerenciasMejorasPlataforma )
      {
         bcSugerenciasMejorasPlataforma = sdt ;
         if ( GXutil.strcmp(bcSugerenciasMejorasPlataforma.getgxTv_SdtSugerenciasMejorasPlataforma_Mode(), "") == 0 )
         {
            bcSugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow52( bcSugerenciasMejorasPlataforma) ;
         }
         else
         {
            RowToVars52( bcSugerenciasMejorasPlataforma, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcSugerenciasMejorasPlataforma.getgxTv_SdtSugerenciasMejorasPlataforma_Mode(), "") == 0 )
         {
            bcSugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars52( bcSugerenciasMejorasPlataforma, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSugerenciasMejorasPlataforma getSugerenciasMejorasPlataforma_BC( )
   {
      return bcSugerenciasMejorasPlataforma ;
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
      Z399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      A399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      Z400SugerenciasMejorasPlataformaOp = "" ;
      A400SugerenciasMejorasPlataformaOp = "" ;
      Z402SugerenciasMejorasPlataformaMej = "" ;
      A402SugerenciasMejorasPlataformaMej = "" ;
      BC00165_A397SugerenciasMejorasPlataformaId = new int[1] ;
      BC00165_A403SugerenciasMejorasPlataformaCitaId = new short[1] ;
      BC00165_A400SugerenciasMejorasPlataformaOp = new String[] {""} ;
      BC00165_A402SugerenciasMejorasPlataformaMej = new String[] {""} ;
      BC00165_A399SugerenciasMejorasPlataformaFecRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00165_A61SGPacientePacienteId = new int[1] ;
      BC00166_A61SGPacientePacienteId = new int[1] ;
      BC00167_A397SugerenciasMejorasPlataformaId = new int[1] ;
      BC00168_A397SugerenciasMejorasPlataformaId = new int[1] ;
      BC00168_A403SugerenciasMejorasPlataformaCitaId = new short[1] ;
      BC00168_A400SugerenciasMejorasPlataformaOp = new String[] {""} ;
      BC00168_A402SugerenciasMejorasPlataformaMej = new String[] {""} ;
      BC00168_A399SugerenciasMejorasPlataformaFecRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00168_A61SGPacientePacienteId = new int[1] ;
      sMode52 = "" ;
      BC00169_A397SugerenciasMejorasPlataformaId = new int[1] ;
      BC00169_A403SugerenciasMejorasPlataformaCitaId = new short[1] ;
      BC00169_A400SugerenciasMejorasPlataformaOp = new String[] {""} ;
      BC00169_A402SugerenciasMejorasPlataformaMej = new String[] {""} ;
      BC00169_A399SugerenciasMejorasPlataformaFecRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00169_A61SGPacientePacienteId = new int[1] ;
      BC001610_A397SugerenciasMejorasPlataformaId = new int[1] ;
      BC001613_A397SugerenciasMejorasPlataformaId = new int[1] ;
      BC001613_A403SugerenciasMejorasPlataformaCitaId = new short[1] ;
      BC001613_A400SugerenciasMejorasPlataformaOp = new String[] {""} ;
      BC001613_A402SugerenciasMejorasPlataformaMej = new String[] {""} ;
      BC001613_A399SugerenciasMejorasPlataformaFecRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001613_A61SGPacientePacienteId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sugerenciasmejorasplataforma_bc__default(),
         new Object[] {
             new Object[] {
            BC00162_A397SugerenciasMejorasPlataformaId, BC00162_A403SugerenciasMejorasPlataformaCitaId, BC00162_A400SugerenciasMejorasPlataformaOp, BC00162_A402SugerenciasMejorasPlataformaMej, BC00162_A399SugerenciasMejorasPlataformaFecRegistro, BC00162_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00163_A397SugerenciasMejorasPlataformaId, BC00163_A403SugerenciasMejorasPlataformaCitaId, BC00163_A400SugerenciasMejorasPlataformaOp, BC00163_A402SugerenciasMejorasPlataformaMej, BC00163_A399SugerenciasMejorasPlataformaFecRegistro, BC00163_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00164_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00165_A397SugerenciasMejorasPlataformaId, BC00165_A403SugerenciasMejorasPlataformaCitaId, BC00165_A400SugerenciasMejorasPlataformaOp, BC00165_A402SugerenciasMejorasPlataformaMej, BC00165_A399SugerenciasMejorasPlataformaFecRegistro, BC00165_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00166_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00167_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            BC00168_A397SugerenciasMejorasPlataformaId, BC00168_A403SugerenciasMejorasPlataformaCitaId, BC00168_A400SugerenciasMejorasPlataformaOp, BC00168_A402SugerenciasMejorasPlataformaMej, BC00168_A399SugerenciasMejorasPlataformaFecRegistro, BC00168_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00169_A397SugerenciasMejorasPlataformaId, BC00169_A403SugerenciasMejorasPlataformaCitaId, BC00169_A400SugerenciasMejorasPlataformaOp, BC00169_A402SugerenciasMejorasPlataformaMej, BC00169_A399SugerenciasMejorasPlataformaFecRegistro, BC00169_A61SGPacientePacienteId
            }
            , new Object[] {
            BC001610_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001613_A397SugerenciasMejorasPlataformaId, BC001613_A403SugerenciasMejorasPlataformaCitaId, BC001613_A400SugerenciasMejorasPlataformaOp, BC001613_A402SugerenciasMejorasPlataformaMej, BC001613_A399SugerenciasMejorasPlataformaFecRegistro, BC001613_A61SGPacientePacienteId
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
   private short Z403SugerenciasMejorasPlataformaCitaId ;
   private short A403SugerenciasMejorasPlataformaCitaId ;
   private short RcdFound52 ;
   private short nIsDirty_52 ;
   private int trnEnded ;
   private int Z397SugerenciasMejorasPlataformaId ;
   private int A397SugerenciasMejorasPlataformaId ;
   private int GX_JID ;
   private int Z61SGPacientePacienteId ;
   private int A61SGPacientePacienteId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode52 ;
   private java.util.Date Z399SugerenciasMejorasPlataformaFecRegistro ;
   private java.util.Date A399SugerenciasMejorasPlataformaFecRegistro ;
   private boolean mustCommit ;
   private String Z400SugerenciasMejorasPlataformaOp ;
   private String A400SugerenciasMejorasPlataformaOp ;
   private String Z402SugerenciasMejorasPlataformaMej ;
   private String A402SugerenciasMejorasPlataformaMej ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtSugerenciasMejorasPlataforma bcSugerenciasMejorasPlataforma ;
   private IDataStoreProvider pr_default ;
   private int[] BC00165_A397SugerenciasMejorasPlataformaId ;
   private short[] BC00165_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] BC00165_A400SugerenciasMejorasPlataformaOp ;
   private String[] BC00165_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] BC00165_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] BC00165_A61SGPacientePacienteId ;
   private int[] BC00166_A61SGPacientePacienteId ;
   private int[] BC00167_A397SugerenciasMejorasPlataformaId ;
   private int[] BC00168_A397SugerenciasMejorasPlataformaId ;
   private short[] BC00168_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] BC00168_A400SugerenciasMejorasPlataformaOp ;
   private String[] BC00168_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] BC00168_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] BC00168_A61SGPacientePacienteId ;
   private int[] BC00169_A397SugerenciasMejorasPlataformaId ;
   private short[] BC00169_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] BC00169_A400SugerenciasMejorasPlataformaOp ;
   private String[] BC00169_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] BC00169_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] BC00169_A61SGPacientePacienteId ;
   private int[] BC001610_A397SugerenciasMejorasPlataformaId ;
   private int[] BC001613_A397SugerenciasMejorasPlataformaId ;
   private short[] BC001613_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] BC001613_A400SugerenciasMejorasPlataformaOp ;
   private String[] BC001613_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] BC001613_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] BC001613_A61SGPacientePacienteId ;
   private int[] BC00162_A397SugerenciasMejorasPlataformaId ;
   private short[] BC00162_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] BC00162_A400SugerenciasMejorasPlataformaOp ;
   private String[] BC00162_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] BC00162_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] BC00162_A61SGPacientePacienteId ;
   private int[] BC00163_A397SugerenciasMejorasPlataformaId ;
   private short[] BC00163_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] BC00163_A400SugerenciasMejorasPlataformaOp ;
   private String[] BC00163_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] BC00163_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] BC00163_A61SGPacientePacienteId ;
   private int[] BC00164_A61SGPacientePacienteId ;
}

final  class sugerenciasmejorasplataforma_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00162", "SELECT [SugerenciasMejorasPlataformaId], [SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] WITH (UPDLOCK) WHERE [SugerenciasMejorasPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00163", "SELECT [SugerenciasMejorasPlataformaId], [SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] WHERE [SugerenciasMejorasPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00164", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00165", "SELECT TM1.[SugerenciasMejorasPlataformaId], TM1.[SugerenciasMejorasPlataformaCitaId], TM1.[SugerenciasMejorasPlataformaOp], TM1.[SugerenciasMejorasPlataformaMej], TM1.[SugerenciasMejorasPlataformaFecRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] TM1 WHERE TM1.[SugerenciasMejorasPlataformaId] = ? ORDER BY TM1.[SugerenciasMejorasPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00166", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00167", "SELECT [SugerenciasMejorasPlataformaId] FROM [SugerenciasMejorasPlataforma] WHERE [SugerenciasMejorasPlataformaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00168", "SELECT [SugerenciasMejorasPlataformaId], [SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] WHERE [SugerenciasMejorasPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00169", "SELECT [SugerenciasMejorasPlataformaId], [SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] WITH (UPDLOCK) WHERE [SugerenciasMejorasPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001610", "INSERT INTO [SugerenciasMejorasPlataforma]([SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC001611", "UPDATE [SugerenciasMejorasPlataforma] SET [SugerenciasMejorasPlataformaCitaId]=?, [SugerenciasMejorasPlataformaOp]=?, [SugerenciasMejorasPlataformaMej]=?, [SugerenciasMejorasPlataformaFecRegistro]=?, [SGPacientePacienteId]=?  WHERE [SugerenciasMejorasPlataformaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001612", "DELETE FROM [SugerenciasMejorasPlataforma]  WHERE [SugerenciasMejorasPlataformaId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001613", "SELECT TM1.[SugerenciasMejorasPlataformaId], TM1.[SugerenciasMejorasPlataformaCitaId], TM1.[SugerenciasMejorasPlataformaOp], TM1.[SugerenciasMejorasPlataformaMej], TM1.[SugerenciasMejorasPlataformaFecRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] TM1 WHERE TM1.[SugerenciasMejorasPlataformaId] = ? ORDER BY TM1.[SugerenciasMejorasPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
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

