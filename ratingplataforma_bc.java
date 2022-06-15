package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ratingplataforma_bc extends GXWebPanel implements IGxSilentTrn
{
   public ratingplataforma_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ratingplataforma_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ratingplataforma_bc.class ));
   }

   public ratingplataforma_bc( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1753( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1753( ) ;
      standaloneModal( ) ;
      addRow1753( ) ;
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
            Z398RatingPlataformaId = A398RatingPlataformaId ;
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

   public void confirm_170( )
   {
      beforeValidate1753( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1753( ) ;
         }
         else
         {
            checkExtendedTable1753( ) ;
            if ( AnyError == 0 )
            {
               zm1753( 3) ;
            }
            closeExtendedTableCursors1753( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm1753( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z405RatingPlataformaCitaId = A405RatingPlataformaCitaId ;
         Z401RatingPlataformaRating = A401RatingPlataformaRating ;
         Z406RatingPlataformaFechaRegistro = A406RatingPlataformaFechaRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z398RatingPlataformaId = A398RatingPlataformaId ;
         Z405RatingPlataformaCitaId = A405RatingPlataformaCitaId ;
         Z401RatingPlataformaRating = A401RatingPlataformaRating ;
         Z406RatingPlataformaFechaRegistro = A406RatingPlataformaFechaRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1753( )
   {
      /* Using cursor BC00175 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A405RatingPlataformaCitaId = BC00175_A405RatingPlataformaCitaId[0] ;
         A401RatingPlataformaRating = BC00175_A401RatingPlataformaRating[0] ;
         A406RatingPlataformaFechaRegistro = BC00175_A406RatingPlataformaFechaRegistro[0] ;
         A61SGPacientePacienteId = BC00175_A61SGPacientePacienteId[0] ;
         zm1753( -2) ;
      }
      pr_default.close(3);
      onLoadActions1753( ) ;
   }

   public void onLoadActions1753( )
   {
   }

   public void checkExtendedTable1753( )
   {
      nIsDirty_53 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00176 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A406RatingPlataformaFechaRegistro)) || (( GXutil.resetTime(A406RatingPlataformaFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A406RatingPlataformaFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Rating Plataforma Fecha Registro fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1753( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey1753( )
   {
      /* Using cursor BC00177 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound53 = (short)(1) ;
      }
      else
      {
         RcdFound53 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00178 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm1753( 2) ;
         RcdFound53 = (short)(1) ;
         A398RatingPlataformaId = BC00178_A398RatingPlataformaId[0] ;
         A405RatingPlataformaCitaId = BC00178_A405RatingPlataformaCitaId[0] ;
         A401RatingPlataformaRating = BC00178_A401RatingPlataformaRating[0] ;
         A406RatingPlataformaFechaRegistro = BC00178_A406RatingPlataformaFechaRegistro[0] ;
         A61SGPacientePacienteId = BC00178_A61SGPacientePacienteId[0] ;
         Z398RatingPlataformaId = A398RatingPlataformaId ;
         sMode53 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1753( ) ;
         if ( AnyError == 1 )
         {
            RcdFound53 = (short)(0) ;
            initializeNonKey1753( ) ;
         }
         Gx_mode = sMode53 ;
      }
      else
      {
         RcdFound53 = (short)(0) ;
         initializeNonKey1753( ) ;
         sMode53 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode53 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey1753( ) ;
      if ( RcdFound53 == 0 )
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
      confirm_170( ) ;
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

   public void checkOptimisticConcurrency1753( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00179 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingPlataforma"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( Z405RatingPlataformaCitaId != BC00179_A405RatingPlataformaCitaId[0] ) || ( Z401RatingPlataformaRating != BC00179_A401RatingPlataformaRating[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z406RatingPlataformaFechaRegistro), GXutil.resetTime(BC00179_A406RatingPlataformaFechaRegistro[0])) ) || ( Z61SGPacientePacienteId != BC00179_A61SGPacientePacienteId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"RatingPlataforma"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1753( )
   {
      beforeValidate1753( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1753( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1753( 0) ;
         checkOptimisticConcurrency1753( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1753( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1753( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001710 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A405RatingPlataformaCitaId), Short.valueOf(A401RatingPlataformaRating), A406RatingPlataformaFechaRegistro, Integer.valueOf(A61SGPacientePacienteId)});
                  A398RatingPlataformaId = BC001710_A398RatingPlataformaId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingPlataforma");
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
            load1753( ) ;
         }
         endLevel1753( ) ;
      }
      closeExtendedTableCursors1753( ) ;
   }

   public void update1753( )
   {
      beforeValidate1753( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1753( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1753( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1753( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1753( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001711 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A405RatingPlataformaCitaId), Short.valueOf(A401RatingPlataformaRating), A406RatingPlataformaFechaRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A398RatingPlataformaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingPlataforma");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingPlataforma"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1753( ) ;
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
         endLevel1753( ) ;
      }
      closeExtendedTableCursors1753( ) ;
   }

   public void deferredUpdate1753( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1753( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1753( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1753( ) ;
         afterConfirm1753( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1753( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001712 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingPlataforma");
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
      sMode53 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1753( ) ;
      Gx_mode = sMode53 ;
   }

   public void onDeleteControls1753( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1753( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1753( ) ;
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

   public void scanKeyStart1753( )
   {
      /* Using cursor BC001713 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      RcdFound53 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A398RatingPlataformaId = BC001713_A398RatingPlataformaId[0] ;
         A405RatingPlataformaCitaId = BC001713_A405RatingPlataformaCitaId[0] ;
         A401RatingPlataformaRating = BC001713_A401RatingPlataformaRating[0] ;
         A406RatingPlataformaFechaRegistro = BC001713_A406RatingPlataformaFechaRegistro[0] ;
         A61SGPacientePacienteId = BC001713_A61SGPacientePacienteId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1753( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound53 = (short)(0) ;
      scanKeyLoad1753( ) ;
   }

   public void scanKeyLoad1753( )
   {
      sMode53 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A398RatingPlataformaId = BC001713_A398RatingPlataformaId[0] ;
         A405RatingPlataformaCitaId = BC001713_A405RatingPlataformaCitaId[0] ;
         A401RatingPlataformaRating = BC001713_A401RatingPlataformaRating[0] ;
         A406RatingPlataformaFechaRegistro = BC001713_A406RatingPlataformaFechaRegistro[0] ;
         A61SGPacientePacienteId = BC001713_A61SGPacientePacienteId[0] ;
      }
      Gx_mode = sMode53 ;
   }

   public void scanKeyEnd1753( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1753( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1753( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1753( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1753( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1753( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1753( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1753( )
   {
   }

   public void send_integrity_lvl_hashes1753( )
   {
   }

   public void addRow1753( )
   {
      VarsToRow53( bcRatingPlataforma) ;
   }

   public void readRow1753( )
   {
      RowToVars53( bcRatingPlataforma, 1) ;
   }

   public void initializeNonKey1753( )
   {
      A61SGPacientePacienteId = 0 ;
      A405RatingPlataformaCitaId = (short)(0) ;
      A401RatingPlataformaRating = (short)(0) ;
      A406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      Z405RatingPlataformaCitaId = (short)(0) ;
      Z401RatingPlataformaRating = (short)(0) ;
      Z406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      Z61SGPacientePacienteId = 0 ;
   }

   public void initAll1753( )
   {
      A398RatingPlataformaId = 0 ;
      initializeNonKey1753( ) ;
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

   public void VarsToRow53( com.projectthani.SdtRatingPlataforma obj53 )
   {
      obj53.setgxTv_SdtRatingPlataforma_Mode( Gx_mode );
      obj53.setgxTv_SdtRatingPlataforma_Sgpacientepacienteid( A61SGPacientePacienteId );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformacitaid( A405RatingPlataformaCitaId );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformarating( A401RatingPlataformaRating );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro( A406RatingPlataformaFechaRegistro );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformaid( A398RatingPlataformaId );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformaid_Z( Z398RatingPlataformaId );
      obj53.setgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z( Z61SGPacientePacienteId );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z( Z405RatingPlataformaCitaId );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformarating_Z( Z401RatingPlataformaRating );
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z( Z406RatingPlataformaFechaRegistro );
      obj53.setgxTv_SdtRatingPlataforma_Mode( Gx_mode );
   }

   public void KeyVarsToRow53( com.projectthani.SdtRatingPlataforma obj53 )
   {
      obj53.setgxTv_SdtRatingPlataforma_Ratingplataformaid( A398RatingPlataformaId );
   }

   public void RowToVars53( com.projectthani.SdtRatingPlataforma obj53 ,
                            int forceLoad )
   {
      Gx_mode = obj53.getgxTv_SdtRatingPlataforma_Mode() ;
      A61SGPacientePacienteId = obj53.getgxTv_SdtRatingPlataforma_Sgpacientepacienteid() ;
      A405RatingPlataformaCitaId = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformacitaid() ;
      A401RatingPlataformaRating = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformarating() ;
      A406RatingPlataformaFechaRegistro = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro() ;
      A398RatingPlataformaId = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformaid() ;
      Z398RatingPlataformaId = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformaid_Z() ;
      Z61SGPacientePacienteId = obj53.getgxTv_SdtRatingPlataforma_Sgpacientepacienteid_Z() ;
      Z405RatingPlataformaCitaId = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformacitaid_Z() ;
      Z401RatingPlataformaRating = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformarating_Z() ;
      Z406RatingPlataformaFechaRegistro = obj53.getgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro_Z() ;
      Gx_mode = obj53.getgxTv_SdtRatingPlataforma_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A398RatingPlataformaId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1753( ) ;
      scanKeyStart1753( ) ;
      if ( RcdFound53 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z398RatingPlataformaId = A398RatingPlataformaId ;
      }
      zm1753( -2) ;
      onLoadActions1753( ) ;
      addRow1753( ) ;
      scanKeyEnd1753( ) ;
      if ( RcdFound53 == 0 )
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
      RowToVars53( bcRatingPlataforma, 0) ;
      scanKeyStart1753( ) ;
      if ( RcdFound53 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z398RatingPlataformaId = A398RatingPlataformaId ;
      }
      zm1753( -2) ;
      onLoadActions1753( ) ;
      addRow1753( ) ;
      scanKeyEnd1753( ) ;
      if ( RcdFound53 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1753( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1753( ) ;
      }
      else
      {
         if ( RcdFound53 == 1 )
         {
            if ( A398RatingPlataformaId != Z398RatingPlataformaId )
            {
               A398RatingPlataformaId = Z398RatingPlataformaId ;
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
               update1753( ) ;
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
               if ( A398RatingPlataformaId != Z398RatingPlataformaId )
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
                     insert1753( ) ;
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
                     insert1753( ) ;
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
      RowToVars53( bcRatingPlataforma, 1) ;
      saveImpl( ) ;
      VarsToRow53( bcRatingPlataforma) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars53( bcRatingPlataforma, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1753( ) ;
      afterTrn( ) ;
      VarsToRow53( bcRatingPlataforma) ;
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
         com.projectthani.SdtRatingPlataforma auxBC = new com.projectthani.SdtRatingPlataforma( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A398RatingPlataformaId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcRatingPlataforma);
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
      RowToVars53( bcRatingPlataforma, 1) ;
      updateImpl( ) ;
      VarsToRow53( bcRatingPlataforma) ;
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
      RowToVars53( bcRatingPlataforma, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1753( ) ;
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
      VarsToRow53( bcRatingPlataforma) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars53( bcRatingPlataforma, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1753( ) ;
      if ( RcdFound53 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A398RatingPlataformaId != Z398RatingPlataformaId )
         {
            A398RatingPlataformaId = Z398RatingPlataformaId ;
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
         if ( A398RatingPlataformaId != Z398RatingPlataformaId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "ratingplataforma_bc");
      VarsToRow53( bcRatingPlataforma) ;
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
      Gx_mode = bcRatingPlataforma.getgxTv_SdtRatingPlataforma_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcRatingPlataforma.setgxTv_SdtRatingPlataforma_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtRatingPlataforma sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcRatingPlataforma )
      {
         bcRatingPlataforma = sdt ;
         if ( GXutil.strcmp(bcRatingPlataforma.getgxTv_SdtRatingPlataforma_Mode(), "") == 0 )
         {
            bcRatingPlataforma.setgxTv_SdtRatingPlataforma_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow53( bcRatingPlataforma) ;
         }
         else
         {
            RowToVars53( bcRatingPlataforma, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcRatingPlataforma.getgxTv_SdtRatingPlataforma_Mode(), "") == 0 )
         {
            bcRatingPlataforma.setgxTv_SdtRatingPlataforma_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars53( bcRatingPlataforma, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtRatingPlataforma getRatingPlataforma_BC( )
   {
      return bcRatingPlataforma ;
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
      Z406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      A406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      BC00175_A398RatingPlataformaId = new int[1] ;
      BC00175_A405RatingPlataformaCitaId = new short[1] ;
      BC00175_A401RatingPlataformaRating = new short[1] ;
      BC00175_A406RatingPlataformaFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00175_A61SGPacientePacienteId = new int[1] ;
      BC00176_A61SGPacientePacienteId = new int[1] ;
      BC00177_A398RatingPlataformaId = new int[1] ;
      BC00178_A398RatingPlataformaId = new int[1] ;
      BC00178_A405RatingPlataformaCitaId = new short[1] ;
      BC00178_A401RatingPlataformaRating = new short[1] ;
      BC00178_A406RatingPlataformaFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00178_A61SGPacientePacienteId = new int[1] ;
      sMode53 = "" ;
      BC00179_A398RatingPlataformaId = new int[1] ;
      BC00179_A405RatingPlataformaCitaId = new short[1] ;
      BC00179_A401RatingPlataformaRating = new short[1] ;
      BC00179_A406RatingPlataformaFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00179_A61SGPacientePacienteId = new int[1] ;
      BC001710_A398RatingPlataformaId = new int[1] ;
      BC001713_A398RatingPlataformaId = new int[1] ;
      BC001713_A405RatingPlataformaCitaId = new short[1] ;
      BC001713_A401RatingPlataformaRating = new short[1] ;
      BC001713_A406RatingPlataformaFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001713_A61SGPacientePacienteId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ratingplataforma_bc__default(),
         new Object[] {
             new Object[] {
            BC00172_A398RatingPlataformaId, BC00172_A405RatingPlataformaCitaId, BC00172_A401RatingPlataformaRating, BC00172_A406RatingPlataformaFechaRegistro, BC00172_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00173_A398RatingPlataformaId, BC00173_A405RatingPlataformaCitaId, BC00173_A401RatingPlataformaRating, BC00173_A406RatingPlataformaFechaRegistro, BC00173_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00174_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00175_A398RatingPlataformaId, BC00175_A405RatingPlataformaCitaId, BC00175_A401RatingPlataformaRating, BC00175_A406RatingPlataformaFechaRegistro, BC00175_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00176_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00177_A398RatingPlataformaId
            }
            , new Object[] {
            BC00178_A398RatingPlataformaId, BC00178_A405RatingPlataformaCitaId, BC00178_A401RatingPlataformaRating, BC00178_A406RatingPlataformaFechaRegistro, BC00178_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00179_A398RatingPlataformaId, BC00179_A405RatingPlataformaCitaId, BC00179_A401RatingPlataformaRating, BC00179_A406RatingPlataformaFechaRegistro, BC00179_A61SGPacientePacienteId
            }
            , new Object[] {
            BC001710_A398RatingPlataformaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001713_A398RatingPlataformaId, BC001713_A405RatingPlataformaCitaId, BC001713_A401RatingPlataformaRating, BC001713_A406RatingPlataformaFechaRegistro, BC001713_A61SGPacientePacienteId
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
   private short Z405RatingPlataformaCitaId ;
   private short A405RatingPlataformaCitaId ;
   private short Z401RatingPlataformaRating ;
   private short A401RatingPlataformaRating ;
   private short RcdFound53 ;
   private short nIsDirty_53 ;
   private int trnEnded ;
   private int Z398RatingPlataformaId ;
   private int A398RatingPlataformaId ;
   private int GX_JID ;
   private int Z61SGPacientePacienteId ;
   private int A61SGPacientePacienteId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode53 ;
   private java.util.Date Z406RatingPlataformaFechaRegistro ;
   private java.util.Date A406RatingPlataformaFechaRegistro ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtRatingPlataforma bcRatingPlataforma ;
   private IDataStoreProvider pr_default ;
   private int[] BC00175_A398RatingPlataformaId ;
   private short[] BC00175_A405RatingPlataformaCitaId ;
   private short[] BC00175_A401RatingPlataformaRating ;
   private java.util.Date[] BC00175_A406RatingPlataformaFechaRegistro ;
   private int[] BC00175_A61SGPacientePacienteId ;
   private int[] BC00176_A61SGPacientePacienteId ;
   private int[] BC00177_A398RatingPlataformaId ;
   private int[] BC00178_A398RatingPlataformaId ;
   private short[] BC00178_A405RatingPlataformaCitaId ;
   private short[] BC00178_A401RatingPlataformaRating ;
   private java.util.Date[] BC00178_A406RatingPlataformaFechaRegistro ;
   private int[] BC00178_A61SGPacientePacienteId ;
   private int[] BC00179_A398RatingPlataformaId ;
   private short[] BC00179_A405RatingPlataformaCitaId ;
   private short[] BC00179_A401RatingPlataformaRating ;
   private java.util.Date[] BC00179_A406RatingPlataformaFechaRegistro ;
   private int[] BC00179_A61SGPacientePacienteId ;
   private int[] BC001710_A398RatingPlataformaId ;
   private int[] BC001713_A398RatingPlataformaId ;
   private short[] BC001713_A405RatingPlataformaCitaId ;
   private short[] BC001713_A401RatingPlataformaRating ;
   private java.util.Date[] BC001713_A406RatingPlataformaFechaRegistro ;
   private int[] BC001713_A61SGPacientePacienteId ;
   private int[] BC00172_A398RatingPlataformaId ;
   private short[] BC00172_A405RatingPlataformaCitaId ;
   private short[] BC00172_A401RatingPlataformaRating ;
   private java.util.Date[] BC00172_A406RatingPlataformaFechaRegistro ;
   private int[] BC00172_A61SGPacientePacienteId ;
   private int[] BC00173_A398RatingPlataformaId ;
   private short[] BC00173_A405RatingPlataformaCitaId ;
   private short[] BC00173_A401RatingPlataformaRating ;
   private java.util.Date[] BC00173_A406RatingPlataformaFechaRegistro ;
   private int[] BC00173_A61SGPacientePacienteId ;
   private int[] BC00174_A61SGPacientePacienteId ;
}

final  class ratingplataforma_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00172", "SELECT [RatingPlataformaId], [RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] WITH (UPDLOCK) WHERE [RatingPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00173", "SELECT [RatingPlataformaId], [RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] WHERE [RatingPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00174", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00175", "SELECT TM1.[RatingPlataformaId], TM1.[RatingPlataformaCitaId], TM1.[RatingPlataformaRating], TM1.[RatingPlataformaFechaRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] TM1 WHERE TM1.[RatingPlataformaId] = ? ORDER BY TM1.[RatingPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00176", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00177", "SELECT [RatingPlataformaId] FROM [RatingPlataforma] WHERE [RatingPlataformaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00178", "SELECT [RatingPlataformaId], [RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] WHERE [RatingPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00179", "SELECT [RatingPlataformaId], [RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] WITH (UPDLOCK) WHERE [RatingPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001710", "INSERT INTO [RatingPlataforma]([RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC001711", "UPDATE [RatingPlataforma] SET [RatingPlataformaCitaId]=?, [RatingPlataformaRating]=?, [RatingPlataformaFechaRegistro]=?, [SGPacientePacienteId]=?  WHERE [RatingPlataformaId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001712", "DELETE FROM [RatingPlataforma]  WHERE [RatingPlataformaId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001713", "SELECT TM1.[RatingPlataformaId], TM1.[RatingPlataformaCitaId], TM1.[RatingPlataformaRating], TM1.[RatingPlataformaFechaRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] TM1 WHERE TM1.[RatingPlataformaId] = ? ORDER BY TM1.[RatingPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
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

