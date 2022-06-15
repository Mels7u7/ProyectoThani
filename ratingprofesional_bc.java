package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ratingprofesional_bc extends GXWebPanel implements IGxSilentTrn
{
   public ratingprofesional_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ratingprofesional_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ratingprofesional_bc.class ));
   }

   public ratingprofesional_bc( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1450( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1450( ) ;
      standaloneModal( ) ;
      addRow1450( ) ;
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
         e11142 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z60RatingProfesionalId = A60RatingProfesionalId ;
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

   public void confirm_140( )
   {
      beforeValidate1450( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1450( ) ;
         }
         else
         {
            checkExtendedTable1450( ) ;
            if ( AnyError == 0 )
            {
               zm1450( 3) ;
               zm1450( 4) ;
            }
            closeExtendedTableCursors1450( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12142( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e11142( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1450( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z366RatingProfesionalCitaId = A366RatingProfesionalCitaId ;
         Z352RatingProfesionalRating = A352RatingProfesionalRating ;
         Z353RatingProfesionalFechaRegistro = A353RatingProfesionalFechaRegistro ;
         Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z60RatingProfesionalId = A60RatingProfesionalId ;
         Z366RatingProfesionalCitaId = A366RatingProfesionalCitaId ;
         Z352RatingProfesionalRating = A352RatingProfesionalRating ;
         Z353RatingProfesionalFechaRegistro = A353RatingProfesionalFechaRegistro ;
         Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1450( )
   {
      /* Using cursor BC00146 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A366RatingProfesionalCitaId = BC00146_A366RatingProfesionalCitaId[0] ;
         A352RatingProfesionalRating = BC00146_A352RatingProfesionalRating[0] ;
         A353RatingProfesionalFechaRegistro = BC00146_A353RatingProfesionalFechaRegistro[0] ;
         A62SGProfesionalProfesionalId = BC00146_A62SGProfesionalProfesionalId[0] ;
         A61SGPacientePacienteId = BC00146_A61SGPacientePacienteId[0] ;
         zm1450( -2) ;
      }
      pr_default.close(4);
      onLoadActions1450( ) ;
   }

   public void onLoadActions1450( )
   {
   }

   public void checkExtendedTable1450( )
   {
      nIsDirty_50 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00147 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A62SGProfesionalProfesionalId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGProfesional'.", "ForeignKeyNotFound", 1, "SGPROFESIONALPROFESIONALID");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC00148 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A353RatingProfesionalFechaRegistro)) || (( GXutil.resetTime(A353RatingProfesionalFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A353RatingProfesionalFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Rating Profesional Fecha Registro fuera de rango", "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1450( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1450( )
   {
      /* Using cursor BC00149 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound50 = (short)(1) ;
      }
      else
      {
         RcdFound50 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001410 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1450( 2) ;
         RcdFound50 = (short)(1) ;
         A60RatingProfesionalId = BC001410_A60RatingProfesionalId[0] ;
         A366RatingProfesionalCitaId = BC001410_A366RatingProfesionalCitaId[0] ;
         A352RatingProfesionalRating = BC001410_A352RatingProfesionalRating[0] ;
         A353RatingProfesionalFechaRegistro = BC001410_A353RatingProfesionalFechaRegistro[0] ;
         A62SGProfesionalProfesionalId = BC001410_A62SGProfesionalProfesionalId[0] ;
         A61SGPacientePacienteId = BC001410_A61SGPacientePacienteId[0] ;
         Z60RatingProfesionalId = A60RatingProfesionalId ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1450( ) ;
         if ( AnyError == 1 )
         {
            RcdFound50 = (short)(0) ;
            initializeNonKey1450( ) ;
         }
         Gx_mode = sMode50 ;
      }
      else
      {
         RcdFound50 = (short)(0) ;
         initializeNonKey1450( ) ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode50 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1450( ) ;
      if ( RcdFound50 == 0 )
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
      confirm_140( ) ;
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

   public void checkOptimisticConcurrency1450( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001411 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingProfesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( Z366RatingProfesionalCitaId != BC001411_A366RatingProfesionalCitaId[0] ) || ( Z352RatingProfesionalRating != BC001411_A352RatingProfesionalRating[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z353RatingProfesionalFechaRegistro), GXutil.resetTime(BC001411_A353RatingProfesionalFechaRegistro[0])) ) || ( Z62SGProfesionalProfesionalId != BC001411_A62SGProfesionalProfesionalId[0] ) || ( Z61SGPacientePacienteId != BC001411_A61SGPacientePacienteId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"RatingProfesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1450( )
   {
      beforeValidate1450( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1450( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1450( 0) ;
         checkOptimisticConcurrency1450( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1450( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1450( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001412 */
                  pr_default.execute(10, new Object[] {Short.valueOf(A366RatingProfesionalCitaId), Short.valueOf(A352RatingProfesionalRating), A353RatingProfesionalFechaRegistro, Integer.valueOf(A62SGProfesionalProfesionalId), Integer.valueOf(A61SGPacientePacienteId)});
                  A60RatingProfesionalId = BC001412_A60RatingProfesionalId[0] ;
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingProfesional");
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
            load1450( ) ;
         }
         endLevel1450( ) ;
      }
      closeExtendedTableCursors1450( ) ;
   }

   public void update1450( )
   {
      beforeValidate1450( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1450( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1450( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1450( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1450( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001413 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A366RatingProfesionalCitaId), Short.valueOf(A352RatingProfesionalRating), A353RatingProfesionalFechaRegistro, Integer.valueOf(A62SGProfesionalProfesionalId), Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A60RatingProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingProfesional");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingProfesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1450( ) ;
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
         endLevel1450( ) ;
      }
      closeExtendedTableCursors1450( ) ;
   }

   public void deferredUpdate1450( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1450( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1450( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1450( ) ;
         afterConfirm1450( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1450( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001414 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingProfesional");
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
      sMode50 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1450( ) ;
      Gx_mode = sMode50 ;
   }

   public void onDeleteControls1450( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1450( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1450( ) ;
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

   public void scanKeyStart1450( )
   {
      /* Scan By routine */
      /* Using cursor BC001415 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      RcdFound50 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A60RatingProfesionalId = BC001415_A60RatingProfesionalId[0] ;
         A366RatingProfesionalCitaId = BC001415_A366RatingProfesionalCitaId[0] ;
         A352RatingProfesionalRating = BC001415_A352RatingProfesionalRating[0] ;
         A353RatingProfesionalFechaRegistro = BC001415_A353RatingProfesionalFechaRegistro[0] ;
         A62SGProfesionalProfesionalId = BC001415_A62SGProfesionalProfesionalId[0] ;
         A61SGPacientePacienteId = BC001415_A61SGPacientePacienteId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1450( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound50 = (short)(0) ;
      scanKeyLoad1450( ) ;
   }

   public void scanKeyLoad1450( )
   {
      sMode50 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A60RatingProfesionalId = BC001415_A60RatingProfesionalId[0] ;
         A366RatingProfesionalCitaId = BC001415_A366RatingProfesionalCitaId[0] ;
         A352RatingProfesionalRating = BC001415_A352RatingProfesionalRating[0] ;
         A353RatingProfesionalFechaRegistro = BC001415_A353RatingProfesionalFechaRegistro[0] ;
         A62SGProfesionalProfesionalId = BC001415_A62SGProfesionalProfesionalId[0] ;
         A61SGPacientePacienteId = BC001415_A61SGPacientePacienteId[0] ;
      }
      Gx_mode = sMode50 ;
   }

   public void scanKeyEnd1450( )
   {
      pr_default.close(13);
   }

   public void afterConfirm1450( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1450( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1450( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1450( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1450( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1450( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1450( )
   {
   }

   public void send_integrity_lvl_hashes1450( )
   {
   }

   public void addRow1450( )
   {
      VarsToRow50( bcRatingProfesional) ;
   }

   public void readRow1450( )
   {
      RowToVars50( bcRatingProfesional, 1) ;
   }

   public void initializeNonKey1450( )
   {
      A62SGProfesionalProfesionalId = 0 ;
      A61SGPacientePacienteId = 0 ;
      A366RatingProfesionalCitaId = (short)(0) ;
      A352RatingProfesionalRating = (short)(0) ;
      A353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      Z366RatingProfesionalCitaId = (short)(0) ;
      Z352RatingProfesionalRating = (short)(0) ;
      Z353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      Z62SGProfesionalProfesionalId = 0 ;
      Z61SGPacientePacienteId = 0 ;
   }

   public void initAll1450( )
   {
      A60RatingProfesionalId = 0 ;
      initializeNonKey1450( ) ;
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

   public void VarsToRow50( com.projectthani.SdtRatingProfesional obj50 )
   {
      obj50.setgxTv_SdtRatingProfesional_Mode( Gx_mode );
      obj50.setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid( A62SGProfesionalProfesionalId );
      obj50.setgxTv_SdtRatingProfesional_Sgpacientepacienteid( A61SGPacientePacienteId );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid( A366RatingProfesionalCitaId );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalrating( A352RatingProfesionalRating );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro( A353RatingProfesionalFechaRegistro );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalid( A60RatingProfesionalId );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalid_Z( Z60RatingProfesionalId );
      obj50.setgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z( Z62SGProfesionalProfesionalId );
      obj50.setgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z( Z61SGPacientePacienteId );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z( Z366RatingProfesionalCitaId );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z( Z352RatingProfesionalRating );
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z( Z353RatingProfesionalFechaRegistro );
      obj50.setgxTv_SdtRatingProfesional_Mode( Gx_mode );
   }

   public void KeyVarsToRow50( com.projectthani.SdtRatingProfesional obj50 )
   {
      obj50.setgxTv_SdtRatingProfesional_Ratingprofesionalid( A60RatingProfesionalId );
   }

   public void RowToVars50( com.projectthani.SdtRatingProfesional obj50 ,
                            int forceLoad )
   {
      Gx_mode = obj50.getgxTv_SdtRatingProfesional_Mode() ;
      A62SGProfesionalProfesionalId = obj50.getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid() ;
      A61SGPacientePacienteId = obj50.getgxTv_SdtRatingProfesional_Sgpacientepacienteid() ;
      A366RatingProfesionalCitaId = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid() ;
      A352RatingProfesionalRating = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalrating() ;
      A353RatingProfesionalFechaRegistro = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro() ;
      A60RatingProfesionalId = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalid() ;
      Z60RatingProfesionalId = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalid_Z() ;
      Z62SGProfesionalProfesionalId = obj50.getgxTv_SdtRatingProfesional_Sgprofesionalprofesionalid_Z() ;
      Z61SGPacientePacienteId = obj50.getgxTv_SdtRatingProfesional_Sgpacientepacienteid_Z() ;
      Z366RatingProfesionalCitaId = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalcitaid_Z() ;
      Z352RatingProfesionalRating = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalrating_Z() ;
      Z353RatingProfesionalFechaRegistro = obj50.getgxTv_SdtRatingProfesional_Ratingprofesionalfecharegistro_Z() ;
      Gx_mode = obj50.getgxTv_SdtRatingProfesional_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A60RatingProfesionalId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1450( ) ;
      scanKeyStart1450( ) ;
      if ( RcdFound50 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z60RatingProfesionalId = A60RatingProfesionalId ;
      }
      zm1450( -2) ;
      onLoadActions1450( ) ;
      addRow1450( ) ;
      scanKeyEnd1450( ) ;
      if ( RcdFound50 == 0 )
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
      RowToVars50( bcRatingProfesional, 0) ;
      scanKeyStart1450( ) ;
      if ( RcdFound50 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z60RatingProfesionalId = A60RatingProfesionalId ;
      }
      zm1450( -2) ;
      onLoadActions1450( ) ;
      addRow1450( ) ;
      scanKeyEnd1450( ) ;
      if ( RcdFound50 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1450( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1450( ) ;
      }
      else
      {
         if ( RcdFound50 == 1 )
         {
            if ( A60RatingProfesionalId != Z60RatingProfesionalId )
            {
               A60RatingProfesionalId = Z60RatingProfesionalId ;
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
               update1450( ) ;
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
               if ( A60RatingProfesionalId != Z60RatingProfesionalId )
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
                     insert1450( ) ;
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
                     insert1450( ) ;
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
      RowToVars50( bcRatingProfesional, 1) ;
      saveImpl( ) ;
      VarsToRow50( bcRatingProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars50( bcRatingProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1450( ) ;
      afterTrn( ) ;
      VarsToRow50( bcRatingProfesional) ;
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
         com.projectthani.SdtRatingProfesional auxBC = new com.projectthani.SdtRatingProfesional( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A60RatingProfesionalId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcRatingProfesional);
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
      RowToVars50( bcRatingProfesional, 1) ;
      updateImpl( ) ;
      VarsToRow50( bcRatingProfesional) ;
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
      RowToVars50( bcRatingProfesional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1450( ) ;
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
      VarsToRow50( bcRatingProfesional) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars50( bcRatingProfesional, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1450( ) ;
      if ( RcdFound50 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A60RatingProfesionalId != Z60RatingProfesionalId )
         {
            A60RatingProfesionalId = Z60RatingProfesionalId ;
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
         if ( A60RatingProfesionalId != Z60RatingProfesionalId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "ratingprofesional_bc");
      VarsToRow50( bcRatingProfesional) ;
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
      Gx_mode = bcRatingProfesional.getgxTv_SdtRatingProfesional_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcRatingProfesional.setgxTv_SdtRatingProfesional_Mode( Gx_mode );
   }

   public void SetSDT( com.projectthani.SdtRatingProfesional sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcRatingProfesional )
      {
         bcRatingProfesional = sdt ;
         if ( GXutil.strcmp(bcRatingProfesional.getgxTv_SdtRatingProfesional_Mode(), "") == 0 )
         {
            bcRatingProfesional.setgxTv_SdtRatingProfesional_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow50( bcRatingProfesional) ;
         }
         else
         {
            RowToVars50( bcRatingProfesional, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcRatingProfesional.getgxTv_SdtRatingProfesional_Mode(), "") == 0 )
         {
            bcRatingProfesional.setgxTv_SdtRatingProfesional_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars50( bcRatingProfesional, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtRatingProfesional getRatingProfesional_BC( )
   {
      return bcRatingProfesional ;
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
      Z353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      A353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      BC00146_A60RatingProfesionalId = new int[1] ;
      BC00146_A366RatingProfesionalCitaId = new short[1] ;
      BC00146_A352RatingProfesionalRating = new short[1] ;
      BC00146_A353RatingProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC00146_A62SGProfesionalProfesionalId = new int[1] ;
      BC00146_A61SGPacientePacienteId = new int[1] ;
      BC00147_A62SGProfesionalProfesionalId = new int[1] ;
      BC00148_A61SGPacientePacienteId = new int[1] ;
      BC00149_A60RatingProfesionalId = new int[1] ;
      BC001410_A60RatingProfesionalId = new int[1] ;
      BC001410_A366RatingProfesionalCitaId = new short[1] ;
      BC001410_A352RatingProfesionalRating = new short[1] ;
      BC001410_A353RatingProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001410_A62SGProfesionalProfesionalId = new int[1] ;
      BC001410_A61SGPacientePacienteId = new int[1] ;
      sMode50 = "" ;
      BC001411_A60RatingProfesionalId = new int[1] ;
      BC001411_A366RatingProfesionalCitaId = new short[1] ;
      BC001411_A352RatingProfesionalRating = new short[1] ;
      BC001411_A353RatingProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001411_A62SGProfesionalProfesionalId = new int[1] ;
      BC001411_A61SGPacientePacienteId = new int[1] ;
      BC001412_A60RatingProfesionalId = new int[1] ;
      BC001415_A60RatingProfesionalId = new int[1] ;
      BC001415_A366RatingProfesionalCitaId = new short[1] ;
      BC001415_A352RatingProfesionalRating = new short[1] ;
      BC001415_A353RatingProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      BC001415_A62SGProfesionalProfesionalId = new int[1] ;
      BC001415_A61SGPacientePacienteId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ratingprofesional_bc__default(),
         new Object[] {
             new Object[] {
            BC00142_A60RatingProfesionalId, BC00142_A366RatingProfesionalCitaId, BC00142_A352RatingProfesionalRating, BC00142_A353RatingProfesionalFechaRegistro, BC00142_A62SGProfesionalProfesionalId, BC00142_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00143_A60RatingProfesionalId, BC00143_A366RatingProfesionalCitaId, BC00143_A352RatingProfesionalRating, BC00143_A353RatingProfesionalFechaRegistro, BC00143_A62SGProfesionalProfesionalId, BC00143_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00144_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC00145_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00146_A60RatingProfesionalId, BC00146_A366RatingProfesionalCitaId, BC00146_A352RatingProfesionalRating, BC00146_A353RatingProfesionalFechaRegistro, BC00146_A62SGProfesionalProfesionalId, BC00146_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00147_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            BC00148_A61SGPacientePacienteId
            }
            , new Object[] {
            BC00149_A60RatingProfesionalId
            }
            , new Object[] {
            BC001410_A60RatingProfesionalId, BC001410_A366RatingProfesionalCitaId, BC001410_A352RatingProfesionalRating, BC001410_A353RatingProfesionalFechaRegistro, BC001410_A62SGProfesionalProfesionalId, BC001410_A61SGPacientePacienteId
            }
            , new Object[] {
            BC001411_A60RatingProfesionalId, BC001411_A366RatingProfesionalCitaId, BC001411_A352RatingProfesionalRating, BC001411_A353RatingProfesionalFechaRegistro, BC001411_A62SGProfesionalProfesionalId, BC001411_A61SGPacientePacienteId
            }
            , new Object[] {
            BC001412_A60RatingProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001415_A60RatingProfesionalId, BC001415_A366RatingProfesionalCitaId, BC001415_A352RatingProfesionalRating, BC001415_A353RatingProfesionalFechaRegistro, BC001415_A62SGProfesionalProfesionalId, BC001415_A61SGPacientePacienteId
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12142 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z366RatingProfesionalCitaId ;
   private short A366RatingProfesionalCitaId ;
   private short Z352RatingProfesionalRating ;
   private short A352RatingProfesionalRating ;
   private short RcdFound50 ;
   private short nIsDirty_50 ;
   private int trnEnded ;
   private int Z60RatingProfesionalId ;
   private int A60RatingProfesionalId ;
   private int GX_JID ;
   private int Z62SGProfesionalProfesionalId ;
   private int A62SGProfesionalProfesionalId ;
   private int Z61SGPacientePacienteId ;
   private int A61SGPacientePacienteId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode50 ;
   private java.util.Date Z353RatingProfesionalFechaRegistro ;
   private java.util.Date A353RatingProfesionalFechaRegistro ;
   private boolean returnInSub ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.projectthani.SdtRatingProfesional bcRatingProfesional ;
   private IDataStoreProvider pr_default ;
   private int[] BC00146_A60RatingProfesionalId ;
   private short[] BC00146_A366RatingProfesionalCitaId ;
   private short[] BC00146_A352RatingProfesionalRating ;
   private java.util.Date[] BC00146_A353RatingProfesionalFechaRegistro ;
   private int[] BC00146_A62SGProfesionalProfesionalId ;
   private int[] BC00146_A61SGPacientePacienteId ;
   private int[] BC00147_A62SGProfesionalProfesionalId ;
   private int[] BC00148_A61SGPacientePacienteId ;
   private int[] BC00149_A60RatingProfesionalId ;
   private int[] BC001410_A60RatingProfesionalId ;
   private short[] BC001410_A366RatingProfesionalCitaId ;
   private short[] BC001410_A352RatingProfesionalRating ;
   private java.util.Date[] BC001410_A353RatingProfesionalFechaRegistro ;
   private int[] BC001410_A62SGProfesionalProfesionalId ;
   private int[] BC001410_A61SGPacientePacienteId ;
   private int[] BC001411_A60RatingProfesionalId ;
   private short[] BC001411_A366RatingProfesionalCitaId ;
   private short[] BC001411_A352RatingProfesionalRating ;
   private java.util.Date[] BC001411_A353RatingProfesionalFechaRegistro ;
   private int[] BC001411_A62SGProfesionalProfesionalId ;
   private int[] BC001411_A61SGPacientePacienteId ;
   private int[] BC001412_A60RatingProfesionalId ;
   private int[] BC001415_A60RatingProfesionalId ;
   private short[] BC001415_A366RatingProfesionalCitaId ;
   private short[] BC001415_A352RatingProfesionalRating ;
   private java.util.Date[] BC001415_A353RatingProfesionalFechaRegistro ;
   private int[] BC001415_A62SGProfesionalProfesionalId ;
   private int[] BC001415_A61SGPacientePacienteId ;
   private int[] BC00142_A60RatingProfesionalId ;
   private short[] BC00142_A366RatingProfesionalCitaId ;
   private short[] BC00142_A352RatingProfesionalRating ;
   private java.util.Date[] BC00142_A353RatingProfesionalFechaRegistro ;
   private int[] BC00142_A62SGProfesionalProfesionalId ;
   private int[] BC00142_A61SGPacientePacienteId ;
   private int[] BC00143_A60RatingProfesionalId ;
   private short[] BC00143_A366RatingProfesionalCitaId ;
   private short[] BC00143_A352RatingProfesionalRating ;
   private java.util.Date[] BC00143_A353RatingProfesionalFechaRegistro ;
   private int[] BC00143_A62SGProfesionalProfesionalId ;
   private int[] BC00143_A61SGPacientePacienteId ;
   private int[] BC00144_A62SGProfesionalProfesionalId ;
   private int[] BC00145_A61SGPacientePacienteId ;
}

final  class ratingprofesional_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00142", "SELECT [RatingProfesionalId], [RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] WITH (UPDLOCK) WHERE [RatingProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00143", "SELECT [RatingProfesionalId], [RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] WHERE [RatingProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00144", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00145", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00146", "SELECT TM1.[RatingProfesionalId], TM1.[RatingProfesionalCitaId], TM1.[RatingProfesionalRating], TM1.[RatingProfesionalFechaRegistro], TM1.[SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] TM1 WHERE TM1.[RatingProfesionalId] = ? ORDER BY TM1.[RatingProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00147", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00148", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00149", "SELECT [RatingProfesionalId] FROM [RatingProfesional] WHERE [RatingProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001410", "SELECT [RatingProfesionalId], [RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] WHERE [RatingProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001411", "SELECT [RatingProfesionalId], [RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] WITH (UPDLOCK) WHERE [RatingProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001412", "INSERT INTO [RatingProfesional]([RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId], [SGPacientePacienteId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("BC001413", "UPDATE [RatingProfesional] SET [RatingProfesionalCitaId]=?, [RatingProfesionalRating]=?, [RatingProfesionalFechaRegistro]=?, [SGProfesionalProfesionalId]=?, [SGPacientePacienteId]=?  WHERE [RatingProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001414", "DELETE FROM [RatingProfesional]  WHERE [RatingProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001415", "SELECT TM1.[RatingProfesionalId], TM1.[RatingProfesionalCitaId], TM1.[RatingProfesionalRating], TM1.[RatingProfesionalFechaRegistro], TM1.[SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] TM1 WHERE TM1.[RatingProfesionalId] = ? ORDER BY TM1.[RatingProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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

