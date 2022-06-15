package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pagowwgetfilterdata extends GXProcedure
{
   public pagowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pagowwgetfilterdata.class ), "" );
   }

   public pagowwgetfilterdata( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      pagowwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      pagowwgetfilterdata.this.AV55DDOName = aP0;
      pagowwgetfilterdata.this.AV53SearchTxt = aP1;
      pagowwgetfilterdata.this.AV54SearchTxtTo = aP2;
      pagowwgetfilterdata.this.aP3 = aP3;
      pagowwgetfilterdata.this.aP4 = aP4;
      pagowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV58Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago", GXv_boolean2) ;
      pagowwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_CITACODE") == 0 )
         {
            /* Execute user subroutine: 'LOADCITACODEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOTOKEN") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOTOKENOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOCLIENTENRODOCUMENTO") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOCLIENTENRODOCUMENTOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOCLIENTEDENOMINACION") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOCLIENTEDENOMINACIONOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOCLIENTEDIRECCION") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOCLIENTEDIRECCIONOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOCLIENTEEMAIL") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOCLIENTEEMAILOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGONUBEFACTREQUEST") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGONUBEFACTREQUESTOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGONUBEFACTRESPONSE") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGONUBEFACTRESPONSEOPTIONS' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOREQUEST") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOREQUESTOPTIONS' */
            S201 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGORESPONSE") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGORESPONSEOPTIONS' */
            S211 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOPASARELAID") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOPASARELAIDOPTIONS' */
            S221 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOENLACEPDF") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOENLACEPDFOPTIONS' */
            S231 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV55DDOName), "DDO_PAGOENLACEXML") == 0 )
         {
            /* Execute user subroutine: 'LOADPAGOENLACEXMLOPTIONS' */
            S241 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV59OptionsJson = AV58Options.toJSonString(false) ;
      AV62OptionsDescJson = AV61OptionsDesc.toJSonString(false) ;
      AV64OptionIndexesJson = AV63OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV66Session.getValue("PagoWWGridState"), "") == 0 )
      {
         AV68GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PagoWWGridState"), null, null);
      }
      else
      {
         AV68GridState.fromxml(AV66Session.getValue("PagoWWGridState"), null, null);
      }
      AV88GXV1 = 1 ;
      while ( AV88GXV1 <= AV68GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV69GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV68GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV88GXV1));
         if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV71FilterFullText = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOID") == 0 )
         {
            AV11TFPagoId = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPagoId_To = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV13TFCitaId = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFCitaId_To = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV15TFCitaCode = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV16TFCitaCode_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV17TFSGCitaDisponibilidadFecha = localUtil.ctod( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV18TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONTO") == 0 )
         {
            AV19TFPagoMonto = CommonUtil.decimalVal( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV20TFPagoMonto_To = CommonUtil.decimalVal( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN") == 0 )
         {
            AV21TFPagoToken = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTOKEN_SEL") == 0 )
         {
            AV22TFPagoToken_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTOCLIENTE_SEL") == 0 )
         {
            AV23TFPagoTipoDocumentoCliente_SelsJson = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFPagoTipoDocumentoCliente_Sels.fromJSonString(AV23TFPagoTipoDocumentoCliente_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO") == 0 )
         {
            AV25TFPagoClienteNroDocumento = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV26TFPagoClienteNroDocumento_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION") == 0 )
         {
            AV27TFPagoClienteDenominacion = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDENOMINACION_SEL") == 0 )
         {
            AV28TFPagoClienteDenominacion_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION") == 0 )
         {
            AV29TFPagoClienteDireccion = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEDIRECCION_SEL") == 0 )
         {
            AV30TFPagoClienteDireccion_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL") == 0 )
         {
            AV31TFPagoClienteEmail = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOCLIENTEEMAIL_SEL") == 0 )
         {
            AV32TFPagoClienteEmail_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOTIPODOCUMENTO_SEL") == 0 )
         {
            AV33TFPagoTipoDocumento_SelsJson = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV34TFPagoTipoDocumento_Sels.fromJSonString(AV33TFPagoTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUMERO") == 0 )
         {
            AV35TFPagoNumero = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFPagoNumero_To = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOFECHAEMISION") == 0 )
         {
            AV37TFPagoFechaEmision = localUtil.ctod( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV38TFPagoFechaEmision_To = localUtil.ctod( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOMONEDA_SEL") == 0 )
         {
            AV39TFPagoMoneda_SelsJson = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFPagoMoneda_Sels.fromJSonString(AV39TFPagoMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST") == 0 )
         {
            AV47TFPagoNubefactRequest = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTREQUEST_SEL") == 0 )
         {
            AV48TFPagoNubefactRequest_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE") == 0 )
         {
            AV49TFPagoNubefactResponse = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGONUBEFACTRESPONSE_SEL") == 0 )
         {
            AV50TFPagoNubefactResponse_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST") == 0 )
         {
            AV72TFPagoRequest = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOREQUEST_SEL") == 0 )
         {
            AV73TFPagoRequest_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE") == 0 )
         {
            AV74TFPagoResponse = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGORESPONSE_SEL") == 0 )
         {
            AV75TFPagoResponse_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID") == 0 )
         {
            AV76TFPagoPasarelaId = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOPASARELAID_SEL") == 0 )
         {
            AV77TFPagoPasarelaId_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOSTATUSCODE") == 0 )
         {
            AV78TFPagoStatusCode = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV79TFPagoStatusCode_To = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDISPONIBILIDADID") == 0 )
         {
            AV80TFDisponibilidadId = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV81TFDisponibilidadId_To = (int)(GXutil.lval( AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF") == 0 )
         {
            AV82TFPagoEnlacePDF = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEPDF_SEL") == 0 )
         {
            AV83TFPagoEnlacePDF_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML") == 0 )
         {
            AV84TFPagoEnlaceXML = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOENLACEXML_SEL") == 0 )
         {
            AV85TFPagoEnlaceXML_Sel = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAGOESTADOR_SEL") == 0 )
         {
            AV51TFPagoEstadoR_SelsJson = AV69GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFPagoEstadoR_Sels.fromJSonString(AV51TFPagoEstadoR_SelsJson, null);
         }
         AV88GXV1 = (int)(AV88GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCITACODEOPTIONS' Routine */
      returnInSub = false ;
      AV15TFCitaCode = AV53SearchTxt ;
      AV16TFCitaCode_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B2 */
      pr_default.execute(0, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3B2 = false ;
         A21SGCitaDisponibilidadId = P003B2_A21SGCitaDisponibilidadId[0] ;
         A19CitaId = P003B2_A19CitaId[0] ;
         n19CitaId = P003B2_n19CitaId[0] ;
         A34DisponibilidadId = P003B2_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B2_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B2_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B2_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B2_A245PagoNumero[0] ;
         A242PagoMonto = P003B2_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B2_n66SGCitaDisponibilidadFecha[0] ;
         A47PagoId = P003B2_A47PagoId[0] ;
         A246PagoEstadoR = P003B2_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B2_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B2_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B2_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B2_A309PagoResponse[0] ;
         A308PagoRequest = P003B2_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B2_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B2_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B2_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B2_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B2_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B2_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B2_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B2_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B2_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B2_A243PagoToken[0] ;
         A64CitaCode = P003B2_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B2_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B2_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B2_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P003B2_A19CitaId[0] == A19CitaId ) )
         {
            brk3B2 = false ;
            A47PagoId = P003B2_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A64CitaCode)==0) )
         {
            AV57Option = A64CitaCode ;
            AV56InsertIndex = 1 ;
            while ( ( AV56InsertIndex <= AV58Options.size() ) && ( GXutil.strcmp((String)AV58Options.elementAt(-1+AV56InsertIndex), AV57Option) < 0 ) )
            {
               AV56InsertIndex = (int)(AV56InsertIndex+1) ;
            }
            AV58Options.add(AV57Option, AV56InsertIndex);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), AV56InsertIndex);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B2 )
         {
            brk3B2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPAGOTOKENOPTIONS' Routine */
      returnInSub = false ;
      AV21TFPagoToken = AV53SearchTxt ;
      AV22TFPagoToken_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B3 */
      pr_default.execute(1, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3B4 = false ;
         A21SGCitaDisponibilidadId = P003B3_A21SGCitaDisponibilidadId[0] ;
         A243PagoToken = P003B3_A243PagoToken[0] ;
         A34DisponibilidadId = P003B3_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B3_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B3_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B3_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B3_A245PagoNumero[0] ;
         A242PagoMonto = P003B3_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B3_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B3_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B3_A19CitaId[0] ;
         n19CitaId = P003B3_n19CitaId[0] ;
         A47PagoId = P003B3_A47PagoId[0] ;
         A246PagoEstadoR = P003B3_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B3_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B3_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B3_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B3_A309PagoResponse[0] ;
         A308PagoRequest = P003B3_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B3_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B3_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B3_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B3_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B3_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B3_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B3_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B3_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B3_A247PagoTipoDocumentoCliente[0] ;
         A64CitaCode = P003B3_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B3_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B3_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B3_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B3_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003B3_A243PagoToken[0], A243PagoToken) == 0 ) )
         {
            brk3B4 = false ;
            A47PagoId = P003B3_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A243PagoToken)==0) )
         {
            AV57Option = A243PagoToken ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B4 )
         {
            brk3B4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPAGOCLIENTENRODOCUMENTOOPTIONS' Routine */
      returnInSub = false ;
      AV25TFPagoClienteNroDocumento = AV53SearchTxt ;
      AV26TFPagoClienteNroDocumento_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B4 */
      pr_default.execute(2, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3B6 = false ;
         A21SGCitaDisponibilidadId = P003B4_A21SGCitaDisponibilidadId[0] ;
         A248PagoClienteNroDocumento = P003B4_A248PagoClienteNroDocumento[0] ;
         A34DisponibilidadId = P003B4_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B4_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B4_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B4_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B4_A245PagoNumero[0] ;
         A242PagoMonto = P003B4_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B4_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B4_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B4_A19CitaId[0] ;
         n19CitaId = P003B4_n19CitaId[0] ;
         A47PagoId = P003B4_A47PagoId[0] ;
         A246PagoEstadoR = P003B4_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B4_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B4_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B4_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B4_A309PagoResponse[0] ;
         A308PagoRequest = P003B4_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B4_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B4_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B4_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B4_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B4_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B4_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B4_A249PagoClienteDenominacion[0] ;
         A247PagoTipoDocumentoCliente = P003B4_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B4_A243PagoToken[0] ;
         A64CitaCode = P003B4_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B4_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B4_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B4_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B4_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003B4_A248PagoClienteNroDocumento[0], A248PagoClienteNroDocumento) == 0 ) )
         {
            brk3B6 = false ;
            A47PagoId = P003B4_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A248PagoClienteNroDocumento)==0) )
         {
            AV57Option = A248PagoClienteNroDocumento ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B6 )
         {
            brk3B6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADPAGOCLIENTEDENOMINACIONOPTIONS' Routine */
      returnInSub = false ;
      AV27TFPagoClienteDenominacion = AV53SearchTxt ;
      AV28TFPagoClienteDenominacion_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B5 */
      pr_default.execute(3, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3B8 = false ;
         A21SGCitaDisponibilidadId = P003B5_A21SGCitaDisponibilidadId[0] ;
         A249PagoClienteDenominacion = P003B5_A249PagoClienteDenominacion[0] ;
         A34DisponibilidadId = P003B5_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B5_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B5_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B5_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B5_A245PagoNumero[0] ;
         A242PagoMonto = P003B5_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B5_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B5_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B5_A19CitaId[0] ;
         n19CitaId = P003B5_n19CitaId[0] ;
         A47PagoId = P003B5_A47PagoId[0] ;
         A246PagoEstadoR = P003B5_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B5_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B5_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B5_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B5_A309PagoResponse[0] ;
         A308PagoRequest = P003B5_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B5_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B5_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B5_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B5_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B5_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B5_A250PagoClienteDireccion[0] ;
         A248PagoClienteNroDocumento = P003B5_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B5_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B5_A243PagoToken[0] ;
         A64CitaCode = P003B5_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B5_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B5_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B5_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B5_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P003B5_A249PagoClienteDenominacion[0], A249PagoClienteDenominacion) == 0 ) )
         {
            brk3B8 = false ;
            A47PagoId = P003B5_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A249PagoClienteDenominacion)==0) )
         {
            AV57Option = A249PagoClienteDenominacion ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B8 )
         {
            brk3B8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADPAGOCLIENTEDIRECCIONOPTIONS' Routine */
      returnInSub = false ;
      AV29TFPagoClienteDireccion = AV53SearchTxt ;
      AV30TFPagoClienteDireccion_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B6 */
      pr_default.execute(4, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk3B10 = false ;
         A21SGCitaDisponibilidadId = P003B6_A21SGCitaDisponibilidadId[0] ;
         A250PagoClienteDireccion = P003B6_A250PagoClienteDireccion[0] ;
         A34DisponibilidadId = P003B6_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B6_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B6_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B6_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B6_A245PagoNumero[0] ;
         A242PagoMonto = P003B6_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B6_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B6_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B6_A19CitaId[0] ;
         n19CitaId = P003B6_n19CitaId[0] ;
         A47PagoId = P003B6_A47PagoId[0] ;
         A246PagoEstadoR = P003B6_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B6_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B6_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B6_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B6_A309PagoResponse[0] ;
         A308PagoRequest = P003B6_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B6_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B6_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B6_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B6_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B6_A251PagoClienteEmail[0] ;
         A249PagoClienteDenominacion = P003B6_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B6_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B6_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B6_A243PagoToken[0] ;
         A64CitaCode = P003B6_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B6_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B6_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B6_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B6_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P003B6_A250PagoClienteDireccion[0], A250PagoClienteDireccion) == 0 ) )
         {
            brk3B10 = false ;
            A47PagoId = P003B6_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A250PagoClienteDireccion)==0) )
         {
            AV57Option = A250PagoClienteDireccion ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B10 )
         {
            brk3B10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADPAGOCLIENTEEMAILOPTIONS' Routine */
      returnInSub = false ;
      AV31TFPagoClienteEmail = AV53SearchTxt ;
      AV32TFPagoClienteEmail_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B7 */
      pr_default.execute(5, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk3B12 = false ;
         A21SGCitaDisponibilidadId = P003B7_A21SGCitaDisponibilidadId[0] ;
         A251PagoClienteEmail = P003B7_A251PagoClienteEmail[0] ;
         A34DisponibilidadId = P003B7_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B7_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B7_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B7_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B7_A245PagoNumero[0] ;
         A242PagoMonto = P003B7_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B7_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B7_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B7_A19CitaId[0] ;
         n19CitaId = P003B7_n19CitaId[0] ;
         A47PagoId = P003B7_A47PagoId[0] ;
         A246PagoEstadoR = P003B7_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B7_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B7_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B7_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B7_A309PagoResponse[0] ;
         A308PagoRequest = P003B7_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B7_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B7_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B7_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B7_A244PagoTipoDocumento[0] ;
         A250PagoClienteDireccion = P003B7_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B7_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B7_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B7_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B7_A243PagoToken[0] ;
         A64CitaCode = P003B7_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B7_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B7_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B7_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B7_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P003B7_A251PagoClienteEmail[0], A251PagoClienteEmail) == 0 ) )
         {
            brk3B12 = false ;
            A47PagoId = P003B7_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A251PagoClienteEmail)==0) )
         {
            AV57Option = A251PagoClienteEmail ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B12 )
         {
            brk3B12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADPAGONUBEFACTREQUESTOPTIONS' Routine */
      returnInSub = false ;
      AV47TFPagoNubefactRequest = AV53SearchTxt ;
      AV48TFPagoNubefactRequest_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B8 */
      pr_default.execute(6, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk3B14 = false ;
         A21SGCitaDisponibilidadId = P003B8_A21SGCitaDisponibilidadId[0] ;
         A256PagoNubefactRequest = P003B8_A256PagoNubefactRequest[0] ;
         A34DisponibilidadId = P003B8_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B8_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B8_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B8_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B8_A245PagoNumero[0] ;
         A242PagoMonto = P003B8_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B8_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B8_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B8_A19CitaId[0] ;
         n19CitaId = P003B8_n19CitaId[0] ;
         A47PagoId = P003B8_A47PagoId[0] ;
         A246PagoEstadoR = P003B8_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B8_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B8_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B8_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B8_A309PagoResponse[0] ;
         A308PagoRequest = P003B8_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B8_A257PagoNubefactResponse[0] ;
         A253PagoMoneda = P003B8_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B8_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B8_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B8_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B8_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B8_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B8_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B8_A243PagoToken[0] ;
         A64CitaCode = P003B8_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B8_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B8_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B8_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B8_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P003B8_A256PagoNubefactRequest[0], A256PagoNubefactRequest) == 0 ) )
         {
            brk3B14 = false ;
            A47PagoId = P003B8_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B14 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A256PagoNubefactRequest)==0) )
         {
            AV57Option = A256PagoNubefactRequest ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B14 )
         {
            brk3B14 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADPAGONUBEFACTRESPONSEOPTIONS' Routine */
      returnInSub = false ;
      AV49TFPagoNubefactResponse = AV53SearchTxt ;
      AV50TFPagoNubefactResponse_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B9 */
      pr_default.execute(7, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(7) != 101) )
      {
         brk3B16 = false ;
         A21SGCitaDisponibilidadId = P003B9_A21SGCitaDisponibilidadId[0] ;
         A257PagoNubefactResponse = P003B9_A257PagoNubefactResponse[0] ;
         A34DisponibilidadId = P003B9_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B9_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B9_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B9_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B9_A245PagoNumero[0] ;
         A242PagoMonto = P003B9_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B9_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B9_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B9_A19CitaId[0] ;
         n19CitaId = P003B9_n19CitaId[0] ;
         A47PagoId = P003B9_A47PagoId[0] ;
         A246PagoEstadoR = P003B9_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B9_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B9_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B9_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B9_A309PagoResponse[0] ;
         A308PagoRequest = P003B9_A308PagoRequest[0] ;
         A256PagoNubefactRequest = P003B9_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B9_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B9_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B9_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B9_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B9_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B9_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B9_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B9_A243PagoToken[0] ;
         A64CitaCode = P003B9_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B9_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B9_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B9_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B9_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(7) != 101) && ( GXutil.strcmp(P003B9_A257PagoNubefactResponse[0], A257PagoNubefactResponse) == 0 ) )
         {
            brk3B16 = false ;
            A47PagoId = P003B9_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B16 = true ;
            pr_default.readNext(7);
         }
         if ( ! (GXutil.strcmp("", A257PagoNubefactResponse)==0) )
         {
            AV57Option = A257PagoNubefactResponse ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B16 )
         {
            brk3B16 = true ;
            pr_default.readNext(7);
         }
      }
      pr_default.close(7);
   }

   public void S201( )
   {
      /* 'LOADPAGOREQUESTOPTIONS' Routine */
      returnInSub = false ;
      AV72TFPagoRequest = AV53SearchTxt ;
      AV73TFPagoRequest_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(8, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B10 */
      pr_default.execute(8, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(8) != 101) )
      {
         brk3B18 = false ;
         A21SGCitaDisponibilidadId = P003B10_A21SGCitaDisponibilidadId[0] ;
         A308PagoRequest = P003B10_A308PagoRequest[0] ;
         A34DisponibilidadId = P003B10_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B10_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B10_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B10_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B10_A245PagoNumero[0] ;
         A242PagoMonto = P003B10_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B10_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B10_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B10_A19CitaId[0] ;
         n19CitaId = P003B10_n19CitaId[0] ;
         A47PagoId = P003B10_A47PagoId[0] ;
         A246PagoEstadoR = P003B10_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B10_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B10_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B10_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B10_A309PagoResponse[0] ;
         A257PagoNubefactResponse = P003B10_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B10_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B10_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B10_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B10_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B10_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B10_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B10_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B10_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B10_A243PagoToken[0] ;
         A64CitaCode = P003B10_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B10_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B10_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B10_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B10_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(8) != 101) && ( GXutil.strcmp(P003B10_A308PagoRequest[0], A308PagoRequest) == 0 ) )
         {
            brk3B18 = false ;
            A47PagoId = P003B10_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B18 = true ;
            pr_default.readNext(8);
         }
         if ( ! (GXutil.strcmp("", A308PagoRequest)==0) )
         {
            AV57Option = A308PagoRequest ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B18 )
         {
            brk3B18 = true ;
            pr_default.readNext(8);
         }
      }
      pr_default.close(8);
   }

   public void S211( )
   {
      /* 'LOADPAGORESPONSEOPTIONS' Routine */
      returnInSub = false ;
      AV74TFPagoResponse = AV53SearchTxt ;
      AV75TFPagoResponse_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(9, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B11 */
      pr_default.execute(9, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(9) != 101) )
      {
         brk3B20 = false ;
         A21SGCitaDisponibilidadId = P003B11_A21SGCitaDisponibilidadId[0] ;
         A309PagoResponse = P003B11_A309PagoResponse[0] ;
         A34DisponibilidadId = P003B11_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B11_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B11_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B11_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B11_A245PagoNumero[0] ;
         A242PagoMonto = P003B11_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B11_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B11_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B11_A19CitaId[0] ;
         n19CitaId = P003B11_n19CitaId[0] ;
         A47PagoId = P003B11_A47PagoId[0] ;
         A246PagoEstadoR = P003B11_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B11_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B11_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B11_A310PagoPasarelaId[0] ;
         A308PagoRequest = P003B11_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B11_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B11_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B11_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B11_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B11_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B11_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B11_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B11_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B11_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B11_A243PagoToken[0] ;
         A64CitaCode = P003B11_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B11_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B11_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B11_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B11_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(9) != 101) && ( GXutil.strcmp(P003B11_A309PagoResponse[0], A309PagoResponse) == 0 ) )
         {
            brk3B20 = false ;
            A47PagoId = P003B11_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B20 = true ;
            pr_default.readNext(9);
         }
         if ( ! (GXutil.strcmp("", A309PagoResponse)==0) )
         {
            AV57Option = A309PagoResponse ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B20 )
         {
            brk3B20 = true ;
            pr_default.readNext(9);
         }
      }
      pr_default.close(9);
   }

   public void S221( )
   {
      /* 'LOADPAGOPASARELAIDOPTIONS' Routine */
      returnInSub = false ;
      AV76TFPagoPasarelaId = AV53SearchTxt ;
      AV77TFPagoPasarelaId_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(10, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B12 */
      pr_default.execute(10, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(10) != 101) )
      {
         brk3B22 = false ;
         A21SGCitaDisponibilidadId = P003B12_A21SGCitaDisponibilidadId[0] ;
         A310PagoPasarelaId = P003B12_A310PagoPasarelaId[0] ;
         A34DisponibilidadId = P003B12_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B12_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B12_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B12_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B12_A245PagoNumero[0] ;
         A242PagoMonto = P003B12_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B12_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B12_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B12_A19CitaId[0] ;
         n19CitaId = P003B12_n19CitaId[0] ;
         A47PagoId = P003B12_A47PagoId[0] ;
         A246PagoEstadoR = P003B12_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B12_A339PagoEnlaceXML[0] ;
         A338PagoEnlacePDF = P003B12_A338PagoEnlacePDF[0] ;
         A309PagoResponse = P003B12_A309PagoResponse[0] ;
         A308PagoRequest = P003B12_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B12_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B12_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B12_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B12_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B12_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B12_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B12_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B12_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B12_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B12_A243PagoToken[0] ;
         A64CitaCode = P003B12_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B12_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B12_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B12_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B12_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(10) != 101) && ( GXutil.strcmp(P003B12_A310PagoPasarelaId[0], A310PagoPasarelaId) == 0 ) )
         {
            brk3B22 = false ;
            A47PagoId = P003B12_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B22 = true ;
            pr_default.readNext(10);
         }
         if ( ! (GXutil.strcmp("", A310PagoPasarelaId)==0) )
         {
            AV57Option = A310PagoPasarelaId ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B22 )
         {
            brk3B22 = true ;
            pr_default.readNext(10);
         }
      }
      pr_default.close(10);
   }

   public void S231( )
   {
      /* 'LOADPAGOENLACEPDFOPTIONS' Routine */
      returnInSub = false ;
      AV82TFPagoEnlacePDF = AV53SearchTxt ;
      AV83TFPagoEnlacePDF_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(11, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B13 */
      pr_default.execute(11, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(11) != 101) )
      {
         brk3B24 = false ;
         A21SGCitaDisponibilidadId = P003B13_A21SGCitaDisponibilidadId[0] ;
         A338PagoEnlacePDF = P003B13_A338PagoEnlacePDF[0] ;
         A34DisponibilidadId = P003B13_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B13_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B13_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B13_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B13_A245PagoNumero[0] ;
         A242PagoMonto = P003B13_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B13_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B13_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B13_A19CitaId[0] ;
         n19CitaId = P003B13_n19CitaId[0] ;
         A47PagoId = P003B13_A47PagoId[0] ;
         A246PagoEstadoR = P003B13_A246PagoEstadoR[0] ;
         A339PagoEnlaceXML = P003B13_A339PagoEnlaceXML[0] ;
         A310PagoPasarelaId = P003B13_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B13_A309PagoResponse[0] ;
         A308PagoRequest = P003B13_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B13_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B13_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B13_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B13_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B13_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B13_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B13_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B13_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B13_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B13_A243PagoToken[0] ;
         A64CitaCode = P003B13_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B13_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B13_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B13_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B13_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(11) != 101) && ( GXutil.strcmp(P003B13_A338PagoEnlacePDF[0], A338PagoEnlacePDF) == 0 ) )
         {
            brk3B24 = false ;
            A47PagoId = P003B13_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B24 = true ;
            pr_default.readNext(11);
         }
         if ( ! (GXutil.strcmp("", A338PagoEnlacePDF)==0) )
         {
            AV57Option = A338PagoEnlacePDF ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B24 )
         {
            brk3B24 = true ;
            pr_default.readNext(11);
         }
      }
      pr_default.close(11);
   }

   public void S241( )
   {
      /* 'LOADPAGOENLACEXMLOPTIONS' Routine */
      returnInSub = false ;
      AV84TFPagoEnlaceXML = AV53SearchTxt ;
      AV85TFPagoEnlaceXML_Sel = "" ;
      AV90Pagowwds_1_filterfulltext = AV71FilterFullText ;
      AV91Pagowwds_2_tfpagoid = AV11TFPagoId ;
      AV92Pagowwds_3_tfpagoid_to = AV12TFPagoId_To ;
      AV93Pagowwds_4_tfcitaid = AV13TFCitaId ;
      AV94Pagowwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV95Pagowwds_6_tfcitacode = AV15TFCitaCode ;
      AV96Pagowwds_7_tfcitacode_sel = AV16TFCitaCode_Sel ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = AV17TFSGCitaDisponibilidadFecha ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = AV18TFSGCitaDisponibilidadFecha_To ;
      AV99Pagowwds_10_tfpagomonto = AV19TFPagoMonto ;
      AV100Pagowwds_11_tfpagomonto_to = AV20TFPagoMonto_To ;
      AV101Pagowwds_12_tfpagotoken = AV21TFPagoToken ;
      AV102Pagowwds_13_tfpagotoken_sel = AV22TFPagoToken_Sel ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = AV24TFPagoTipoDocumentoCliente_Sels ;
      AV104Pagowwds_15_tfpagoclientenrodocumento = AV25TFPagoClienteNroDocumento ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = AV26TFPagoClienteNroDocumento_Sel ;
      AV106Pagowwds_17_tfpagoclientedenominacion = AV27TFPagoClienteDenominacion ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = AV28TFPagoClienteDenominacion_Sel ;
      AV108Pagowwds_19_tfpagoclientedireccion = AV29TFPagoClienteDireccion ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = AV30TFPagoClienteDireccion_Sel ;
      AV110Pagowwds_21_tfpagoclienteemail = AV31TFPagoClienteEmail ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = AV32TFPagoClienteEmail_Sel ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = AV34TFPagoTipoDocumento_Sels ;
      AV113Pagowwds_24_tfpagonumero = AV35TFPagoNumero ;
      AV114Pagowwds_25_tfpagonumero_to = AV36TFPagoNumero_To ;
      AV115Pagowwds_26_tfpagofechaemision = AV37TFPagoFechaEmision ;
      AV116Pagowwds_27_tfpagofechaemision_to = AV38TFPagoFechaEmision_To ;
      AV117Pagowwds_28_tfpagomoneda_sels = AV40TFPagoMoneda_Sels ;
      AV118Pagowwds_29_tfpagonubefactrequest = AV47TFPagoNubefactRequest ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = AV48TFPagoNubefactRequest_Sel ;
      AV120Pagowwds_31_tfpagonubefactresponse = AV49TFPagoNubefactResponse ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = AV50TFPagoNubefactResponse_Sel ;
      AV122Pagowwds_33_tfpagorequest = AV72TFPagoRequest ;
      AV123Pagowwds_34_tfpagorequest_sel = AV73TFPagoRequest_Sel ;
      AV124Pagowwds_35_tfpagoresponse = AV74TFPagoResponse ;
      AV125Pagowwds_36_tfpagoresponse_sel = AV75TFPagoResponse_Sel ;
      AV126Pagowwds_37_tfpagopasarelaid = AV76TFPagoPasarelaId ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = AV77TFPagoPasarelaId_Sel ;
      AV128Pagowwds_39_tfpagostatuscode = AV78TFPagoStatusCode ;
      AV129Pagowwds_40_tfpagostatuscode_to = AV79TFPagoStatusCode_To ;
      AV130Pagowwds_41_tfdisponibilidadid = AV80TFDisponibilidadId ;
      AV131Pagowwds_42_tfdisponibilidadid_to = AV81TFDisponibilidadId_To ;
      AV132Pagowwds_43_tfpagoenlacepdf = AV82TFPagoEnlacePDF ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = AV83TFPagoEnlacePDF_Sel ;
      AV134Pagowwds_45_tfpagoenlacexml = AV84TFPagoEnlaceXML ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = AV85TFPagoEnlaceXML_Sel ;
      AV136Pagowwds_47_tfpagoestador_sels = AV52TFPagoEstadoR_Sels ;
      pr_default.dynParam(12, new Object[]{ new Object[]{
                                           A247PagoTipoDocumentoCliente ,
                                           AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           Short.valueOf(A244PagoTipoDocumento) ,
                                           AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           Short.valueOf(A253PagoMoneda) ,
                                           AV117Pagowwds_28_tfpagomoneda_sels ,
                                           A246PagoEstadoR ,
                                           AV136Pagowwds_47_tfpagoestador_sels ,
                                           AV90Pagowwds_1_filterfulltext ,
                                           Integer.valueOf(AV91Pagowwds_2_tfpagoid) ,
                                           Integer.valueOf(AV92Pagowwds_3_tfpagoid_to) ,
                                           Integer.valueOf(AV93Pagowwds_4_tfcitaid) ,
                                           Integer.valueOf(AV94Pagowwds_5_tfcitaid_to) ,
                                           AV96Pagowwds_7_tfcitacode_sel ,
                                           AV95Pagowwds_6_tfcitacode ,
                                           AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           AV99Pagowwds_10_tfpagomonto ,
                                           AV100Pagowwds_11_tfpagomonto_to ,
                                           AV102Pagowwds_13_tfpagotoken_sel ,
                                           AV101Pagowwds_12_tfpagotoken ,
                                           Integer.valueOf(AV103Pagowwds_14_tfpagotipodocumentocliente_sels.size()) ,
                                           AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           AV108Pagowwds_19_tfpagoclientedireccion ,
                                           AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           AV110Pagowwds_21_tfpagoclienteemail ,
                                           Integer.valueOf(AV112Pagowwds_23_tfpagotipodocumento_sels.size()) ,
                                           Integer.valueOf(AV113Pagowwds_24_tfpagonumero) ,
                                           Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to) ,
                                           AV115Pagowwds_26_tfpagofechaemision ,
                                           AV116Pagowwds_27_tfpagofechaemision_to ,
                                           Integer.valueOf(AV117Pagowwds_28_tfpagomoneda_sels.size()) ,
                                           AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           AV118Pagowwds_29_tfpagonubefactrequest ,
                                           AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           AV120Pagowwds_31_tfpagonubefactresponse ,
                                           AV123Pagowwds_34_tfpagorequest_sel ,
                                           AV122Pagowwds_33_tfpagorequest ,
                                           AV125Pagowwds_36_tfpagoresponse_sel ,
                                           AV124Pagowwds_35_tfpagoresponse ,
                                           AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           AV126Pagowwds_37_tfpagopasarelaid ,
                                           Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode) ,
                                           Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to) ,
                                           Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid) ,
                                           Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to) ,
                                           AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           AV132Pagowwds_43_tfpagoenlacepdf ,
                                           AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           AV134Pagowwds_45_tfpagoenlacexml ,
                                           Integer.valueOf(AV136Pagowwds_47_tfpagoestador_sels.size()) ,
                                           Integer.valueOf(A47PagoId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           A64CitaCode ,
                                           A242PagoMonto ,
                                           A243PagoToken ,
                                           A248PagoClienteNroDocumento ,
                                           A249PagoClienteDenominacion ,
                                           A250PagoClienteDireccion ,
                                           A251PagoClienteEmail ,
                                           Integer.valueOf(A245PagoNumero) ,
                                           A256PagoNubefactRequest ,
                                           A257PagoNubefactResponse ,
                                           A308PagoRequest ,
                                           A309PagoResponse ,
                                           A310PagoPasarelaId ,
                                           Integer.valueOf(A311PagoStatusCode) ,
                                           Integer.valueOf(A34DisponibilidadId) ,
                                           A338PagoEnlacePDF ,
                                           A339PagoEnlaceXML ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A252PagoFechaEmision } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV90Pagowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV90Pagowwds_1_filterfulltext), "%", "") ;
      lV95Pagowwds_6_tfcitacode = GXutil.concat( GXutil.rtrim( AV95Pagowwds_6_tfcitacode), "%", "") ;
      lV101Pagowwds_12_tfpagotoken = GXutil.concat( GXutil.rtrim( AV101Pagowwds_12_tfpagotoken), "%", "") ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = GXutil.concat( GXutil.rtrim( AV104Pagowwds_15_tfpagoclientenrodocumento), "%", "") ;
      lV106Pagowwds_17_tfpagoclientedenominacion = GXutil.concat( GXutil.rtrim( AV106Pagowwds_17_tfpagoclientedenominacion), "%", "") ;
      lV108Pagowwds_19_tfpagoclientedireccion = GXutil.concat( GXutil.rtrim( AV108Pagowwds_19_tfpagoclientedireccion), "%", "") ;
      lV110Pagowwds_21_tfpagoclienteemail = GXutil.concat( GXutil.rtrim( AV110Pagowwds_21_tfpagoclienteemail), "%", "") ;
      lV118Pagowwds_29_tfpagonubefactrequest = GXutil.concat( GXutil.rtrim( AV118Pagowwds_29_tfpagonubefactrequest), "%", "") ;
      lV120Pagowwds_31_tfpagonubefactresponse = GXutil.concat( GXutil.rtrim( AV120Pagowwds_31_tfpagonubefactresponse), "%", "") ;
      lV122Pagowwds_33_tfpagorequest = GXutil.concat( GXutil.rtrim( AV122Pagowwds_33_tfpagorequest), "%", "") ;
      lV124Pagowwds_35_tfpagoresponse = GXutil.concat( GXutil.rtrim( AV124Pagowwds_35_tfpagoresponse), "%", "") ;
      lV126Pagowwds_37_tfpagopasarelaid = GXutil.concat( GXutil.rtrim( AV126Pagowwds_37_tfpagopasarelaid), "%", "") ;
      lV132Pagowwds_43_tfpagoenlacepdf = GXutil.concat( GXutil.rtrim( AV132Pagowwds_43_tfpagoenlacepdf), "%", "") ;
      lV134Pagowwds_45_tfpagoenlacexml = GXutil.concat( GXutil.rtrim( AV134Pagowwds_45_tfpagoenlacexml), "%", "") ;
      /* Using cursor P003B14 */
      pr_default.execute(12, new Object[] {lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, lV90Pagowwds_1_filterfulltext, Integer.valueOf(AV91Pagowwds_2_tfpagoid), Integer.valueOf(AV92Pagowwds_3_tfpagoid_to), Integer.valueOf(AV93Pagowwds_4_tfcitaid), Integer.valueOf(AV94Pagowwds_5_tfcitaid_to), lV95Pagowwds_6_tfcitacode, AV96Pagowwds_7_tfcitacode_sel, AV97Pagowwds_8_tfsgcitadisponibilidadfecha, AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to, AV99Pagowwds_10_tfpagomonto, AV100Pagowwds_11_tfpagomonto_to, lV101Pagowwds_12_tfpagotoken, AV102Pagowwds_13_tfpagotoken_sel, lV104Pagowwds_15_tfpagoclientenrodocumento, AV105Pagowwds_16_tfpagoclientenrodocumento_sel, lV106Pagowwds_17_tfpagoclientedenominacion, AV107Pagowwds_18_tfpagoclientedenominacion_sel, lV108Pagowwds_19_tfpagoclientedireccion, AV109Pagowwds_20_tfpagoclientedireccion_sel, lV110Pagowwds_21_tfpagoclienteemail, AV111Pagowwds_22_tfpagoclienteemail_sel, Integer.valueOf(AV113Pagowwds_24_tfpagonumero), Integer.valueOf(AV114Pagowwds_25_tfpagonumero_to), AV115Pagowwds_26_tfpagofechaemision, AV116Pagowwds_27_tfpagofechaemision_to, lV118Pagowwds_29_tfpagonubefactrequest, AV119Pagowwds_30_tfpagonubefactrequest_sel, lV120Pagowwds_31_tfpagonubefactresponse, AV121Pagowwds_32_tfpagonubefactresponse_sel, lV122Pagowwds_33_tfpagorequest, AV123Pagowwds_34_tfpagorequest_sel, lV124Pagowwds_35_tfpagoresponse, AV125Pagowwds_36_tfpagoresponse_sel, lV126Pagowwds_37_tfpagopasarelaid, AV127Pagowwds_38_tfpagopasarelaid_sel, Integer.valueOf(AV128Pagowwds_39_tfpagostatuscode), Integer.valueOf(AV129Pagowwds_40_tfpagostatuscode_to), Integer.valueOf(AV130Pagowwds_41_tfdisponibilidadid), Integer.valueOf(AV131Pagowwds_42_tfdisponibilidadid_to), lV132Pagowwds_43_tfpagoenlacepdf, AV133Pagowwds_44_tfpagoenlacepdf_sel, lV134Pagowwds_45_tfpagoenlacexml, AV135Pagowwds_46_tfpagoenlacexml_sel});
      while ( (pr_default.getStatus(12) != 101) )
      {
         brk3B26 = false ;
         A21SGCitaDisponibilidadId = P003B14_A21SGCitaDisponibilidadId[0] ;
         A339PagoEnlaceXML = P003B14_A339PagoEnlaceXML[0] ;
         A34DisponibilidadId = P003B14_A34DisponibilidadId[0] ;
         n34DisponibilidadId = P003B14_n34DisponibilidadId[0] ;
         A311PagoStatusCode = P003B14_A311PagoStatusCode[0] ;
         A252PagoFechaEmision = P003B14_A252PagoFechaEmision[0] ;
         A245PagoNumero = P003B14_A245PagoNumero[0] ;
         A242PagoMonto = P003B14_A242PagoMonto[0] ;
         A66SGCitaDisponibilidadFecha = P003B14_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B14_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003B14_A19CitaId[0] ;
         n19CitaId = P003B14_n19CitaId[0] ;
         A47PagoId = P003B14_A47PagoId[0] ;
         A246PagoEstadoR = P003B14_A246PagoEstadoR[0] ;
         A338PagoEnlacePDF = P003B14_A338PagoEnlacePDF[0] ;
         A310PagoPasarelaId = P003B14_A310PagoPasarelaId[0] ;
         A309PagoResponse = P003B14_A309PagoResponse[0] ;
         A308PagoRequest = P003B14_A308PagoRequest[0] ;
         A257PagoNubefactResponse = P003B14_A257PagoNubefactResponse[0] ;
         A256PagoNubefactRequest = P003B14_A256PagoNubefactRequest[0] ;
         A253PagoMoneda = P003B14_A253PagoMoneda[0] ;
         A244PagoTipoDocumento = P003B14_A244PagoTipoDocumento[0] ;
         A251PagoClienteEmail = P003B14_A251PagoClienteEmail[0] ;
         A250PagoClienteDireccion = P003B14_A250PagoClienteDireccion[0] ;
         A249PagoClienteDenominacion = P003B14_A249PagoClienteDenominacion[0] ;
         A248PagoClienteNroDocumento = P003B14_A248PagoClienteNroDocumento[0] ;
         A247PagoTipoDocumentoCliente = P003B14_A247PagoTipoDocumentoCliente[0] ;
         A243PagoToken = P003B14_A243PagoToken[0] ;
         A64CitaCode = P003B14_A64CitaCode[0] ;
         A21SGCitaDisponibilidadId = P003B14_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = P003B14_A64CitaCode[0] ;
         A66SGCitaDisponibilidadFecha = P003B14_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003B14_n66SGCitaDisponibilidadFecha[0] ;
         AV65count = 0 ;
         while ( (pr_default.getStatus(12) != 101) && ( GXutil.strcmp(P003B14_A339PagoEnlaceXML[0], A339PagoEnlaceXML) == 0 ) )
         {
            brk3B26 = false ;
            A47PagoId = P003B14_A47PagoId[0] ;
            AV65count = (long)(AV65count+1) ;
            brk3B26 = true ;
            pr_default.readNext(12);
         }
         if ( ! (GXutil.strcmp("", A339PagoEnlaceXML)==0) )
         {
            AV57Option = A339PagoEnlaceXML ;
            AV58Options.add(AV57Option, 0);
            AV63OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV65count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3B26 )
         {
            brk3B26 = true ;
            pr_default.readNext(12);
         }
      }
      pr_default.close(12);
   }

   protected void cleanup( )
   {
      this.aP3[0] = pagowwgetfilterdata.this.AV59OptionsJson;
      this.aP4[0] = pagowwgetfilterdata.this.AV62OptionsDescJson;
      this.aP5[0] = pagowwgetfilterdata.this.AV64OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV59OptionsJson = "" ;
      AV62OptionsDescJson = "" ;
      AV64OptionIndexesJson = "" ;
      AV58Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV66Session = httpContext.getWebSession();
      AV68GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV69GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV71FilterFullText = "" ;
      AV15TFCitaCode = "" ;
      AV16TFCitaCode_Sel = "" ;
      AV17TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV18TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV19TFPagoMonto = DecimalUtil.ZERO ;
      AV20TFPagoMonto_To = DecimalUtil.ZERO ;
      AV21TFPagoToken = "" ;
      AV22TFPagoToken_Sel = "" ;
      AV23TFPagoTipoDocumentoCliente_SelsJson = "" ;
      AV24TFPagoTipoDocumentoCliente_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFPagoClienteNroDocumento = "" ;
      AV26TFPagoClienteNroDocumento_Sel = "" ;
      AV27TFPagoClienteDenominacion = "" ;
      AV28TFPagoClienteDenominacion_Sel = "" ;
      AV29TFPagoClienteDireccion = "" ;
      AV30TFPagoClienteDireccion_Sel = "" ;
      AV31TFPagoClienteEmail = "" ;
      AV32TFPagoClienteEmail_Sel = "" ;
      AV33TFPagoTipoDocumento_SelsJson = "" ;
      AV34TFPagoTipoDocumento_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV37TFPagoFechaEmision = GXutil.nullDate() ;
      AV38TFPagoFechaEmision_To = GXutil.nullDate() ;
      AV39TFPagoMoneda_SelsJson = "" ;
      AV40TFPagoMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV47TFPagoNubefactRequest = "" ;
      AV48TFPagoNubefactRequest_Sel = "" ;
      AV49TFPagoNubefactResponse = "" ;
      AV50TFPagoNubefactResponse_Sel = "" ;
      AV72TFPagoRequest = "" ;
      AV73TFPagoRequest_Sel = "" ;
      AV74TFPagoResponse = "" ;
      AV75TFPagoResponse_Sel = "" ;
      AV76TFPagoPasarelaId = "" ;
      AV77TFPagoPasarelaId_Sel = "" ;
      AV82TFPagoEnlacePDF = "" ;
      AV83TFPagoEnlacePDF_Sel = "" ;
      AV84TFPagoEnlaceXML = "" ;
      AV85TFPagoEnlaceXML_Sel = "" ;
      AV51TFPagoEstadoR_SelsJson = "" ;
      AV52TFPagoEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A64CitaCode = "" ;
      AV90Pagowwds_1_filterfulltext = "" ;
      AV95Pagowwds_6_tfcitacode = "" ;
      AV96Pagowwds_7_tfcitacode_sel = "" ;
      AV97Pagowwds_8_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV99Pagowwds_10_tfpagomonto = DecimalUtil.ZERO ;
      AV100Pagowwds_11_tfpagomonto_to = DecimalUtil.ZERO ;
      AV101Pagowwds_12_tfpagotoken = "" ;
      AV102Pagowwds_13_tfpagotoken_sel = "" ;
      AV103Pagowwds_14_tfpagotipodocumentocliente_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104Pagowwds_15_tfpagoclientenrodocumento = "" ;
      AV105Pagowwds_16_tfpagoclientenrodocumento_sel = "" ;
      AV106Pagowwds_17_tfpagoclientedenominacion = "" ;
      AV107Pagowwds_18_tfpagoclientedenominacion_sel = "" ;
      AV108Pagowwds_19_tfpagoclientedireccion = "" ;
      AV109Pagowwds_20_tfpagoclientedireccion_sel = "" ;
      AV110Pagowwds_21_tfpagoclienteemail = "" ;
      AV111Pagowwds_22_tfpagoclienteemail_sel = "" ;
      AV112Pagowwds_23_tfpagotipodocumento_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV115Pagowwds_26_tfpagofechaemision = GXutil.nullDate() ;
      AV116Pagowwds_27_tfpagofechaemision_to = GXutil.nullDate() ;
      AV117Pagowwds_28_tfpagomoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV118Pagowwds_29_tfpagonubefactrequest = "" ;
      AV119Pagowwds_30_tfpagonubefactrequest_sel = "" ;
      AV120Pagowwds_31_tfpagonubefactresponse = "" ;
      AV121Pagowwds_32_tfpagonubefactresponse_sel = "" ;
      AV122Pagowwds_33_tfpagorequest = "" ;
      AV123Pagowwds_34_tfpagorequest_sel = "" ;
      AV124Pagowwds_35_tfpagoresponse = "" ;
      AV125Pagowwds_36_tfpagoresponse_sel = "" ;
      AV126Pagowwds_37_tfpagopasarelaid = "" ;
      AV127Pagowwds_38_tfpagopasarelaid_sel = "" ;
      AV132Pagowwds_43_tfpagoenlacepdf = "" ;
      AV133Pagowwds_44_tfpagoenlacepdf_sel = "" ;
      AV134Pagowwds_45_tfpagoenlacexml = "" ;
      AV135Pagowwds_46_tfpagoenlacexml_sel = "" ;
      AV136Pagowwds_47_tfpagoestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV90Pagowwds_1_filterfulltext = "" ;
      lV95Pagowwds_6_tfcitacode = "" ;
      lV101Pagowwds_12_tfpagotoken = "" ;
      lV104Pagowwds_15_tfpagoclientenrodocumento = "" ;
      lV106Pagowwds_17_tfpagoclientedenominacion = "" ;
      lV108Pagowwds_19_tfpagoclientedireccion = "" ;
      lV110Pagowwds_21_tfpagoclienteemail = "" ;
      lV118Pagowwds_29_tfpagonubefactrequest = "" ;
      lV120Pagowwds_31_tfpagonubefactresponse = "" ;
      lV122Pagowwds_33_tfpagorequest = "" ;
      lV124Pagowwds_35_tfpagoresponse = "" ;
      lV126Pagowwds_37_tfpagopasarelaid = "" ;
      lV132Pagowwds_43_tfpagoenlacepdf = "" ;
      lV134Pagowwds_45_tfpagoenlacexml = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A246PagoEstadoR = "" ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A243PagoToken = "" ;
      A248PagoClienteNroDocumento = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A310PagoPasarelaId = "" ;
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      P003B2_A21SGCitaDisponibilidadId = new int[1] ;
      P003B2_A19CitaId = new int[1] ;
      P003B2_n19CitaId = new boolean[] {false} ;
      P003B2_A34DisponibilidadId = new int[1] ;
      P003B2_n34DisponibilidadId = new boolean[] {false} ;
      P003B2_A311PagoStatusCode = new int[1] ;
      P003B2_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B2_A245PagoNumero = new int[1] ;
      P003B2_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B2_A47PagoId = new int[1] ;
      P003B2_A246PagoEstadoR = new String[] {""} ;
      P003B2_A339PagoEnlaceXML = new String[] {""} ;
      P003B2_A338PagoEnlacePDF = new String[] {""} ;
      P003B2_A310PagoPasarelaId = new String[] {""} ;
      P003B2_A309PagoResponse = new String[] {""} ;
      P003B2_A308PagoRequest = new String[] {""} ;
      P003B2_A257PagoNubefactResponse = new String[] {""} ;
      P003B2_A256PagoNubefactRequest = new String[] {""} ;
      P003B2_A253PagoMoneda = new short[1] ;
      P003B2_A244PagoTipoDocumento = new short[1] ;
      P003B2_A251PagoClienteEmail = new String[] {""} ;
      P003B2_A250PagoClienteDireccion = new String[] {""} ;
      P003B2_A249PagoClienteDenominacion = new String[] {""} ;
      P003B2_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B2_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B2_A243PagoToken = new String[] {""} ;
      P003B2_A64CitaCode = new String[] {""} ;
      AV57Option = "" ;
      P003B3_A21SGCitaDisponibilidadId = new int[1] ;
      P003B3_A243PagoToken = new String[] {""} ;
      P003B3_A34DisponibilidadId = new int[1] ;
      P003B3_n34DisponibilidadId = new boolean[] {false} ;
      P003B3_A311PagoStatusCode = new int[1] ;
      P003B3_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B3_A245PagoNumero = new int[1] ;
      P003B3_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B3_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B3_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B3_A19CitaId = new int[1] ;
      P003B3_n19CitaId = new boolean[] {false} ;
      P003B3_A47PagoId = new int[1] ;
      P003B3_A246PagoEstadoR = new String[] {""} ;
      P003B3_A339PagoEnlaceXML = new String[] {""} ;
      P003B3_A338PagoEnlacePDF = new String[] {""} ;
      P003B3_A310PagoPasarelaId = new String[] {""} ;
      P003B3_A309PagoResponse = new String[] {""} ;
      P003B3_A308PagoRequest = new String[] {""} ;
      P003B3_A257PagoNubefactResponse = new String[] {""} ;
      P003B3_A256PagoNubefactRequest = new String[] {""} ;
      P003B3_A253PagoMoneda = new short[1] ;
      P003B3_A244PagoTipoDocumento = new short[1] ;
      P003B3_A251PagoClienteEmail = new String[] {""} ;
      P003B3_A250PagoClienteDireccion = new String[] {""} ;
      P003B3_A249PagoClienteDenominacion = new String[] {""} ;
      P003B3_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B3_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B3_A64CitaCode = new String[] {""} ;
      P003B4_A21SGCitaDisponibilidadId = new int[1] ;
      P003B4_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B4_A34DisponibilidadId = new int[1] ;
      P003B4_n34DisponibilidadId = new boolean[] {false} ;
      P003B4_A311PagoStatusCode = new int[1] ;
      P003B4_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B4_A245PagoNumero = new int[1] ;
      P003B4_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B4_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B4_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B4_A19CitaId = new int[1] ;
      P003B4_n19CitaId = new boolean[] {false} ;
      P003B4_A47PagoId = new int[1] ;
      P003B4_A246PagoEstadoR = new String[] {""} ;
      P003B4_A339PagoEnlaceXML = new String[] {""} ;
      P003B4_A338PagoEnlacePDF = new String[] {""} ;
      P003B4_A310PagoPasarelaId = new String[] {""} ;
      P003B4_A309PagoResponse = new String[] {""} ;
      P003B4_A308PagoRequest = new String[] {""} ;
      P003B4_A257PagoNubefactResponse = new String[] {""} ;
      P003B4_A256PagoNubefactRequest = new String[] {""} ;
      P003B4_A253PagoMoneda = new short[1] ;
      P003B4_A244PagoTipoDocumento = new short[1] ;
      P003B4_A251PagoClienteEmail = new String[] {""} ;
      P003B4_A250PagoClienteDireccion = new String[] {""} ;
      P003B4_A249PagoClienteDenominacion = new String[] {""} ;
      P003B4_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B4_A243PagoToken = new String[] {""} ;
      P003B4_A64CitaCode = new String[] {""} ;
      P003B5_A21SGCitaDisponibilidadId = new int[1] ;
      P003B5_A249PagoClienteDenominacion = new String[] {""} ;
      P003B5_A34DisponibilidadId = new int[1] ;
      P003B5_n34DisponibilidadId = new boolean[] {false} ;
      P003B5_A311PagoStatusCode = new int[1] ;
      P003B5_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B5_A245PagoNumero = new int[1] ;
      P003B5_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B5_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B5_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B5_A19CitaId = new int[1] ;
      P003B5_n19CitaId = new boolean[] {false} ;
      P003B5_A47PagoId = new int[1] ;
      P003B5_A246PagoEstadoR = new String[] {""} ;
      P003B5_A339PagoEnlaceXML = new String[] {""} ;
      P003B5_A338PagoEnlacePDF = new String[] {""} ;
      P003B5_A310PagoPasarelaId = new String[] {""} ;
      P003B5_A309PagoResponse = new String[] {""} ;
      P003B5_A308PagoRequest = new String[] {""} ;
      P003B5_A257PagoNubefactResponse = new String[] {""} ;
      P003B5_A256PagoNubefactRequest = new String[] {""} ;
      P003B5_A253PagoMoneda = new short[1] ;
      P003B5_A244PagoTipoDocumento = new short[1] ;
      P003B5_A251PagoClienteEmail = new String[] {""} ;
      P003B5_A250PagoClienteDireccion = new String[] {""} ;
      P003B5_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B5_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B5_A243PagoToken = new String[] {""} ;
      P003B5_A64CitaCode = new String[] {""} ;
      P003B6_A21SGCitaDisponibilidadId = new int[1] ;
      P003B6_A250PagoClienteDireccion = new String[] {""} ;
      P003B6_A34DisponibilidadId = new int[1] ;
      P003B6_n34DisponibilidadId = new boolean[] {false} ;
      P003B6_A311PagoStatusCode = new int[1] ;
      P003B6_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B6_A245PagoNumero = new int[1] ;
      P003B6_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B6_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B6_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B6_A19CitaId = new int[1] ;
      P003B6_n19CitaId = new boolean[] {false} ;
      P003B6_A47PagoId = new int[1] ;
      P003B6_A246PagoEstadoR = new String[] {""} ;
      P003B6_A339PagoEnlaceXML = new String[] {""} ;
      P003B6_A338PagoEnlacePDF = new String[] {""} ;
      P003B6_A310PagoPasarelaId = new String[] {""} ;
      P003B6_A309PagoResponse = new String[] {""} ;
      P003B6_A308PagoRequest = new String[] {""} ;
      P003B6_A257PagoNubefactResponse = new String[] {""} ;
      P003B6_A256PagoNubefactRequest = new String[] {""} ;
      P003B6_A253PagoMoneda = new short[1] ;
      P003B6_A244PagoTipoDocumento = new short[1] ;
      P003B6_A251PagoClienteEmail = new String[] {""} ;
      P003B6_A249PagoClienteDenominacion = new String[] {""} ;
      P003B6_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B6_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B6_A243PagoToken = new String[] {""} ;
      P003B6_A64CitaCode = new String[] {""} ;
      P003B7_A21SGCitaDisponibilidadId = new int[1] ;
      P003B7_A251PagoClienteEmail = new String[] {""} ;
      P003B7_A34DisponibilidadId = new int[1] ;
      P003B7_n34DisponibilidadId = new boolean[] {false} ;
      P003B7_A311PagoStatusCode = new int[1] ;
      P003B7_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B7_A245PagoNumero = new int[1] ;
      P003B7_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B7_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B7_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B7_A19CitaId = new int[1] ;
      P003B7_n19CitaId = new boolean[] {false} ;
      P003B7_A47PagoId = new int[1] ;
      P003B7_A246PagoEstadoR = new String[] {""} ;
      P003B7_A339PagoEnlaceXML = new String[] {""} ;
      P003B7_A338PagoEnlacePDF = new String[] {""} ;
      P003B7_A310PagoPasarelaId = new String[] {""} ;
      P003B7_A309PagoResponse = new String[] {""} ;
      P003B7_A308PagoRequest = new String[] {""} ;
      P003B7_A257PagoNubefactResponse = new String[] {""} ;
      P003B7_A256PagoNubefactRequest = new String[] {""} ;
      P003B7_A253PagoMoneda = new short[1] ;
      P003B7_A244PagoTipoDocumento = new short[1] ;
      P003B7_A250PagoClienteDireccion = new String[] {""} ;
      P003B7_A249PagoClienteDenominacion = new String[] {""} ;
      P003B7_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B7_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B7_A243PagoToken = new String[] {""} ;
      P003B7_A64CitaCode = new String[] {""} ;
      P003B8_A21SGCitaDisponibilidadId = new int[1] ;
      P003B8_A256PagoNubefactRequest = new String[] {""} ;
      P003B8_A34DisponibilidadId = new int[1] ;
      P003B8_n34DisponibilidadId = new boolean[] {false} ;
      P003B8_A311PagoStatusCode = new int[1] ;
      P003B8_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B8_A245PagoNumero = new int[1] ;
      P003B8_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B8_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B8_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B8_A19CitaId = new int[1] ;
      P003B8_n19CitaId = new boolean[] {false} ;
      P003B8_A47PagoId = new int[1] ;
      P003B8_A246PagoEstadoR = new String[] {""} ;
      P003B8_A339PagoEnlaceXML = new String[] {""} ;
      P003B8_A338PagoEnlacePDF = new String[] {""} ;
      P003B8_A310PagoPasarelaId = new String[] {""} ;
      P003B8_A309PagoResponse = new String[] {""} ;
      P003B8_A308PagoRequest = new String[] {""} ;
      P003B8_A257PagoNubefactResponse = new String[] {""} ;
      P003B8_A253PagoMoneda = new short[1] ;
      P003B8_A244PagoTipoDocumento = new short[1] ;
      P003B8_A251PagoClienteEmail = new String[] {""} ;
      P003B8_A250PagoClienteDireccion = new String[] {""} ;
      P003B8_A249PagoClienteDenominacion = new String[] {""} ;
      P003B8_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B8_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B8_A243PagoToken = new String[] {""} ;
      P003B8_A64CitaCode = new String[] {""} ;
      P003B9_A21SGCitaDisponibilidadId = new int[1] ;
      P003B9_A257PagoNubefactResponse = new String[] {""} ;
      P003B9_A34DisponibilidadId = new int[1] ;
      P003B9_n34DisponibilidadId = new boolean[] {false} ;
      P003B9_A311PagoStatusCode = new int[1] ;
      P003B9_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B9_A245PagoNumero = new int[1] ;
      P003B9_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B9_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B9_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B9_A19CitaId = new int[1] ;
      P003B9_n19CitaId = new boolean[] {false} ;
      P003B9_A47PagoId = new int[1] ;
      P003B9_A246PagoEstadoR = new String[] {""} ;
      P003B9_A339PagoEnlaceXML = new String[] {""} ;
      P003B9_A338PagoEnlacePDF = new String[] {""} ;
      P003B9_A310PagoPasarelaId = new String[] {""} ;
      P003B9_A309PagoResponse = new String[] {""} ;
      P003B9_A308PagoRequest = new String[] {""} ;
      P003B9_A256PagoNubefactRequest = new String[] {""} ;
      P003B9_A253PagoMoneda = new short[1] ;
      P003B9_A244PagoTipoDocumento = new short[1] ;
      P003B9_A251PagoClienteEmail = new String[] {""} ;
      P003B9_A250PagoClienteDireccion = new String[] {""} ;
      P003B9_A249PagoClienteDenominacion = new String[] {""} ;
      P003B9_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B9_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B9_A243PagoToken = new String[] {""} ;
      P003B9_A64CitaCode = new String[] {""} ;
      P003B10_A21SGCitaDisponibilidadId = new int[1] ;
      P003B10_A308PagoRequest = new String[] {""} ;
      P003B10_A34DisponibilidadId = new int[1] ;
      P003B10_n34DisponibilidadId = new boolean[] {false} ;
      P003B10_A311PagoStatusCode = new int[1] ;
      P003B10_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B10_A245PagoNumero = new int[1] ;
      P003B10_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B10_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B10_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B10_A19CitaId = new int[1] ;
      P003B10_n19CitaId = new boolean[] {false} ;
      P003B10_A47PagoId = new int[1] ;
      P003B10_A246PagoEstadoR = new String[] {""} ;
      P003B10_A339PagoEnlaceXML = new String[] {""} ;
      P003B10_A338PagoEnlacePDF = new String[] {""} ;
      P003B10_A310PagoPasarelaId = new String[] {""} ;
      P003B10_A309PagoResponse = new String[] {""} ;
      P003B10_A257PagoNubefactResponse = new String[] {""} ;
      P003B10_A256PagoNubefactRequest = new String[] {""} ;
      P003B10_A253PagoMoneda = new short[1] ;
      P003B10_A244PagoTipoDocumento = new short[1] ;
      P003B10_A251PagoClienteEmail = new String[] {""} ;
      P003B10_A250PagoClienteDireccion = new String[] {""} ;
      P003B10_A249PagoClienteDenominacion = new String[] {""} ;
      P003B10_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B10_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B10_A243PagoToken = new String[] {""} ;
      P003B10_A64CitaCode = new String[] {""} ;
      P003B11_A21SGCitaDisponibilidadId = new int[1] ;
      P003B11_A309PagoResponse = new String[] {""} ;
      P003B11_A34DisponibilidadId = new int[1] ;
      P003B11_n34DisponibilidadId = new boolean[] {false} ;
      P003B11_A311PagoStatusCode = new int[1] ;
      P003B11_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B11_A245PagoNumero = new int[1] ;
      P003B11_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B11_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B11_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B11_A19CitaId = new int[1] ;
      P003B11_n19CitaId = new boolean[] {false} ;
      P003B11_A47PagoId = new int[1] ;
      P003B11_A246PagoEstadoR = new String[] {""} ;
      P003B11_A339PagoEnlaceXML = new String[] {""} ;
      P003B11_A338PagoEnlacePDF = new String[] {""} ;
      P003B11_A310PagoPasarelaId = new String[] {""} ;
      P003B11_A308PagoRequest = new String[] {""} ;
      P003B11_A257PagoNubefactResponse = new String[] {""} ;
      P003B11_A256PagoNubefactRequest = new String[] {""} ;
      P003B11_A253PagoMoneda = new short[1] ;
      P003B11_A244PagoTipoDocumento = new short[1] ;
      P003B11_A251PagoClienteEmail = new String[] {""} ;
      P003B11_A250PagoClienteDireccion = new String[] {""} ;
      P003B11_A249PagoClienteDenominacion = new String[] {""} ;
      P003B11_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B11_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B11_A243PagoToken = new String[] {""} ;
      P003B11_A64CitaCode = new String[] {""} ;
      P003B12_A21SGCitaDisponibilidadId = new int[1] ;
      P003B12_A310PagoPasarelaId = new String[] {""} ;
      P003B12_A34DisponibilidadId = new int[1] ;
      P003B12_n34DisponibilidadId = new boolean[] {false} ;
      P003B12_A311PagoStatusCode = new int[1] ;
      P003B12_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B12_A245PagoNumero = new int[1] ;
      P003B12_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B12_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B12_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B12_A19CitaId = new int[1] ;
      P003B12_n19CitaId = new boolean[] {false} ;
      P003B12_A47PagoId = new int[1] ;
      P003B12_A246PagoEstadoR = new String[] {""} ;
      P003B12_A339PagoEnlaceXML = new String[] {""} ;
      P003B12_A338PagoEnlacePDF = new String[] {""} ;
      P003B12_A309PagoResponse = new String[] {""} ;
      P003B12_A308PagoRequest = new String[] {""} ;
      P003B12_A257PagoNubefactResponse = new String[] {""} ;
      P003B12_A256PagoNubefactRequest = new String[] {""} ;
      P003B12_A253PagoMoneda = new short[1] ;
      P003B12_A244PagoTipoDocumento = new short[1] ;
      P003B12_A251PagoClienteEmail = new String[] {""} ;
      P003B12_A250PagoClienteDireccion = new String[] {""} ;
      P003B12_A249PagoClienteDenominacion = new String[] {""} ;
      P003B12_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B12_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B12_A243PagoToken = new String[] {""} ;
      P003B12_A64CitaCode = new String[] {""} ;
      P003B13_A21SGCitaDisponibilidadId = new int[1] ;
      P003B13_A338PagoEnlacePDF = new String[] {""} ;
      P003B13_A34DisponibilidadId = new int[1] ;
      P003B13_n34DisponibilidadId = new boolean[] {false} ;
      P003B13_A311PagoStatusCode = new int[1] ;
      P003B13_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B13_A245PagoNumero = new int[1] ;
      P003B13_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B13_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B13_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B13_A19CitaId = new int[1] ;
      P003B13_n19CitaId = new boolean[] {false} ;
      P003B13_A47PagoId = new int[1] ;
      P003B13_A246PagoEstadoR = new String[] {""} ;
      P003B13_A339PagoEnlaceXML = new String[] {""} ;
      P003B13_A310PagoPasarelaId = new String[] {""} ;
      P003B13_A309PagoResponse = new String[] {""} ;
      P003B13_A308PagoRequest = new String[] {""} ;
      P003B13_A257PagoNubefactResponse = new String[] {""} ;
      P003B13_A256PagoNubefactRequest = new String[] {""} ;
      P003B13_A253PagoMoneda = new short[1] ;
      P003B13_A244PagoTipoDocumento = new short[1] ;
      P003B13_A251PagoClienteEmail = new String[] {""} ;
      P003B13_A250PagoClienteDireccion = new String[] {""} ;
      P003B13_A249PagoClienteDenominacion = new String[] {""} ;
      P003B13_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B13_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B13_A243PagoToken = new String[] {""} ;
      P003B13_A64CitaCode = new String[] {""} ;
      P003B14_A21SGCitaDisponibilidadId = new int[1] ;
      P003B14_A339PagoEnlaceXML = new String[] {""} ;
      P003B14_A34DisponibilidadId = new int[1] ;
      P003B14_n34DisponibilidadId = new boolean[] {false} ;
      P003B14_A311PagoStatusCode = new int[1] ;
      P003B14_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      P003B14_A245PagoNumero = new int[1] ;
      P003B14_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003B14_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003B14_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003B14_A19CitaId = new int[1] ;
      P003B14_n19CitaId = new boolean[] {false} ;
      P003B14_A47PagoId = new int[1] ;
      P003B14_A246PagoEstadoR = new String[] {""} ;
      P003B14_A338PagoEnlacePDF = new String[] {""} ;
      P003B14_A310PagoPasarelaId = new String[] {""} ;
      P003B14_A309PagoResponse = new String[] {""} ;
      P003B14_A308PagoRequest = new String[] {""} ;
      P003B14_A257PagoNubefactResponse = new String[] {""} ;
      P003B14_A256PagoNubefactRequest = new String[] {""} ;
      P003B14_A253PagoMoneda = new short[1] ;
      P003B14_A244PagoTipoDocumento = new short[1] ;
      P003B14_A251PagoClienteEmail = new String[] {""} ;
      P003B14_A250PagoClienteDireccion = new String[] {""} ;
      P003B14_A249PagoClienteDenominacion = new String[] {""} ;
      P003B14_A248PagoClienteNroDocumento = new String[] {""} ;
      P003B14_A247PagoTipoDocumentoCliente = new String[] {""} ;
      P003B14_A243PagoToken = new String[] {""} ;
      P003B14_A64CitaCode = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pagowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003B2_A21SGCitaDisponibilidadId, P003B2_A19CitaId, P003B2_n19CitaId, P003B2_A34DisponibilidadId, P003B2_n34DisponibilidadId, P003B2_A311PagoStatusCode, P003B2_A252PagoFechaEmision, P003B2_A245PagoNumero, P003B2_A242PagoMonto, P003B2_A66SGCitaDisponibilidadFecha,
            P003B2_n66SGCitaDisponibilidadFecha, P003B2_A47PagoId, P003B2_A246PagoEstadoR, P003B2_A339PagoEnlaceXML, P003B2_A338PagoEnlacePDF, P003B2_A310PagoPasarelaId, P003B2_A309PagoResponse, P003B2_A308PagoRequest, P003B2_A257PagoNubefactResponse, P003B2_A256PagoNubefactRequest,
            P003B2_A253PagoMoneda, P003B2_A244PagoTipoDocumento, P003B2_A251PagoClienteEmail, P003B2_A250PagoClienteDireccion, P003B2_A249PagoClienteDenominacion, P003B2_A248PagoClienteNroDocumento, P003B2_A247PagoTipoDocumentoCliente, P003B2_A243PagoToken, P003B2_A64CitaCode
            }
            , new Object[] {
            P003B3_A21SGCitaDisponibilidadId, P003B3_A243PagoToken, P003B3_A34DisponibilidadId, P003B3_n34DisponibilidadId, P003B3_A311PagoStatusCode, P003B3_A252PagoFechaEmision, P003B3_A245PagoNumero, P003B3_A242PagoMonto, P003B3_A66SGCitaDisponibilidadFecha, P003B3_n66SGCitaDisponibilidadFecha,
            P003B3_A19CitaId, P003B3_n19CitaId, P003B3_A47PagoId, P003B3_A246PagoEstadoR, P003B3_A339PagoEnlaceXML, P003B3_A338PagoEnlacePDF, P003B3_A310PagoPasarelaId, P003B3_A309PagoResponse, P003B3_A308PagoRequest, P003B3_A257PagoNubefactResponse,
            P003B3_A256PagoNubefactRequest, P003B3_A253PagoMoneda, P003B3_A244PagoTipoDocumento, P003B3_A251PagoClienteEmail, P003B3_A250PagoClienteDireccion, P003B3_A249PagoClienteDenominacion, P003B3_A248PagoClienteNroDocumento, P003B3_A247PagoTipoDocumentoCliente, P003B3_A64CitaCode
            }
            , new Object[] {
            P003B4_A21SGCitaDisponibilidadId, P003B4_A248PagoClienteNroDocumento, P003B4_A34DisponibilidadId, P003B4_n34DisponibilidadId, P003B4_A311PagoStatusCode, P003B4_A252PagoFechaEmision, P003B4_A245PagoNumero, P003B4_A242PagoMonto, P003B4_A66SGCitaDisponibilidadFecha, P003B4_n66SGCitaDisponibilidadFecha,
            P003B4_A19CitaId, P003B4_n19CitaId, P003B4_A47PagoId, P003B4_A246PagoEstadoR, P003B4_A339PagoEnlaceXML, P003B4_A338PagoEnlacePDF, P003B4_A310PagoPasarelaId, P003B4_A309PagoResponse, P003B4_A308PagoRequest, P003B4_A257PagoNubefactResponse,
            P003B4_A256PagoNubefactRequest, P003B4_A253PagoMoneda, P003B4_A244PagoTipoDocumento, P003B4_A251PagoClienteEmail, P003B4_A250PagoClienteDireccion, P003B4_A249PagoClienteDenominacion, P003B4_A247PagoTipoDocumentoCliente, P003B4_A243PagoToken, P003B4_A64CitaCode
            }
            , new Object[] {
            P003B5_A21SGCitaDisponibilidadId, P003B5_A249PagoClienteDenominacion, P003B5_A34DisponibilidadId, P003B5_n34DisponibilidadId, P003B5_A311PagoStatusCode, P003B5_A252PagoFechaEmision, P003B5_A245PagoNumero, P003B5_A242PagoMonto, P003B5_A66SGCitaDisponibilidadFecha, P003B5_n66SGCitaDisponibilidadFecha,
            P003B5_A19CitaId, P003B5_n19CitaId, P003B5_A47PagoId, P003B5_A246PagoEstadoR, P003B5_A339PagoEnlaceXML, P003B5_A338PagoEnlacePDF, P003B5_A310PagoPasarelaId, P003B5_A309PagoResponse, P003B5_A308PagoRequest, P003B5_A257PagoNubefactResponse,
            P003B5_A256PagoNubefactRequest, P003B5_A253PagoMoneda, P003B5_A244PagoTipoDocumento, P003B5_A251PagoClienteEmail, P003B5_A250PagoClienteDireccion, P003B5_A248PagoClienteNroDocumento, P003B5_A247PagoTipoDocumentoCliente, P003B5_A243PagoToken, P003B5_A64CitaCode
            }
            , new Object[] {
            P003B6_A21SGCitaDisponibilidadId, P003B6_A250PagoClienteDireccion, P003B6_A34DisponibilidadId, P003B6_n34DisponibilidadId, P003B6_A311PagoStatusCode, P003B6_A252PagoFechaEmision, P003B6_A245PagoNumero, P003B6_A242PagoMonto, P003B6_A66SGCitaDisponibilidadFecha, P003B6_n66SGCitaDisponibilidadFecha,
            P003B6_A19CitaId, P003B6_n19CitaId, P003B6_A47PagoId, P003B6_A246PagoEstadoR, P003B6_A339PagoEnlaceXML, P003B6_A338PagoEnlacePDF, P003B6_A310PagoPasarelaId, P003B6_A309PagoResponse, P003B6_A308PagoRequest, P003B6_A257PagoNubefactResponse,
            P003B6_A256PagoNubefactRequest, P003B6_A253PagoMoneda, P003B6_A244PagoTipoDocumento, P003B6_A251PagoClienteEmail, P003B6_A249PagoClienteDenominacion, P003B6_A248PagoClienteNroDocumento, P003B6_A247PagoTipoDocumentoCliente, P003B6_A243PagoToken, P003B6_A64CitaCode
            }
            , new Object[] {
            P003B7_A21SGCitaDisponibilidadId, P003B7_A251PagoClienteEmail, P003B7_A34DisponibilidadId, P003B7_n34DisponibilidadId, P003B7_A311PagoStatusCode, P003B7_A252PagoFechaEmision, P003B7_A245PagoNumero, P003B7_A242PagoMonto, P003B7_A66SGCitaDisponibilidadFecha, P003B7_n66SGCitaDisponibilidadFecha,
            P003B7_A19CitaId, P003B7_n19CitaId, P003B7_A47PagoId, P003B7_A246PagoEstadoR, P003B7_A339PagoEnlaceXML, P003B7_A338PagoEnlacePDF, P003B7_A310PagoPasarelaId, P003B7_A309PagoResponse, P003B7_A308PagoRequest, P003B7_A257PagoNubefactResponse,
            P003B7_A256PagoNubefactRequest, P003B7_A253PagoMoneda, P003B7_A244PagoTipoDocumento, P003B7_A250PagoClienteDireccion, P003B7_A249PagoClienteDenominacion, P003B7_A248PagoClienteNroDocumento, P003B7_A247PagoTipoDocumentoCliente, P003B7_A243PagoToken, P003B7_A64CitaCode
            }
            , new Object[] {
            P003B8_A21SGCitaDisponibilidadId, P003B8_A256PagoNubefactRequest, P003B8_A34DisponibilidadId, P003B8_n34DisponibilidadId, P003B8_A311PagoStatusCode, P003B8_A252PagoFechaEmision, P003B8_A245PagoNumero, P003B8_A242PagoMonto, P003B8_A66SGCitaDisponibilidadFecha, P003B8_n66SGCitaDisponibilidadFecha,
            P003B8_A19CitaId, P003B8_n19CitaId, P003B8_A47PagoId, P003B8_A246PagoEstadoR, P003B8_A339PagoEnlaceXML, P003B8_A338PagoEnlacePDF, P003B8_A310PagoPasarelaId, P003B8_A309PagoResponse, P003B8_A308PagoRequest, P003B8_A257PagoNubefactResponse,
            P003B8_A253PagoMoneda, P003B8_A244PagoTipoDocumento, P003B8_A251PagoClienteEmail, P003B8_A250PagoClienteDireccion, P003B8_A249PagoClienteDenominacion, P003B8_A248PagoClienteNroDocumento, P003B8_A247PagoTipoDocumentoCliente, P003B8_A243PagoToken, P003B8_A64CitaCode
            }
            , new Object[] {
            P003B9_A21SGCitaDisponibilidadId, P003B9_A257PagoNubefactResponse, P003B9_A34DisponibilidadId, P003B9_n34DisponibilidadId, P003B9_A311PagoStatusCode, P003B9_A252PagoFechaEmision, P003B9_A245PagoNumero, P003B9_A242PagoMonto, P003B9_A66SGCitaDisponibilidadFecha, P003B9_n66SGCitaDisponibilidadFecha,
            P003B9_A19CitaId, P003B9_n19CitaId, P003B9_A47PagoId, P003B9_A246PagoEstadoR, P003B9_A339PagoEnlaceXML, P003B9_A338PagoEnlacePDF, P003B9_A310PagoPasarelaId, P003B9_A309PagoResponse, P003B9_A308PagoRequest, P003B9_A256PagoNubefactRequest,
            P003B9_A253PagoMoneda, P003B9_A244PagoTipoDocumento, P003B9_A251PagoClienteEmail, P003B9_A250PagoClienteDireccion, P003B9_A249PagoClienteDenominacion, P003B9_A248PagoClienteNroDocumento, P003B9_A247PagoTipoDocumentoCliente, P003B9_A243PagoToken, P003B9_A64CitaCode
            }
            , new Object[] {
            P003B10_A21SGCitaDisponibilidadId, P003B10_A308PagoRequest, P003B10_A34DisponibilidadId, P003B10_n34DisponibilidadId, P003B10_A311PagoStatusCode, P003B10_A252PagoFechaEmision, P003B10_A245PagoNumero, P003B10_A242PagoMonto, P003B10_A66SGCitaDisponibilidadFecha, P003B10_n66SGCitaDisponibilidadFecha,
            P003B10_A19CitaId, P003B10_n19CitaId, P003B10_A47PagoId, P003B10_A246PagoEstadoR, P003B10_A339PagoEnlaceXML, P003B10_A338PagoEnlacePDF, P003B10_A310PagoPasarelaId, P003B10_A309PagoResponse, P003B10_A257PagoNubefactResponse, P003B10_A256PagoNubefactRequest,
            P003B10_A253PagoMoneda, P003B10_A244PagoTipoDocumento, P003B10_A251PagoClienteEmail, P003B10_A250PagoClienteDireccion, P003B10_A249PagoClienteDenominacion, P003B10_A248PagoClienteNroDocumento, P003B10_A247PagoTipoDocumentoCliente, P003B10_A243PagoToken, P003B10_A64CitaCode
            }
            , new Object[] {
            P003B11_A21SGCitaDisponibilidadId, P003B11_A309PagoResponse, P003B11_A34DisponibilidadId, P003B11_n34DisponibilidadId, P003B11_A311PagoStatusCode, P003B11_A252PagoFechaEmision, P003B11_A245PagoNumero, P003B11_A242PagoMonto, P003B11_A66SGCitaDisponibilidadFecha, P003B11_n66SGCitaDisponibilidadFecha,
            P003B11_A19CitaId, P003B11_n19CitaId, P003B11_A47PagoId, P003B11_A246PagoEstadoR, P003B11_A339PagoEnlaceXML, P003B11_A338PagoEnlacePDF, P003B11_A310PagoPasarelaId, P003B11_A308PagoRequest, P003B11_A257PagoNubefactResponse, P003B11_A256PagoNubefactRequest,
            P003B11_A253PagoMoneda, P003B11_A244PagoTipoDocumento, P003B11_A251PagoClienteEmail, P003B11_A250PagoClienteDireccion, P003B11_A249PagoClienteDenominacion, P003B11_A248PagoClienteNroDocumento, P003B11_A247PagoTipoDocumentoCliente, P003B11_A243PagoToken, P003B11_A64CitaCode
            }
            , new Object[] {
            P003B12_A21SGCitaDisponibilidadId, P003B12_A310PagoPasarelaId, P003B12_A34DisponibilidadId, P003B12_n34DisponibilidadId, P003B12_A311PagoStatusCode, P003B12_A252PagoFechaEmision, P003B12_A245PagoNumero, P003B12_A242PagoMonto, P003B12_A66SGCitaDisponibilidadFecha, P003B12_n66SGCitaDisponibilidadFecha,
            P003B12_A19CitaId, P003B12_n19CitaId, P003B12_A47PagoId, P003B12_A246PagoEstadoR, P003B12_A339PagoEnlaceXML, P003B12_A338PagoEnlacePDF, P003B12_A309PagoResponse, P003B12_A308PagoRequest, P003B12_A257PagoNubefactResponse, P003B12_A256PagoNubefactRequest,
            P003B12_A253PagoMoneda, P003B12_A244PagoTipoDocumento, P003B12_A251PagoClienteEmail, P003B12_A250PagoClienteDireccion, P003B12_A249PagoClienteDenominacion, P003B12_A248PagoClienteNroDocumento, P003B12_A247PagoTipoDocumentoCliente, P003B12_A243PagoToken, P003B12_A64CitaCode
            }
            , new Object[] {
            P003B13_A21SGCitaDisponibilidadId, P003B13_A338PagoEnlacePDF, P003B13_A34DisponibilidadId, P003B13_n34DisponibilidadId, P003B13_A311PagoStatusCode, P003B13_A252PagoFechaEmision, P003B13_A245PagoNumero, P003B13_A242PagoMonto, P003B13_A66SGCitaDisponibilidadFecha, P003B13_n66SGCitaDisponibilidadFecha,
            P003B13_A19CitaId, P003B13_n19CitaId, P003B13_A47PagoId, P003B13_A246PagoEstadoR, P003B13_A339PagoEnlaceXML, P003B13_A310PagoPasarelaId, P003B13_A309PagoResponse, P003B13_A308PagoRequest, P003B13_A257PagoNubefactResponse, P003B13_A256PagoNubefactRequest,
            P003B13_A253PagoMoneda, P003B13_A244PagoTipoDocumento, P003B13_A251PagoClienteEmail, P003B13_A250PagoClienteDireccion, P003B13_A249PagoClienteDenominacion, P003B13_A248PagoClienteNroDocumento, P003B13_A247PagoTipoDocumentoCliente, P003B13_A243PagoToken, P003B13_A64CitaCode
            }
            , new Object[] {
            P003B14_A21SGCitaDisponibilidadId, P003B14_A339PagoEnlaceXML, P003B14_A34DisponibilidadId, P003B14_n34DisponibilidadId, P003B14_A311PagoStatusCode, P003B14_A252PagoFechaEmision, P003B14_A245PagoNumero, P003B14_A242PagoMonto, P003B14_A66SGCitaDisponibilidadFecha, P003B14_n66SGCitaDisponibilidadFecha,
            P003B14_A19CitaId, P003B14_n19CitaId, P003B14_A47PagoId, P003B14_A246PagoEstadoR, P003B14_A338PagoEnlacePDF, P003B14_A310PagoPasarelaId, P003B14_A309PagoResponse, P003B14_A308PagoRequest, P003B14_A257PagoNubefactResponse, P003B14_A256PagoNubefactRequest,
            P003B14_A253PagoMoneda, P003B14_A244PagoTipoDocumento, P003B14_A251PagoClienteEmail, P003B14_A250PagoClienteDireccion, P003B14_A249PagoClienteDenominacion, P003B14_A248PagoClienteNroDocumento, P003B14_A247PagoTipoDocumentoCliente, P003B14_A243PagoToken, P003B14_A64CitaCode
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short Gx_err ;
   private int AV88GXV1 ;
   private int AV11TFPagoId ;
   private int AV12TFPagoId_To ;
   private int AV13TFCitaId ;
   private int AV14TFCitaId_To ;
   private int AV35TFPagoNumero ;
   private int AV36TFPagoNumero_To ;
   private int AV78TFPagoStatusCode ;
   private int AV79TFPagoStatusCode_To ;
   private int AV80TFDisponibilidadId ;
   private int AV81TFDisponibilidadId_To ;
   private int AV91Pagowwds_2_tfpagoid ;
   private int AV92Pagowwds_3_tfpagoid_to ;
   private int AV93Pagowwds_4_tfcitaid ;
   private int AV94Pagowwds_5_tfcitaid_to ;
   private int AV113Pagowwds_24_tfpagonumero ;
   private int AV114Pagowwds_25_tfpagonumero_to ;
   private int AV128Pagowwds_39_tfpagostatuscode ;
   private int AV129Pagowwds_40_tfpagostatuscode_to ;
   private int AV130Pagowwds_41_tfdisponibilidadid ;
   private int AV131Pagowwds_42_tfdisponibilidadid_to ;
   private int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ;
   private int AV112Pagowwds_23_tfpagotipodocumento_sels_size ;
   private int AV117Pagowwds_28_tfpagomoneda_sels_size ;
   private int AV136Pagowwds_47_tfpagoestador_sels_size ;
   private int A47PagoId ;
   private int A19CitaId ;
   private int A245PagoNumero ;
   private int A311PagoStatusCode ;
   private int A34DisponibilidadId ;
   private int A21SGCitaDisponibilidadId ;
   private int AV56InsertIndex ;
   private long AV65count ;
   private java.math.BigDecimal AV19TFPagoMonto ;
   private java.math.BigDecimal AV20TFPagoMonto_To ;
   private java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ;
   private java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ;
   private java.math.BigDecimal A242PagoMonto ;
   private String scmdbuf ;
   private String A247PagoTipoDocumentoCliente ;
   private String A246PagoEstadoR ;
   private java.util.Date AV17TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV18TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV37TFPagoFechaEmision ;
   private java.util.Date AV38TFPagoFechaEmision_To ;
   private java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date AV115Pagowwds_26_tfpagofechaemision ;
   private java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date A252PagoFechaEmision ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk3B2 ;
   private boolean n19CitaId ;
   private boolean n34DisponibilidadId ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean brk3B4 ;
   private boolean brk3B6 ;
   private boolean brk3B8 ;
   private boolean brk3B10 ;
   private boolean brk3B12 ;
   private boolean brk3B14 ;
   private boolean brk3B16 ;
   private boolean brk3B18 ;
   private boolean brk3B20 ;
   private boolean brk3B22 ;
   private boolean brk3B24 ;
   private boolean brk3B26 ;
   private String AV59OptionsJson ;
   private String AV62OptionsDescJson ;
   private String AV64OptionIndexesJson ;
   private String AV23TFPagoTipoDocumentoCliente_SelsJson ;
   private String AV33TFPagoTipoDocumento_SelsJson ;
   private String AV39TFPagoMoneda_SelsJson ;
   private String AV51TFPagoEstadoR_SelsJson ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String AV55DDOName ;
   private String AV53SearchTxt ;
   private String AV54SearchTxtTo ;
   private String AV71FilterFullText ;
   private String AV15TFCitaCode ;
   private String AV16TFCitaCode_Sel ;
   private String AV21TFPagoToken ;
   private String AV22TFPagoToken_Sel ;
   private String AV25TFPagoClienteNroDocumento ;
   private String AV26TFPagoClienteNroDocumento_Sel ;
   private String AV27TFPagoClienteDenominacion ;
   private String AV28TFPagoClienteDenominacion_Sel ;
   private String AV29TFPagoClienteDireccion ;
   private String AV30TFPagoClienteDireccion_Sel ;
   private String AV31TFPagoClienteEmail ;
   private String AV32TFPagoClienteEmail_Sel ;
   private String AV47TFPagoNubefactRequest ;
   private String AV48TFPagoNubefactRequest_Sel ;
   private String AV49TFPagoNubefactResponse ;
   private String AV50TFPagoNubefactResponse_Sel ;
   private String AV72TFPagoRequest ;
   private String AV73TFPagoRequest_Sel ;
   private String AV74TFPagoResponse ;
   private String AV75TFPagoResponse_Sel ;
   private String AV76TFPagoPasarelaId ;
   private String AV77TFPagoPasarelaId_Sel ;
   private String AV82TFPagoEnlacePDF ;
   private String AV83TFPagoEnlacePDF_Sel ;
   private String AV84TFPagoEnlaceXML ;
   private String AV85TFPagoEnlaceXML_Sel ;
   private String A64CitaCode ;
   private String AV90Pagowwds_1_filterfulltext ;
   private String AV95Pagowwds_6_tfcitacode ;
   private String AV96Pagowwds_7_tfcitacode_sel ;
   private String AV101Pagowwds_12_tfpagotoken ;
   private String AV102Pagowwds_13_tfpagotoken_sel ;
   private String AV104Pagowwds_15_tfpagoclientenrodocumento ;
   private String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ;
   private String AV106Pagowwds_17_tfpagoclientedenominacion ;
   private String AV107Pagowwds_18_tfpagoclientedenominacion_sel ;
   private String AV108Pagowwds_19_tfpagoclientedireccion ;
   private String AV109Pagowwds_20_tfpagoclientedireccion_sel ;
   private String AV110Pagowwds_21_tfpagoclienteemail ;
   private String AV111Pagowwds_22_tfpagoclienteemail_sel ;
   private String AV118Pagowwds_29_tfpagonubefactrequest ;
   private String AV119Pagowwds_30_tfpagonubefactrequest_sel ;
   private String AV120Pagowwds_31_tfpagonubefactresponse ;
   private String AV121Pagowwds_32_tfpagonubefactresponse_sel ;
   private String AV122Pagowwds_33_tfpagorequest ;
   private String AV123Pagowwds_34_tfpagorequest_sel ;
   private String AV124Pagowwds_35_tfpagoresponse ;
   private String AV125Pagowwds_36_tfpagoresponse_sel ;
   private String AV126Pagowwds_37_tfpagopasarelaid ;
   private String AV127Pagowwds_38_tfpagopasarelaid_sel ;
   private String AV132Pagowwds_43_tfpagoenlacepdf ;
   private String AV133Pagowwds_44_tfpagoenlacepdf_sel ;
   private String AV134Pagowwds_45_tfpagoenlacexml ;
   private String AV135Pagowwds_46_tfpagoenlacexml_sel ;
   private String lV90Pagowwds_1_filterfulltext ;
   private String lV95Pagowwds_6_tfcitacode ;
   private String lV101Pagowwds_12_tfpagotoken ;
   private String lV104Pagowwds_15_tfpagoclientenrodocumento ;
   private String lV106Pagowwds_17_tfpagoclientedenominacion ;
   private String lV108Pagowwds_19_tfpagoclientedireccion ;
   private String lV110Pagowwds_21_tfpagoclienteemail ;
   private String lV118Pagowwds_29_tfpagonubefactrequest ;
   private String lV120Pagowwds_31_tfpagonubefactresponse ;
   private String lV122Pagowwds_33_tfpagorequest ;
   private String lV124Pagowwds_35_tfpagoresponse ;
   private String lV126Pagowwds_37_tfpagopasarelaid ;
   private String lV132Pagowwds_43_tfpagoenlacepdf ;
   private String lV134Pagowwds_45_tfpagoenlacexml ;
   private String A243PagoToken ;
   private String A248PagoClienteNroDocumento ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A310PagoPasarelaId ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private String AV57Option ;
   private GXSimpleCollection<Short> AV34TFPagoTipoDocumento_Sels ;
   private GXSimpleCollection<Short> AV40TFPagoMoneda_Sels ;
   private GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ;
   private GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ;
   private com.genexus.webpanels.WebSession AV66Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P003B2_A21SGCitaDisponibilidadId ;
   private int[] P003B2_A19CitaId ;
   private boolean[] P003B2_n19CitaId ;
   private int[] P003B2_A34DisponibilidadId ;
   private boolean[] P003B2_n34DisponibilidadId ;
   private int[] P003B2_A311PagoStatusCode ;
   private java.util.Date[] P003B2_A252PagoFechaEmision ;
   private int[] P003B2_A245PagoNumero ;
   private java.math.BigDecimal[] P003B2_A242PagoMonto ;
   private java.util.Date[] P003B2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B2_n66SGCitaDisponibilidadFecha ;
   private int[] P003B2_A47PagoId ;
   private String[] P003B2_A246PagoEstadoR ;
   private String[] P003B2_A339PagoEnlaceXML ;
   private String[] P003B2_A338PagoEnlacePDF ;
   private String[] P003B2_A310PagoPasarelaId ;
   private String[] P003B2_A309PagoResponse ;
   private String[] P003B2_A308PagoRequest ;
   private String[] P003B2_A257PagoNubefactResponse ;
   private String[] P003B2_A256PagoNubefactRequest ;
   private short[] P003B2_A253PagoMoneda ;
   private short[] P003B2_A244PagoTipoDocumento ;
   private String[] P003B2_A251PagoClienteEmail ;
   private String[] P003B2_A250PagoClienteDireccion ;
   private String[] P003B2_A249PagoClienteDenominacion ;
   private String[] P003B2_A248PagoClienteNroDocumento ;
   private String[] P003B2_A247PagoTipoDocumentoCliente ;
   private String[] P003B2_A243PagoToken ;
   private String[] P003B2_A64CitaCode ;
   private int[] P003B3_A21SGCitaDisponibilidadId ;
   private String[] P003B3_A243PagoToken ;
   private int[] P003B3_A34DisponibilidadId ;
   private boolean[] P003B3_n34DisponibilidadId ;
   private int[] P003B3_A311PagoStatusCode ;
   private java.util.Date[] P003B3_A252PagoFechaEmision ;
   private int[] P003B3_A245PagoNumero ;
   private java.math.BigDecimal[] P003B3_A242PagoMonto ;
   private java.util.Date[] P003B3_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B3_n66SGCitaDisponibilidadFecha ;
   private int[] P003B3_A19CitaId ;
   private boolean[] P003B3_n19CitaId ;
   private int[] P003B3_A47PagoId ;
   private String[] P003B3_A246PagoEstadoR ;
   private String[] P003B3_A339PagoEnlaceXML ;
   private String[] P003B3_A338PagoEnlacePDF ;
   private String[] P003B3_A310PagoPasarelaId ;
   private String[] P003B3_A309PagoResponse ;
   private String[] P003B3_A308PagoRequest ;
   private String[] P003B3_A257PagoNubefactResponse ;
   private String[] P003B3_A256PagoNubefactRequest ;
   private short[] P003B3_A253PagoMoneda ;
   private short[] P003B3_A244PagoTipoDocumento ;
   private String[] P003B3_A251PagoClienteEmail ;
   private String[] P003B3_A250PagoClienteDireccion ;
   private String[] P003B3_A249PagoClienteDenominacion ;
   private String[] P003B3_A248PagoClienteNroDocumento ;
   private String[] P003B3_A247PagoTipoDocumentoCliente ;
   private String[] P003B3_A64CitaCode ;
   private int[] P003B4_A21SGCitaDisponibilidadId ;
   private String[] P003B4_A248PagoClienteNroDocumento ;
   private int[] P003B4_A34DisponibilidadId ;
   private boolean[] P003B4_n34DisponibilidadId ;
   private int[] P003B4_A311PagoStatusCode ;
   private java.util.Date[] P003B4_A252PagoFechaEmision ;
   private int[] P003B4_A245PagoNumero ;
   private java.math.BigDecimal[] P003B4_A242PagoMonto ;
   private java.util.Date[] P003B4_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B4_n66SGCitaDisponibilidadFecha ;
   private int[] P003B4_A19CitaId ;
   private boolean[] P003B4_n19CitaId ;
   private int[] P003B4_A47PagoId ;
   private String[] P003B4_A246PagoEstadoR ;
   private String[] P003B4_A339PagoEnlaceXML ;
   private String[] P003B4_A338PagoEnlacePDF ;
   private String[] P003B4_A310PagoPasarelaId ;
   private String[] P003B4_A309PagoResponse ;
   private String[] P003B4_A308PagoRequest ;
   private String[] P003B4_A257PagoNubefactResponse ;
   private String[] P003B4_A256PagoNubefactRequest ;
   private short[] P003B4_A253PagoMoneda ;
   private short[] P003B4_A244PagoTipoDocumento ;
   private String[] P003B4_A251PagoClienteEmail ;
   private String[] P003B4_A250PagoClienteDireccion ;
   private String[] P003B4_A249PagoClienteDenominacion ;
   private String[] P003B4_A247PagoTipoDocumentoCliente ;
   private String[] P003B4_A243PagoToken ;
   private String[] P003B4_A64CitaCode ;
   private int[] P003B5_A21SGCitaDisponibilidadId ;
   private String[] P003B5_A249PagoClienteDenominacion ;
   private int[] P003B5_A34DisponibilidadId ;
   private boolean[] P003B5_n34DisponibilidadId ;
   private int[] P003B5_A311PagoStatusCode ;
   private java.util.Date[] P003B5_A252PagoFechaEmision ;
   private int[] P003B5_A245PagoNumero ;
   private java.math.BigDecimal[] P003B5_A242PagoMonto ;
   private java.util.Date[] P003B5_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B5_n66SGCitaDisponibilidadFecha ;
   private int[] P003B5_A19CitaId ;
   private boolean[] P003B5_n19CitaId ;
   private int[] P003B5_A47PagoId ;
   private String[] P003B5_A246PagoEstadoR ;
   private String[] P003B5_A339PagoEnlaceXML ;
   private String[] P003B5_A338PagoEnlacePDF ;
   private String[] P003B5_A310PagoPasarelaId ;
   private String[] P003B5_A309PagoResponse ;
   private String[] P003B5_A308PagoRequest ;
   private String[] P003B5_A257PagoNubefactResponse ;
   private String[] P003B5_A256PagoNubefactRequest ;
   private short[] P003B5_A253PagoMoneda ;
   private short[] P003B5_A244PagoTipoDocumento ;
   private String[] P003B5_A251PagoClienteEmail ;
   private String[] P003B5_A250PagoClienteDireccion ;
   private String[] P003B5_A248PagoClienteNroDocumento ;
   private String[] P003B5_A247PagoTipoDocumentoCliente ;
   private String[] P003B5_A243PagoToken ;
   private String[] P003B5_A64CitaCode ;
   private int[] P003B6_A21SGCitaDisponibilidadId ;
   private String[] P003B6_A250PagoClienteDireccion ;
   private int[] P003B6_A34DisponibilidadId ;
   private boolean[] P003B6_n34DisponibilidadId ;
   private int[] P003B6_A311PagoStatusCode ;
   private java.util.Date[] P003B6_A252PagoFechaEmision ;
   private int[] P003B6_A245PagoNumero ;
   private java.math.BigDecimal[] P003B6_A242PagoMonto ;
   private java.util.Date[] P003B6_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B6_n66SGCitaDisponibilidadFecha ;
   private int[] P003B6_A19CitaId ;
   private boolean[] P003B6_n19CitaId ;
   private int[] P003B6_A47PagoId ;
   private String[] P003B6_A246PagoEstadoR ;
   private String[] P003B6_A339PagoEnlaceXML ;
   private String[] P003B6_A338PagoEnlacePDF ;
   private String[] P003B6_A310PagoPasarelaId ;
   private String[] P003B6_A309PagoResponse ;
   private String[] P003B6_A308PagoRequest ;
   private String[] P003B6_A257PagoNubefactResponse ;
   private String[] P003B6_A256PagoNubefactRequest ;
   private short[] P003B6_A253PagoMoneda ;
   private short[] P003B6_A244PagoTipoDocumento ;
   private String[] P003B6_A251PagoClienteEmail ;
   private String[] P003B6_A249PagoClienteDenominacion ;
   private String[] P003B6_A248PagoClienteNroDocumento ;
   private String[] P003B6_A247PagoTipoDocumentoCliente ;
   private String[] P003B6_A243PagoToken ;
   private String[] P003B6_A64CitaCode ;
   private int[] P003B7_A21SGCitaDisponibilidadId ;
   private String[] P003B7_A251PagoClienteEmail ;
   private int[] P003B7_A34DisponibilidadId ;
   private boolean[] P003B7_n34DisponibilidadId ;
   private int[] P003B7_A311PagoStatusCode ;
   private java.util.Date[] P003B7_A252PagoFechaEmision ;
   private int[] P003B7_A245PagoNumero ;
   private java.math.BigDecimal[] P003B7_A242PagoMonto ;
   private java.util.Date[] P003B7_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B7_n66SGCitaDisponibilidadFecha ;
   private int[] P003B7_A19CitaId ;
   private boolean[] P003B7_n19CitaId ;
   private int[] P003B7_A47PagoId ;
   private String[] P003B7_A246PagoEstadoR ;
   private String[] P003B7_A339PagoEnlaceXML ;
   private String[] P003B7_A338PagoEnlacePDF ;
   private String[] P003B7_A310PagoPasarelaId ;
   private String[] P003B7_A309PagoResponse ;
   private String[] P003B7_A308PagoRequest ;
   private String[] P003B7_A257PagoNubefactResponse ;
   private String[] P003B7_A256PagoNubefactRequest ;
   private short[] P003B7_A253PagoMoneda ;
   private short[] P003B7_A244PagoTipoDocumento ;
   private String[] P003B7_A250PagoClienteDireccion ;
   private String[] P003B7_A249PagoClienteDenominacion ;
   private String[] P003B7_A248PagoClienteNroDocumento ;
   private String[] P003B7_A247PagoTipoDocumentoCliente ;
   private String[] P003B7_A243PagoToken ;
   private String[] P003B7_A64CitaCode ;
   private int[] P003B8_A21SGCitaDisponibilidadId ;
   private String[] P003B8_A256PagoNubefactRequest ;
   private int[] P003B8_A34DisponibilidadId ;
   private boolean[] P003B8_n34DisponibilidadId ;
   private int[] P003B8_A311PagoStatusCode ;
   private java.util.Date[] P003B8_A252PagoFechaEmision ;
   private int[] P003B8_A245PagoNumero ;
   private java.math.BigDecimal[] P003B8_A242PagoMonto ;
   private java.util.Date[] P003B8_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B8_n66SGCitaDisponibilidadFecha ;
   private int[] P003B8_A19CitaId ;
   private boolean[] P003B8_n19CitaId ;
   private int[] P003B8_A47PagoId ;
   private String[] P003B8_A246PagoEstadoR ;
   private String[] P003B8_A339PagoEnlaceXML ;
   private String[] P003B8_A338PagoEnlacePDF ;
   private String[] P003B8_A310PagoPasarelaId ;
   private String[] P003B8_A309PagoResponse ;
   private String[] P003B8_A308PagoRequest ;
   private String[] P003B8_A257PagoNubefactResponse ;
   private short[] P003B8_A253PagoMoneda ;
   private short[] P003B8_A244PagoTipoDocumento ;
   private String[] P003B8_A251PagoClienteEmail ;
   private String[] P003B8_A250PagoClienteDireccion ;
   private String[] P003B8_A249PagoClienteDenominacion ;
   private String[] P003B8_A248PagoClienteNroDocumento ;
   private String[] P003B8_A247PagoTipoDocumentoCliente ;
   private String[] P003B8_A243PagoToken ;
   private String[] P003B8_A64CitaCode ;
   private int[] P003B9_A21SGCitaDisponibilidadId ;
   private String[] P003B9_A257PagoNubefactResponse ;
   private int[] P003B9_A34DisponibilidadId ;
   private boolean[] P003B9_n34DisponibilidadId ;
   private int[] P003B9_A311PagoStatusCode ;
   private java.util.Date[] P003B9_A252PagoFechaEmision ;
   private int[] P003B9_A245PagoNumero ;
   private java.math.BigDecimal[] P003B9_A242PagoMonto ;
   private java.util.Date[] P003B9_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B9_n66SGCitaDisponibilidadFecha ;
   private int[] P003B9_A19CitaId ;
   private boolean[] P003B9_n19CitaId ;
   private int[] P003B9_A47PagoId ;
   private String[] P003B9_A246PagoEstadoR ;
   private String[] P003B9_A339PagoEnlaceXML ;
   private String[] P003B9_A338PagoEnlacePDF ;
   private String[] P003B9_A310PagoPasarelaId ;
   private String[] P003B9_A309PagoResponse ;
   private String[] P003B9_A308PagoRequest ;
   private String[] P003B9_A256PagoNubefactRequest ;
   private short[] P003B9_A253PagoMoneda ;
   private short[] P003B9_A244PagoTipoDocumento ;
   private String[] P003B9_A251PagoClienteEmail ;
   private String[] P003B9_A250PagoClienteDireccion ;
   private String[] P003B9_A249PagoClienteDenominacion ;
   private String[] P003B9_A248PagoClienteNroDocumento ;
   private String[] P003B9_A247PagoTipoDocumentoCliente ;
   private String[] P003B9_A243PagoToken ;
   private String[] P003B9_A64CitaCode ;
   private int[] P003B10_A21SGCitaDisponibilidadId ;
   private String[] P003B10_A308PagoRequest ;
   private int[] P003B10_A34DisponibilidadId ;
   private boolean[] P003B10_n34DisponibilidadId ;
   private int[] P003B10_A311PagoStatusCode ;
   private java.util.Date[] P003B10_A252PagoFechaEmision ;
   private int[] P003B10_A245PagoNumero ;
   private java.math.BigDecimal[] P003B10_A242PagoMonto ;
   private java.util.Date[] P003B10_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B10_n66SGCitaDisponibilidadFecha ;
   private int[] P003B10_A19CitaId ;
   private boolean[] P003B10_n19CitaId ;
   private int[] P003B10_A47PagoId ;
   private String[] P003B10_A246PagoEstadoR ;
   private String[] P003B10_A339PagoEnlaceXML ;
   private String[] P003B10_A338PagoEnlacePDF ;
   private String[] P003B10_A310PagoPasarelaId ;
   private String[] P003B10_A309PagoResponse ;
   private String[] P003B10_A257PagoNubefactResponse ;
   private String[] P003B10_A256PagoNubefactRequest ;
   private short[] P003B10_A253PagoMoneda ;
   private short[] P003B10_A244PagoTipoDocumento ;
   private String[] P003B10_A251PagoClienteEmail ;
   private String[] P003B10_A250PagoClienteDireccion ;
   private String[] P003B10_A249PagoClienteDenominacion ;
   private String[] P003B10_A248PagoClienteNroDocumento ;
   private String[] P003B10_A247PagoTipoDocumentoCliente ;
   private String[] P003B10_A243PagoToken ;
   private String[] P003B10_A64CitaCode ;
   private int[] P003B11_A21SGCitaDisponibilidadId ;
   private String[] P003B11_A309PagoResponse ;
   private int[] P003B11_A34DisponibilidadId ;
   private boolean[] P003B11_n34DisponibilidadId ;
   private int[] P003B11_A311PagoStatusCode ;
   private java.util.Date[] P003B11_A252PagoFechaEmision ;
   private int[] P003B11_A245PagoNumero ;
   private java.math.BigDecimal[] P003B11_A242PagoMonto ;
   private java.util.Date[] P003B11_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B11_n66SGCitaDisponibilidadFecha ;
   private int[] P003B11_A19CitaId ;
   private boolean[] P003B11_n19CitaId ;
   private int[] P003B11_A47PagoId ;
   private String[] P003B11_A246PagoEstadoR ;
   private String[] P003B11_A339PagoEnlaceXML ;
   private String[] P003B11_A338PagoEnlacePDF ;
   private String[] P003B11_A310PagoPasarelaId ;
   private String[] P003B11_A308PagoRequest ;
   private String[] P003B11_A257PagoNubefactResponse ;
   private String[] P003B11_A256PagoNubefactRequest ;
   private short[] P003B11_A253PagoMoneda ;
   private short[] P003B11_A244PagoTipoDocumento ;
   private String[] P003B11_A251PagoClienteEmail ;
   private String[] P003B11_A250PagoClienteDireccion ;
   private String[] P003B11_A249PagoClienteDenominacion ;
   private String[] P003B11_A248PagoClienteNroDocumento ;
   private String[] P003B11_A247PagoTipoDocumentoCliente ;
   private String[] P003B11_A243PagoToken ;
   private String[] P003B11_A64CitaCode ;
   private int[] P003B12_A21SGCitaDisponibilidadId ;
   private String[] P003B12_A310PagoPasarelaId ;
   private int[] P003B12_A34DisponibilidadId ;
   private boolean[] P003B12_n34DisponibilidadId ;
   private int[] P003B12_A311PagoStatusCode ;
   private java.util.Date[] P003B12_A252PagoFechaEmision ;
   private int[] P003B12_A245PagoNumero ;
   private java.math.BigDecimal[] P003B12_A242PagoMonto ;
   private java.util.Date[] P003B12_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B12_n66SGCitaDisponibilidadFecha ;
   private int[] P003B12_A19CitaId ;
   private boolean[] P003B12_n19CitaId ;
   private int[] P003B12_A47PagoId ;
   private String[] P003B12_A246PagoEstadoR ;
   private String[] P003B12_A339PagoEnlaceXML ;
   private String[] P003B12_A338PagoEnlacePDF ;
   private String[] P003B12_A309PagoResponse ;
   private String[] P003B12_A308PagoRequest ;
   private String[] P003B12_A257PagoNubefactResponse ;
   private String[] P003B12_A256PagoNubefactRequest ;
   private short[] P003B12_A253PagoMoneda ;
   private short[] P003B12_A244PagoTipoDocumento ;
   private String[] P003B12_A251PagoClienteEmail ;
   private String[] P003B12_A250PagoClienteDireccion ;
   private String[] P003B12_A249PagoClienteDenominacion ;
   private String[] P003B12_A248PagoClienteNroDocumento ;
   private String[] P003B12_A247PagoTipoDocumentoCliente ;
   private String[] P003B12_A243PagoToken ;
   private String[] P003B12_A64CitaCode ;
   private int[] P003B13_A21SGCitaDisponibilidadId ;
   private String[] P003B13_A338PagoEnlacePDF ;
   private int[] P003B13_A34DisponibilidadId ;
   private boolean[] P003B13_n34DisponibilidadId ;
   private int[] P003B13_A311PagoStatusCode ;
   private java.util.Date[] P003B13_A252PagoFechaEmision ;
   private int[] P003B13_A245PagoNumero ;
   private java.math.BigDecimal[] P003B13_A242PagoMonto ;
   private java.util.Date[] P003B13_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B13_n66SGCitaDisponibilidadFecha ;
   private int[] P003B13_A19CitaId ;
   private boolean[] P003B13_n19CitaId ;
   private int[] P003B13_A47PagoId ;
   private String[] P003B13_A246PagoEstadoR ;
   private String[] P003B13_A339PagoEnlaceXML ;
   private String[] P003B13_A310PagoPasarelaId ;
   private String[] P003B13_A309PagoResponse ;
   private String[] P003B13_A308PagoRequest ;
   private String[] P003B13_A257PagoNubefactResponse ;
   private String[] P003B13_A256PagoNubefactRequest ;
   private short[] P003B13_A253PagoMoneda ;
   private short[] P003B13_A244PagoTipoDocumento ;
   private String[] P003B13_A251PagoClienteEmail ;
   private String[] P003B13_A250PagoClienteDireccion ;
   private String[] P003B13_A249PagoClienteDenominacion ;
   private String[] P003B13_A248PagoClienteNroDocumento ;
   private String[] P003B13_A247PagoTipoDocumentoCliente ;
   private String[] P003B13_A243PagoToken ;
   private String[] P003B13_A64CitaCode ;
   private int[] P003B14_A21SGCitaDisponibilidadId ;
   private String[] P003B14_A339PagoEnlaceXML ;
   private int[] P003B14_A34DisponibilidadId ;
   private boolean[] P003B14_n34DisponibilidadId ;
   private int[] P003B14_A311PagoStatusCode ;
   private java.util.Date[] P003B14_A252PagoFechaEmision ;
   private int[] P003B14_A245PagoNumero ;
   private java.math.BigDecimal[] P003B14_A242PagoMonto ;
   private java.util.Date[] P003B14_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003B14_n66SGCitaDisponibilidadFecha ;
   private int[] P003B14_A19CitaId ;
   private boolean[] P003B14_n19CitaId ;
   private int[] P003B14_A47PagoId ;
   private String[] P003B14_A246PagoEstadoR ;
   private String[] P003B14_A338PagoEnlacePDF ;
   private String[] P003B14_A310PagoPasarelaId ;
   private String[] P003B14_A309PagoResponse ;
   private String[] P003B14_A308PagoRequest ;
   private String[] P003B14_A257PagoNubefactResponse ;
   private String[] P003B14_A256PagoNubefactRequest ;
   private short[] P003B14_A253PagoMoneda ;
   private short[] P003B14_A244PagoTipoDocumento ;
   private String[] P003B14_A251PagoClienteEmail ;
   private String[] P003B14_A250PagoClienteDireccion ;
   private String[] P003B14_A249PagoClienteDenominacion ;
   private String[] P003B14_A248PagoClienteNroDocumento ;
   private String[] P003B14_A247PagoTipoDocumentoCliente ;
   private String[] P003B14_A243PagoToken ;
   private String[] P003B14_A64CitaCode ;
   private GXSimpleCollection<String> AV24TFPagoTipoDocumentoCliente_Sels ;
   private GXSimpleCollection<String> AV52TFPagoEstadoR_Sels ;
   private GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ;
   private GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ;
   private GXSimpleCollection<String> AV58Options ;
   private GXSimpleCollection<String> AV61OptionsDesc ;
   private GXSimpleCollection<String> AV63OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV68GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV69GridStateFilterValue ;
}

final  class pagowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[76];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[CitaId], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero], T1.[PagoMonto]," ;
      scmdbuf += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId], T1.[PagoResponse]," ;
      scmdbuf += " T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
         GXv_int4[10] = (byte)(1) ;
         GXv_int4[11] = (byte)(1) ;
         GXv_int4[12] = (byte)(1) ;
         GXv_int4[13] = (byte)(1) ;
         GXv_int4[14] = (byte)(1) ;
         GXv_int4[15] = (byte)(1) ;
         GXv_int4[16] = (byte)(1) ;
         GXv_int4[17] = (byte)(1) ;
         GXv_int4[18] = (byte)(1) ;
         GXv_int4[19] = (byte)(1) ;
         GXv_int4[20] = (byte)(1) ;
         GXv_int4[21] = (byte)(1) ;
         GXv_int4[22] = (byte)(1) ;
         GXv_int4[23] = (byte)(1) ;
         GXv_int4[24] = (byte)(1) ;
         GXv_int4[25] = (byte)(1) ;
         GXv_int4[26] = (byte)(1) ;
         GXv_int4[27] = (byte)(1) ;
         GXv_int4[28] = (byte)(1) ;
         GXv_int4[29] = (byte)(1) ;
         GXv_int4[30] = (byte)(1) ;
         GXv_int4[31] = (byte)(1) ;
         GXv_int4[32] = (byte)(1) ;
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int4[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int4[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int4[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int4[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int4[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int4[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int4[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int4[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int4[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int4[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int4[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int4[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int4[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int4[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int4[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int4[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int4[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int4[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int4[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[CitaId]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P003B3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[76];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoToken], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId])" ;
      scmdbuf += " LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
         GXv_int7[6] = (byte)(1) ;
         GXv_int7[7] = (byte)(1) ;
         GXv_int7[8] = (byte)(1) ;
         GXv_int7[9] = (byte)(1) ;
         GXv_int7[10] = (byte)(1) ;
         GXv_int7[11] = (byte)(1) ;
         GXv_int7[12] = (byte)(1) ;
         GXv_int7[13] = (byte)(1) ;
         GXv_int7[14] = (byte)(1) ;
         GXv_int7[15] = (byte)(1) ;
         GXv_int7[16] = (byte)(1) ;
         GXv_int7[17] = (byte)(1) ;
         GXv_int7[18] = (byte)(1) ;
         GXv_int7[19] = (byte)(1) ;
         GXv_int7[20] = (byte)(1) ;
         GXv_int7[21] = (byte)(1) ;
         GXv_int7[22] = (byte)(1) ;
         GXv_int7[23] = (byte)(1) ;
         GXv_int7[24] = (byte)(1) ;
         GXv_int7[25] = (byte)(1) ;
         GXv_int7[26] = (byte)(1) ;
         GXv_int7[27] = (byte)(1) ;
         GXv_int7[28] = (byte)(1) ;
         GXv_int7[29] = (byte)(1) ;
         GXv_int7[30] = (byte)(1) ;
         GXv_int7[31] = (byte)(1) ;
         GXv_int7[32] = (byte)(1) ;
         GXv_int7[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int7[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int7[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int7[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int7[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int7[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int7[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int7[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int7[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int7[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int7[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int7[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int7[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int7[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int7[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int7[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int7[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int7[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int7[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int7[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int7[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int7[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int7[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int7[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int7[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int7[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int7[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int7[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int7[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int7[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int7[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int7[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int7[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int7[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int7[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int7[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int7[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int7[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int7[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int7[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int7[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int7[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int7[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoToken]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P003B4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[76];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoClienteNroDocumento], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT" ;
      scmdbuf += " JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
         GXv_int10[8] = (byte)(1) ;
         GXv_int10[9] = (byte)(1) ;
         GXv_int10[10] = (byte)(1) ;
         GXv_int10[11] = (byte)(1) ;
         GXv_int10[12] = (byte)(1) ;
         GXv_int10[13] = (byte)(1) ;
         GXv_int10[14] = (byte)(1) ;
         GXv_int10[15] = (byte)(1) ;
         GXv_int10[16] = (byte)(1) ;
         GXv_int10[17] = (byte)(1) ;
         GXv_int10[18] = (byte)(1) ;
         GXv_int10[19] = (byte)(1) ;
         GXv_int10[20] = (byte)(1) ;
         GXv_int10[21] = (byte)(1) ;
         GXv_int10[22] = (byte)(1) ;
         GXv_int10[23] = (byte)(1) ;
         GXv_int10[24] = (byte)(1) ;
         GXv_int10[25] = (byte)(1) ;
         GXv_int10[26] = (byte)(1) ;
         GXv_int10[27] = (byte)(1) ;
         GXv_int10[28] = (byte)(1) ;
         GXv_int10[29] = (byte)(1) ;
         GXv_int10[30] = (byte)(1) ;
         GXv_int10[31] = (byte)(1) ;
         GXv_int10[32] = (byte)(1) ;
         GXv_int10[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int10[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int10[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int10[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int10[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int10[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int10[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int10[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int10[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int10[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int10[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int10[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int10[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int10[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int10[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int10[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int10[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int10[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int10[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int10[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int10[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int10[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int10[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int10[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int10[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int10[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int10[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int10[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int10[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int10[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int10[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int10[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int10[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int10[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int10[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int10[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int10[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int10[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int10[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int10[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int10[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoClienteNroDocumento]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P003B5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[76];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoClienteDenominacion], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT" ;
      scmdbuf += " JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int13[0] = (byte)(1) ;
         GXv_int13[1] = (byte)(1) ;
         GXv_int13[2] = (byte)(1) ;
         GXv_int13[3] = (byte)(1) ;
         GXv_int13[4] = (byte)(1) ;
         GXv_int13[5] = (byte)(1) ;
         GXv_int13[6] = (byte)(1) ;
         GXv_int13[7] = (byte)(1) ;
         GXv_int13[8] = (byte)(1) ;
         GXv_int13[9] = (byte)(1) ;
         GXv_int13[10] = (byte)(1) ;
         GXv_int13[11] = (byte)(1) ;
         GXv_int13[12] = (byte)(1) ;
         GXv_int13[13] = (byte)(1) ;
         GXv_int13[14] = (byte)(1) ;
         GXv_int13[15] = (byte)(1) ;
         GXv_int13[16] = (byte)(1) ;
         GXv_int13[17] = (byte)(1) ;
         GXv_int13[18] = (byte)(1) ;
         GXv_int13[19] = (byte)(1) ;
         GXv_int13[20] = (byte)(1) ;
         GXv_int13[21] = (byte)(1) ;
         GXv_int13[22] = (byte)(1) ;
         GXv_int13[23] = (byte)(1) ;
         GXv_int13[24] = (byte)(1) ;
         GXv_int13[25] = (byte)(1) ;
         GXv_int13[26] = (byte)(1) ;
         GXv_int13[27] = (byte)(1) ;
         GXv_int13[28] = (byte)(1) ;
         GXv_int13[29] = (byte)(1) ;
         GXv_int13[30] = (byte)(1) ;
         GXv_int13[31] = (byte)(1) ;
         GXv_int13[32] = (byte)(1) ;
         GXv_int13[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int13[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int13[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int13[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int13[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int13[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int13[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int13[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int13[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int13[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int13[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int13[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int13[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int13[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int13[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int13[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int13[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int13[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int13[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int13[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int13[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int13[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int13[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int13[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int13[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int13[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int13[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int13[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int13[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int13[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int13[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int13[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int13[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int13[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int13[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int13[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int13[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int13[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int13[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int13[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int13[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int13[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int13[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoClienteDenominacion]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P003B6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[76];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoClienteDireccion], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDenominacion]," ;
      scmdbuf += " T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT" ;
      scmdbuf += " JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int16[0] = (byte)(1) ;
         GXv_int16[1] = (byte)(1) ;
         GXv_int16[2] = (byte)(1) ;
         GXv_int16[3] = (byte)(1) ;
         GXv_int16[4] = (byte)(1) ;
         GXv_int16[5] = (byte)(1) ;
         GXv_int16[6] = (byte)(1) ;
         GXv_int16[7] = (byte)(1) ;
         GXv_int16[8] = (byte)(1) ;
         GXv_int16[9] = (byte)(1) ;
         GXv_int16[10] = (byte)(1) ;
         GXv_int16[11] = (byte)(1) ;
         GXv_int16[12] = (byte)(1) ;
         GXv_int16[13] = (byte)(1) ;
         GXv_int16[14] = (byte)(1) ;
         GXv_int16[15] = (byte)(1) ;
         GXv_int16[16] = (byte)(1) ;
         GXv_int16[17] = (byte)(1) ;
         GXv_int16[18] = (byte)(1) ;
         GXv_int16[19] = (byte)(1) ;
         GXv_int16[20] = (byte)(1) ;
         GXv_int16[21] = (byte)(1) ;
         GXv_int16[22] = (byte)(1) ;
         GXv_int16[23] = (byte)(1) ;
         GXv_int16[24] = (byte)(1) ;
         GXv_int16[25] = (byte)(1) ;
         GXv_int16[26] = (byte)(1) ;
         GXv_int16[27] = (byte)(1) ;
         GXv_int16[28] = (byte)(1) ;
         GXv_int16[29] = (byte)(1) ;
         GXv_int16[30] = (byte)(1) ;
         GXv_int16[31] = (byte)(1) ;
         GXv_int16[32] = (byte)(1) ;
         GXv_int16[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int16[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int16[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int16[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int16[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int16[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int16[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int16[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int16[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int16[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int16[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int16[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int16[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int16[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int16[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int16[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int16[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int16[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int16[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int16[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int16[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int16[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int16[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int16[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int16[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int16[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int16[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int16[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int16[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int16[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int16[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int16[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int16[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int16[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int16[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int16[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int16[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int16[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int16[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int16[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int16[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int16[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int16[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoClienteDireccion]" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P003B7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[76];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoClienteEmail], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteDireccion], T1.[PagoClienteDenominacion]," ;
      scmdbuf += " T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT" ;
      scmdbuf += " JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int19[0] = (byte)(1) ;
         GXv_int19[1] = (byte)(1) ;
         GXv_int19[2] = (byte)(1) ;
         GXv_int19[3] = (byte)(1) ;
         GXv_int19[4] = (byte)(1) ;
         GXv_int19[5] = (byte)(1) ;
         GXv_int19[6] = (byte)(1) ;
         GXv_int19[7] = (byte)(1) ;
         GXv_int19[8] = (byte)(1) ;
         GXv_int19[9] = (byte)(1) ;
         GXv_int19[10] = (byte)(1) ;
         GXv_int19[11] = (byte)(1) ;
         GXv_int19[12] = (byte)(1) ;
         GXv_int19[13] = (byte)(1) ;
         GXv_int19[14] = (byte)(1) ;
         GXv_int19[15] = (byte)(1) ;
         GXv_int19[16] = (byte)(1) ;
         GXv_int19[17] = (byte)(1) ;
         GXv_int19[18] = (byte)(1) ;
         GXv_int19[19] = (byte)(1) ;
         GXv_int19[20] = (byte)(1) ;
         GXv_int19[21] = (byte)(1) ;
         GXv_int19[22] = (byte)(1) ;
         GXv_int19[23] = (byte)(1) ;
         GXv_int19[24] = (byte)(1) ;
         GXv_int19[25] = (byte)(1) ;
         GXv_int19[26] = (byte)(1) ;
         GXv_int19[27] = (byte)(1) ;
         GXv_int19[28] = (byte)(1) ;
         GXv_int19[29] = (byte)(1) ;
         GXv_int19[30] = (byte)(1) ;
         GXv_int19[31] = (byte)(1) ;
         GXv_int19[32] = (byte)(1) ;
         GXv_int19[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int19[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int19[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int19[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int19[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int19[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int19[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int19[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int19[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int19[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int19[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int19[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int19[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int19[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int19[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int19[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int19[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int19[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int19[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int19[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int19[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int19[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int19[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int19[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int19[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int19[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int19[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int19[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int19[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int19[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int19[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int19[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int19[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int19[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int19[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int19[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int19[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int19[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int19[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int19[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int19[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int19[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int19[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoClienteEmail]" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P003B8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[76];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoNubefactRequest], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion], T1.[PagoClienteDenominacion]," ;
      scmdbuf += " T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT" ;
      scmdbuf += " JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int22[0] = (byte)(1) ;
         GXv_int22[1] = (byte)(1) ;
         GXv_int22[2] = (byte)(1) ;
         GXv_int22[3] = (byte)(1) ;
         GXv_int22[4] = (byte)(1) ;
         GXv_int22[5] = (byte)(1) ;
         GXv_int22[6] = (byte)(1) ;
         GXv_int22[7] = (byte)(1) ;
         GXv_int22[8] = (byte)(1) ;
         GXv_int22[9] = (byte)(1) ;
         GXv_int22[10] = (byte)(1) ;
         GXv_int22[11] = (byte)(1) ;
         GXv_int22[12] = (byte)(1) ;
         GXv_int22[13] = (byte)(1) ;
         GXv_int22[14] = (byte)(1) ;
         GXv_int22[15] = (byte)(1) ;
         GXv_int22[16] = (byte)(1) ;
         GXv_int22[17] = (byte)(1) ;
         GXv_int22[18] = (byte)(1) ;
         GXv_int22[19] = (byte)(1) ;
         GXv_int22[20] = (byte)(1) ;
         GXv_int22[21] = (byte)(1) ;
         GXv_int22[22] = (byte)(1) ;
         GXv_int22[23] = (byte)(1) ;
         GXv_int22[24] = (byte)(1) ;
         GXv_int22[25] = (byte)(1) ;
         GXv_int22[26] = (byte)(1) ;
         GXv_int22[27] = (byte)(1) ;
         GXv_int22[28] = (byte)(1) ;
         GXv_int22[29] = (byte)(1) ;
         GXv_int22[30] = (byte)(1) ;
         GXv_int22[31] = (byte)(1) ;
         GXv_int22[32] = (byte)(1) ;
         GXv_int22[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int22[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int22[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int22[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int22[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int22[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int22[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int22[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int22[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int22[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int22[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int22[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int22[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int22[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int22[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int22[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int22[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int22[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int22[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int22[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int22[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int22[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int22[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int22[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int22[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int22[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int22[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int22[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int22[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int22[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int22[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int22[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int22[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int22[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int22[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int22[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int22[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int22[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int22[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int22[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int22[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int22[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int22[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoNubefactRequest]" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_P003B9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A247PagoTipoDocumentoCliente ,
                                          GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                          short A244PagoTipoDocumento ,
                                          GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                          short A253PagoMoneda ,
                                          GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                          String A246PagoEstadoR ,
                                          GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                          String AV90Pagowwds_1_filterfulltext ,
                                          int AV91Pagowwds_2_tfpagoid ,
                                          int AV92Pagowwds_3_tfpagoid_to ,
                                          int AV93Pagowwds_4_tfcitaid ,
                                          int AV94Pagowwds_5_tfcitaid_to ,
                                          String AV96Pagowwds_7_tfcitacode_sel ,
                                          String AV95Pagowwds_6_tfcitacode ,
                                          java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                          java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                          java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                          String AV102Pagowwds_13_tfpagotoken_sel ,
                                          String AV101Pagowwds_12_tfpagotoken ,
                                          int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                          String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                          String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                          String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                          String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                          String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                          String AV108Pagowwds_19_tfpagoclientedireccion ,
                                          String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                          String AV110Pagowwds_21_tfpagoclienteemail ,
                                          int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                          int AV113Pagowwds_24_tfpagonumero ,
                                          int AV114Pagowwds_25_tfpagonumero_to ,
                                          java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                          java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                          int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                          String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                          String AV118Pagowwds_29_tfpagonubefactrequest ,
                                          String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                          String AV120Pagowwds_31_tfpagonubefactresponse ,
                                          String AV123Pagowwds_34_tfpagorequest_sel ,
                                          String AV122Pagowwds_33_tfpagorequest ,
                                          String AV125Pagowwds_36_tfpagoresponse_sel ,
                                          String AV124Pagowwds_35_tfpagoresponse ,
                                          String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                          String AV126Pagowwds_37_tfpagopasarelaid ,
                                          int AV128Pagowwds_39_tfpagostatuscode ,
                                          int AV129Pagowwds_40_tfpagostatuscode_to ,
                                          int AV130Pagowwds_41_tfdisponibilidadid ,
                                          int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                          String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                          String AV132Pagowwds_43_tfpagoenlacepdf ,
                                          String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                          String AV134Pagowwds_45_tfpagoenlacexml ,
                                          int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                          int A47PagoId ,
                                          int A19CitaId ,
                                          String A64CitaCode ,
                                          java.math.BigDecimal A242PagoMonto ,
                                          String A243PagoToken ,
                                          String A248PagoClienteNroDocumento ,
                                          String A249PagoClienteDenominacion ,
                                          String A250PagoClienteDireccion ,
                                          String A251PagoClienteEmail ,
                                          int A245PagoNumero ,
                                          String A256PagoNubefactRequest ,
                                          String A257PagoNubefactResponse ,
                                          String A308PagoRequest ,
                                          String A309PagoResponse ,
                                          String A310PagoPasarelaId ,
                                          int A311PagoStatusCode ,
                                          int A34DisponibilidadId ,
                                          String A338PagoEnlacePDF ,
                                          String A339PagoEnlaceXML ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[76];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoNubefactResponse], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion], T1.[PagoClienteDenominacion]," ;
      scmdbuf += " T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT" ;
      scmdbuf += " JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int25[0] = (byte)(1) ;
         GXv_int25[1] = (byte)(1) ;
         GXv_int25[2] = (byte)(1) ;
         GXv_int25[3] = (byte)(1) ;
         GXv_int25[4] = (byte)(1) ;
         GXv_int25[5] = (byte)(1) ;
         GXv_int25[6] = (byte)(1) ;
         GXv_int25[7] = (byte)(1) ;
         GXv_int25[8] = (byte)(1) ;
         GXv_int25[9] = (byte)(1) ;
         GXv_int25[10] = (byte)(1) ;
         GXv_int25[11] = (byte)(1) ;
         GXv_int25[12] = (byte)(1) ;
         GXv_int25[13] = (byte)(1) ;
         GXv_int25[14] = (byte)(1) ;
         GXv_int25[15] = (byte)(1) ;
         GXv_int25[16] = (byte)(1) ;
         GXv_int25[17] = (byte)(1) ;
         GXv_int25[18] = (byte)(1) ;
         GXv_int25[19] = (byte)(1) ;
         GXv_int25[20] = (byte)(1) ;
         GXv_int25[21] = (byte)(1) ;
         GXv_int25[22] = (byte)(1) ;
         GXv_int25[23] = (byte)(1) ;
         GXv_int25[24] = (byte)(1) ;
         GXv_int25[25] = (byte)(1) ;
         GXv_int25[26] = (byte)(1) ;
         GXv_int25[27] = (byte)(1) ;
         GXv_int25[28] = (byte)(1) ;
         GXv_int25[29] = (byte)(1) ;
         GXv_int25[30] = (byte)(1) ;
         GXv_int25[31] = (byte)(1) ;
         GXv_int25[32] = (byte)(1) ;
         GXv_int25[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int25[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int25[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int25[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int25[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int25[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int25[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int25[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int25[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int25[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int25[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int25[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int25[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int25[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int25[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int25[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int25[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int25[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int25[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int25[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int25[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int25[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int25[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int25[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int25[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int25[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int25[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int25[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int25[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int25[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int25[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int25[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int25[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int25[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int25[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int25[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int25[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int25[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int25[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int25[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int25[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int25[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int25[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoNubefactResponse]" ;
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
   }

   protected Object[] conditional_P003B10( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A247PagoTipoDocumentoCliente ,
                                           GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           short A244PagoTipoDocumento ,
                                           GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           short A253PagoMoneda ,
                                           GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                           String A246PagoEstadoR ,
                                           GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                           String AV90Pagowwds_1_filterfulltext ,
                                           int AV91Pagowwds_2_tfpagoid ,
                                           int AV92Pagowwds_3_tfpagoid_to ,
                                           int AV93Pagowwds_4_tfcitaid ,
                                           int AV94Pagowwds_5_tfcitaid_to ,
                                           String AV96Pagowwds_7_tfcitacode_sel ,
                                           String AV95Pagowwds_6_tfcitacode ,
                                           java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                           java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                           String AV102Pagowwds_13_tfpagotoken_sel ,
                                           String AV101Pagowwds_12_tfpagotoken ,
                                           int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                           String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           String AV108Pagowwds_19_tfpagoclientedireccion ,
                                           String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           String AV110Pagowwds_21_tfpagoclienteemail ,
                                           int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                           int AV113Pagowwds_24_tfpagonumero ,
                                           int AV114Pagowwds_25_tfpagonumero_to ,
                                           java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                           java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                           int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                           String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           String AV118Pagowwds_29_tfpagonubefactrequest ,
                                           String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           String AV120Pagowwds_31_tfpagonubefactresponse ,
                                           String AV123Pagowwds_34_tfpagorequest_sel ,
                                           String AV122Pagowwds_33_tfpagorequest ,
                                           String AV125Pagowwds_36_tfpagoresponse_sel ,
                                           String AV124Pagowwds_35_tfpagoresponse ,
                                           String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           String AV126Pagowwds_37_tfpagopasarelaid ,
                                           int AV128Pagowwds_39_tfpagostatuscode ,
                                           int AV129Pagowwds_40_tfpagostatuscode_to ,
                                           int AV130Pagowwds_41_tfdisponibilidadid ,
                                           int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                           String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           String AV132Pagowwds_43_tfpagoenlacepdf ,
                                           String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           String AV134Pagowwds_45_tfpagoenlacexml ,
                                           int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                           int A47PagoId ,
                                           int A19CitaId ,
                                           String A64CitaCode ,
                                           java.math.BigDecimal A242PagoMonto ,
                                           String A243PagoToken ,
                                           String A248PagoClienteNroDocumento ,
                                           String A249PagoClienteDenominacion ,
                                           String A250PagoClienteDireccion ,
                                           String A251PagoClienteEmail ,
                                           int A245PagoNumero ,
                                           String A256PagoNubefactRequest ,
                                           String A257PagoNubefactResponse ,
                                           String A308PagoRequest ,
                                           String A309PagoResponse ,
                                           String A310PagoPasarelaId ,
                                           int A311PagoStatusCode ,
                                           int A34DisponibilidadId ,
                                           String A338PagoEnlacePDF ,
                                           String A339PagoEnlaceXML ,
                                           java.util.Date A66SGCitaDisponibilidadFecha ,
                                           java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int28 = new byte[76];
      Object[] GXv_Object29 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoRequest], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoResponse], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int28[0] = (byte)(1) ;
         GXv_int28[1] = (byte)(1) ;
         GXv_int28[2] = (byte)(1) ;
         GXv_int28[3] = (byte)(1) ;
         GXv_int28[4] = (byte)(1) ;
         GXv_int28[5] = (byte)(1) ;
         GXv_int28[6] = (byte)(1) ;
         GXv_int28[7] = (byte)(1) ;
         GXv_int28[8] = (byte)(1) ;
         GXv_int28[9] = (byte)(1) ;
         GXv_int28[10] = (byte)(1) ;
         GXv_int28[11] = (byte)(1) ;
         GXv_int28[12] = (byte)(1) ;
         GXv_int28[13] = (byte)(1) ;
         GXv_int28[14] = (byte)(1) ;
         GXv_int28[15] = (byte)(1) ;
         GXv_int28[16] = (byte)(1) ;
         GXv_int28[17] = (byte)(1) ;
         GXv_int28[18] = (byte)(1) ;
         GXv_int28[19] = (byte)(1) ;
         GXv_int28[20] = (byte)(1) ;
         GXv_int28[21] = (byte)(1) ;
         GXv_int28[22] = (byte)(1) ;
         GXv_int28[23] = (byte)(1) ;
         GXv_int28[24] = (byte)(1) ;
         GXv_int28[25] = (byte)(1) ;
         GXv_int28[26] = (byte)(1) ;
         GXv_int28[27] = (byte)(1) ;
         GXv_int28[28] = (byte)(1) ;
         GXv_int28[29] = (byte)(1) ;
         GXv_int28[30] = (byte)(1) ;
         GXv_int28[31] = (byte)(1) ;
         GXv_int28[32] = (byte)(1) ;
         GXv_int28[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int28[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int28[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int28[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int28[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int28[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int28[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int28[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int28[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int28[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int28[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int28[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int28[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int28[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int28[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int28[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int28[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int28[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int28[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int28[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int28[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int28[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int28[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int28[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int28[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int28[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int28[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int28[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int28[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int28[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int28[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int28[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int28[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int28[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int28[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int28[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int28[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int28[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int28[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int28[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int28[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int28[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int28[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoRequest]" ;
      GXv_Object29[0] = scmdbuf ;
      GXv_Object29[1] = GXv_int28 ;
      return GXv_Object29 ;
   }

   protected Object[] conditional_P003B11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A247PagoTipoDocumentoCliente ,
                                           GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           short A244PagoTipoDocumento ,
                                           GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           short A253PagoMoneda ,
                                           GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                           String A246PagoEstadoR ,
                                           GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                           String AV90Pagowwds_1_filterfulltext ,
                                           int AV91Pagowwds_2_tfpagoid ,
                                           int AV92Pagowwds_3_tfpagoid_to ,
                                           int AV93Pagowwds_4_tfcitaid ,
                                           int AV94Pagowwds_5_tfcitaid_to ,
                                           String AV96Pagowwds_7_tfcitacode_sel ,
                                           String AV95Pagowwds_6_tfcitacode ,
                                           java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                           java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                           String AV102Pagowwds_13_tfpagotoken_sel ,
                                           String AV101Pagowwds_12_tfpagotoken ,
                                           int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                           String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           String AV108Pagowwds_19_tfpagoclientedireccion ,
                                           String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           String AV110Pagowwds_21_tfpagoclienteemail ,
                                           int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                           int AV113Pagowwds_24_tfpagonumero ,
                                           int AV114Pagowwds_25_tfpagonumero_to ,
                                           java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                           java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                           int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                           String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           String AV118Pagowwds_29_tfpagonubefactrequest ,
                                           String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           String AV120Pagowwds_31_tfpagonubefactresponse ,
                                           String AV123Pagowwds_34_tfpagorequest_sel ,
                                           String AV122Pagowwds_33_tfpagorequest ,
                                           String AV125Pagowwds_36_tfpagoresponse_sel ,
                                           String AV124Pagowwds_35_tfpagoresponse ,
                                           String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           String AV126Pagowwds_37_tfpagopasarelaid ,
                                           int AV128Pagowwds_39_tfpagostatuscode ,
                                           int AV129Pagowwds_40_tfpagostatuscode_to ,
                                           int AV130Pagowwds_41_tfdisponibilidadid ,
                                           int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                           String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           String AV132Pagowwds_43_tfpagoenlacepdf ,
                                           String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           String AV134Pagowwds_45_tfpagoenlacexml ,
                                           int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                           int A47PagoId ,
                                           int A19CitaId ,
                                           String A64CitaCode ,
                                           java.math.BigDecimal A242PagoMonto ,
                                           String A243PagoToken ,
                                           String A248PagoClienteNroDocumento ,
                                           String A249PagoClienteDenominacion ,
                                           String A250PagoClienteDireccion ,
                                           String A251PagoClienteEmail ,
                                           int A245PagoNumero ,
                                           String A256PagoNubefactRequest ,
                                           String A257PagoNubefactResponse ,
                                           String A308PagoRequest ,
                                           String A309PagoResponse ,
                                           String A310PagoPasarelaId ,
                                           int A311PagoStatusCode ,
                                           int A34DisponibilidadId ,
                                           String A338PagoEnlacePDF ,
                                           String A339PagoEnlaceXML ,
                                           java.util.Date A66SGCitaDisponibilidadFecha ,
                                           java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int31 = new byte[76];
      Object[] GXv_Object32 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoResponse], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoPasarelaId]," ;
      scmdbuf += " T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int31[0] = (byte)(1) ;
         GXv_int31[1] = (byte)(1) ;
         GXv_int31[2] = (byte)(1) ;
         GXv_int31[3] = (byte)(1) ;
         GXv_int31[4] = (byte)(1) ;
         GXv_int31[5] = (byte)(1) ;
         GXv_int31[6] = (byte)(1) ;
         GXv_int31[7] = (byte)(1) ;
         GXv_int31[8] = (byte)(1) ;
         GXv_int31[9] = (byte)(1) ;
         GXv_int31[10] = (byte)(1) ;
         GXv_int31[11] = (byte)(1) ;
         GXv_int31[12] = (byte)(1) ;
         GXv_int31[13] = (byte)(1) ;
         GXv_int31[14] = (byte)(1) ;
         GXv_int31[15] = (byte)(1) ;
         GXv_int31[16] = (byte)(1) ;
         GXv_int31[17] = (byte)(1) ;
         GXv_int31[18] = (byte)(1) ;
         GXv_int31[19] = (byte)(1) ;
         GXv_int31[20] = (byte)(1) ;
         GXv_int31[21] = (byte)(1) ;
         GXv_int31[22] = (byte)(1) ;
         GXv_int31[23] = (byte)(1) ;
         GXv_int31[24] = (byte)(1) ;
         GXv_int31[25] = (byte)(1) ;
         GXv_int31[26] = (byte)(1) ;
         GXv_int31[27] = (byte)(1) ;
         GXv_int31[28] = (byte)(1) ;
         GXv_int31[29] = (byte)(1) ;
         GXv_int31[30] = (byte)(1) ;
         GXv_int31[31] = (byte)(1) ;
         GXv_int31[32] = (byte)(1) ;
         GXv_int31[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int31[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int31[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int31[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int31[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int31[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int31[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int31[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int31[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int31[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int31[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int31[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int31[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int31[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int31[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int31[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int31[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int31[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int31[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int31[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int31[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int31[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int31[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int31[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int31[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int31[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int31[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int31[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int31[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int31[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int31[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int31[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int31[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int31[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int31[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int31[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int31[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int31[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int31[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int31[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int31[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int31[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int31[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoResponse]" ;
      GXv_Object32[0] = scmdbuf ;
      GXv_Object32[1] = GXv_int31 ;
      return GXv_Object32 ;
   }

   protected Object[] conditional_P003B12( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A247PagoTipoDocumentoCliente ,
                                           GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           short A244PagoTipoDocumento ,
                                           GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           short A253PagoMoneda ,
                                           GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                           String A246PagoEstadoR ,
                                           GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                           String AV90Pagowwds_1_filterfulltext ,
                                           int AV91Pagowwds_2_tfpagoid ,
                                           int AV92Pagowwds_3_tfpagoid_to ,
                                           int AV93Pagowwds_4_tfcitaid ,
                                           int AV94Pagowwds_5_tfcitaid_to ,
                                           String AV96Pagowwds_7_tfcitacode_sel ,
                                           String AV95Pagowwds_6_tfcitacode ,
                                           java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                           java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                           String AV102Pagowwds_13_tfpagotoken_sel ,
                                           String AV101Pagowwds_12_tfpagotoken ,
                                           int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                           String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           String AV108Pagowwds_19_tfpagoclientedireccion ,
                                           String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           String AV110Pagowwds_21_tfpagoclienteemail ,
                                           int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                           int AV113Pagowwds_24_tfpagonumero ,
                                           int AV114Pagowwds_25_tfpagonumero_to ,
                                           java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                           java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                           int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                           String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           String AV118Pagowwds_29_tfpagonubefactrequest ,
                                           String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           String AV120Pagowwds_31_tfpagonubefactresponse ,
                                           String AV123Pagowwds_34_tfpagorequest_sel ,
                                           String AV122Pagowwds_33_tfpagorequest ,
                                           String AV125Pagowwds_36_tfpagoresponse_sel ,
                                           String AV124Pagowwds_35_tfpagoresponse ,
                                           String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           String AV126Pagowwds_37_tfpagopasarelaid ,
                                           int AV128Pagowwds_39_tfpagostatuscode ,
                                           int AV129Pagowwds_40_tfpagostatuscode_to ,
                                           int AV130Pagowwds_41_tfdisponibilidadid ,
                                           int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                           String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           String AV132Pagowwds_43_tfpagoenlacepdf ,
                                           String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           String AV134Pagowwds_45_tfpagoenlacexml ,
                                           int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                           int A47PagoId ,
                                           int A19CitaId ,
                                           String A64CitaCode ,
                                           java.math.BigDecimal A242PagoMonto ,
                                           String A243PagoToken ,
                                           String A248PagoClienteNroDocumento ,
                                           String A249PagoClienteDenominacion ,
                                           String A250PagoClienteDireccion ,
                                           String A251PagoClienteEmail ,
                                           int A245PagoNumero ,
                                           String A256PagoNubefactRequest ,
                                           String A257PagoNubefactResponse ,
                                           String A308PagoRequest ,
                                           String A309PagoResponse ,
                                           String A310PagoPasarelaId ,
                                           int A311PagoStatusCode ,
                                           int A34DisponibilidadId ,
                                           String A338PagoEnlacePDF ,
                                           String A339PagoEnlaceXML ,
                                           java.util.Date A66SGCitaDisponibilidadFecha ,
                                           java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int34 = new byte[76];
      Object[] GXv_Object35 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoPasarelaId], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[PagoResponse]," ;
      scmdbuf += " T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int34[0] = (byte)(1) ;
         GXv_int34[1] = (byte)(1) ;
         GXv_int34[2] = (byte)(1) ;
         GXv_int34[3] = (byte)(1) ;
         GXv_int34[4] = (byte)(1) ;
         GXv_int34[5] = (byte)(1) ;
         GXv_int34[6] = (byte)(1) ;
         GXv_int34[7] = (byte)(1) ;
         GXv_int34[8] = (byte)(1) ;
         GXv_int34[9] = (byte)(1) ;
         GXv_int34[10] = (byte)(1) ;
         GXv_int34[11] = (byte)(1) ;
         GXv_int34[12] = (byte)(1) ;
         GXv_int34[13] = (byte)(1) ;
         GXv_int34[14] = (byte)(1) ;
         GXv_int34[15] = (byte)(1) ;
         GXv_int34[16] = (byte)(1) ;
         GXv_int34[17] = (byte)(1) ;
         GXv_int34[18] = (byte)(1) ;
         GXv_int34[19] = (byte)(1) ;
         GXv_int34[20] = (byte)(1) ;
         GXv_int34[21] = (byte)(1) ;
         GXv_int34[22] = (byte)(1) ;
         GXv_int34[23] = (byte)(1) ;
         GXv_int34[24] = (byte)(1) ;
         GXv_int34[25] = (byte)(1) ;
         GXv_int34[26] = (byte)(1) ;
         GXv_int34[27] = (byte)(1) ;
         GXv_int34[28] = (byte)(1) ;
         GXv_int34[29] = (byte)(1) ;
         GXv_int34[30] = (byte)(1) ;
         GXv_int34[31] = (byte)(1) ;
         GXv_int34[32] = (byte)(1) ;
         GXv_int34[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int34[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int34[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int34[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int34[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int34[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int34[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int34[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int34[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int34[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int34[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int34[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int34[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int34[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int34[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int34[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int34[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int34[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int34[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int34[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int34[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int34[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int34[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int34[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int34[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int34[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int34[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int34[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int34[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int34[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int34[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int34[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int34[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int34[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int34[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int34[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int34[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int34[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int34[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int34[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int34[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int34[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int34[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoPasarelaId]" ;
      GXv_Object35[0] = scmdbuf ;
      GXv_Object35[1] = GXv_int34 ;
      return GXv_Object35 ;
   }

   protected Object[] conditional_P003B13( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A247PagoTipoDocumentoCliente ,
                                           GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           short A244PagoTipoDocumento ,
                                           GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           short A253PagoMoneda ,
                                           GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                           String A246PagoEstadoR ,
                                           GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                           String AV90Pagowwds_1_filterfulltext ,
                                           int AV91Pagowwds_2_tfpagoid ,
                                           int AV92Pagowwds_3_tfpagoid_to ,
                                           int AV93Pagowwds_4_tfcitaid ,
                                           int AV94Pagowwds_5_tfcitaid_to ,
                                           String AV96Pagowwds_7_tfcitacode_sel ,
                                           String AV95Pagowwds_6_tfcitacode ,
                                           java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                           java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                           String AV102Pagowwds_13_tfpagotoken_sel ,
                                           String AV101Pagowwds_12_tfpagotoken ,
                                           int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                           String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           String AV108Pagowwds_19_tfpagoclientedireccion ,
                                           String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           String AV110Pagowwds_21_tfpagoclienteemail ,
                                           int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                           int AV113Pagowwds_24_tfpagonumero ,
                                           int AV114Pagowwds_25_tfpagonumero_to ,
                                           java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                           java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                           int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                           String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           String AV118Pagowwds_29_tfpagonubefactrequest ,
                                           String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           String AV120Pagowwds_31_tfpagonubefactresponse ,
                                           String AV123Pagowwds_34_tfpagorequest_sel ,
                                           String AV122Pagowwds_33_tfpagorequest ,
                                           String AV125Pagowwds_36_tfpagoresponse_sel ,
                                           String AV124Pagowwds_35_tfpagoresponse ,
                                           String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           String AV126Pagowwds_37_tfpagopasarelaid ,
                                           int AV128Pagowwds_39_tfpagostatuscode ,
                                           int AV129Pagowwds_40_tfpagostatuscode_to ,
                                           int AV130Pagowwds_41_tfdisponibilidadid ,
                                           int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                           String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           String AV132Pagowwds_43_tfpagoenlacepdf ,
                                           String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           String AV134Pagowwds_45_tfpagoenlacexml ,
                                           int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                           int A47PagoId ,
                                           int A19CitaId ,
                                           String A64CitaCode ,
                                           java.math.BigDecimal A242PagoMonto ,
                                           String A243PagoToken ,
                                           String A248PagoClienteNroDocumento ,
                                           String A249PagoClienteDenominacion ,
                                           String A250PagoClienteDireccion ,
                                           String A251PagoClienteEmail ,
                                           int A245PagoNumero ,
                                           String A256PagoNubefactRequest ,
                                           String A257PagoNubefactResponse ,
                                           String A308PagoRequest ,
                                           String A309PagoResponse ,
                                           String A310PagoPasarelaId ,
                                           int A311PagoStatusCode ,
                                           int A34DisponibilidadId ,
                                           String A338PagoEnlacePDF ,
                                           String A339PagoEnlaceXML ,
                                           java.util.Date A66SGCitaDisponibilidadFecha ,
                                           java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int37 = new byte[76];
      Object[] GXv_Object38 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoEnlacePDF], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoPasarelaId], T1.[PagoResponse]," ;
      scmdbuf += " T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int37[0] = (byte)(1) ;
         GXv_int37[1] = (byte)(1) ;
         GXv_int37[2] = (byte)(1) ;
         GXv_int37[3] = (byte)(1) ;
         GXv_int37[4] = (byte)(1) ;
         GXv_int37[5] = (byte)(1) ;
         GXv_int37[6] = (byte)(1) ;
         GXv_int37[7] = (byte)(1) ;
         GXv_int37[8] = (byte)(1) ;
         GXv_int37[9] = (byte)(1) ;
         GXv_int37[10] = (byte)(1) ;
         GXv_int37[11] = (byte)(1) ;
         GXv_int37[12] = (byte)(1) ;
         GXv_int37[13] = (byte)(1) ;
         GXv_int37[14] = (byte)(1) ;
         GXv_int37[15] = (byte)(1) ;
         GXv_int37[16] = (byte)(1) ;
         GXv_int37[17] = (byte)(1) ;
         GXv_int37[18] = (byte)(1) ;
         GXv_int37[19] = (byte)(1) ;
         GXv_int37[20] = (byte)(1) ;
         GXv_int37[21] = (byte)(1) ;
         GXv_int37[22] = (byte)(1) ;
         GXv_int37[23] = (byte)(1) ;
         GXv_int37[24] = (byte)(1) ;
         GXv_int37[25] = (byte)(1) ;
         GXv_int37[26] = (byte)(1) ;
         GXv_int37[27] = (byte)(1) ;
         GXv_int37[28] = (byte)(1) ;
         GXv_int37[29] = (byte)(1) ;
         GXv_int37[30] = (byte)(1) ;
         GXv_int37[31] = (byte)(1) ;
         GXv_int37[32] = (byte)(1) ;
         GXv_int37[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int37[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int37[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int37[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int37[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int37[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int37[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int37[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int37[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int37[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int37[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int37[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int37[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int37[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int37[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int37[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int37[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int37[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int37[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int37[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int37[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int37[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int37[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int37[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int37[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int37[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int37[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int37[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int37[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int37[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int37[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int37[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int37[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int37[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int37[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int37[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int37[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int37[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int37[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int37[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int37[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int37[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int37[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoEnlacePDF]" ;
      GXv_Object38[0] = scmdbuf ;
      GXv_Object38[1] = GXv_int37 ;
      return GXv_Object38 ;
   }

   protected Object[] conditional_P003B14( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A247PagoTipoDocumentoCliente ,
                                           GXSimpleCollection<String> AV103Pagowwds_14_tfpagotipodocumentocliente_sels ,
                                           short A244PagoTipoDocumento ,
                                           GXSimpleCollection<Short> AV112Pagowwds_23_tfpagotipodocumento_sels ,
                                           short A253PagoMoneda ,
                                           GXSimpleCollection<Short> AV117Pagowwds_28_tfpagomoneda_sels ,
                                           String A246PagoEstadoR ,
                                           GXSimpleCollection<String> AV136Pagowwds_47_tfpagoestador_sels ,
                                           String AV90Pagowwds_1_filterfulltext ,
                                           int AV91Pagowwds_2_tfpagoid ,
                                           int AV92Pagowwds_3_tfpagoid_to ,
                                           int AV93Pagowwds_4_tfcitaid ,
                                           int AV94Pagowwds_5_tfcitaid_to ,
                                           String AV96Pagowwds_7_tfcitacode_sel ,
                                           String AV95Pagowwds_6_tfcitacode ,
                                           java.util.Date AV97Pagowwds_8_tfsgcitadisponibilidadfecha ,
                                           java.util.Date AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to ,
                                           java.math.BigDecimal AV99Pagowwds_10_tfpagomonto ,
                                           java.math.BigDecimal AV100Pagowwds_11_tfpagomonto_to ,
                                           String AV102Pagowwds_13_tfpagotoken_sel ,
                                           String AV101Pagowwds_12_tfpagotoken ,
                                           int AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size ,
                                           String AV105Pagowwds_16_tfpagoclientenrodocumento_sel ,
                                           String AV104Pagowwds_15_tfpagoclientenrodocumento ,
                                           String AV107Pagowwds_18_tfpagoclientedenominacion_sel ,
                                           String AV106Pagowwds_17_tfpagoclientedenominacion ,
                                           String AV109Pagowwds_20_tfpagoclientedireccion_sel ,
                                           String AV108Pagowwds_19_tfpagoclientedireccion ,
                                           String AV111Pagowwds_22_tfpagoclienteemail_sel ,
                                           String AV110Pagowwds_21_tfpagoclienteemail ,
                                           int AV112Pagowwds_23_tfpagotipodocumento_sels_size ,
                                           int AV113Pagowwds_24_tfpagonumero ,
                                           int AV114Pagowwds_25_tfpagonumero_to ,
                                           java.util.Date AV115Pagowwds_26_tfpagofechaemision ,
                                           java.util.Date AV116Pagowwds_27_tfpagofechaemision_to ,
                                           int AV117Pagowwds_28_tfpagomoneda_sels_size ,
                                           String AV119Pagowwds_30_tfpagonubefactrequest_sel ,
                                           String AV118Pagowwds_29_tfpagonubefactrequest ,
                                           String AV121Pagowwds_32_tfpagonubefactresponse_sel ,
                                           String AV120Pagowwds_31_tfpagonubefactresponse ,
                                           String AV123Pagowwds_34_tfpagorequest_sel ,
                                           String AV122Pagowwds_33_tfpagorequest ,
                                           String AV125Pagowwds_36_tfpagoresponse_sel ,
                                           String AV124Pagowwds_35_tfpagoresponse ,
                                           String AV127Pagowwds_38_tfpagopasarelaid_sel ,
                                           String AV126Pagowwds_37_tfpagopasarelaid ,
                                           int AV128Pagowwds_39_tfpagostatuscode ,
                                           int AV129Pagowwds_40_tfpagostatuscode_to ,
                                           int AV130Pagowwds_41_tfdisponibilidadid ,
                                           int AV131Pagowwds_42_tfdisponibilidadid_to ,
                                           String AV133Pagowwds_44_tfpagoenlacepdf_sel ,
                                           String AV132Pagowwds_43_tfpagoenlacepdf ,
                                           String AV135Pagowwds_46_tfpagoenlacexml_sel ,
                                           String AV134Pagowwds_45_tfpagoenlacexml ,
                                           int AV136Pagowwds_47_tfpagoestador_sels_size ,
                                           int A47PagoId ,
                                           int A19CitaId ,
                                           String A64CitaCode ,
                                           java.math.BigDecimal A242PagoMonto ,
                                           String A243PagoToken ,
                                           String A248PagoClienteNroDocumento ,
                                           String A249PagoClienteDenominacion ,
                                           String A250PagoClienteDireccion ,
                                           String A251PagoClienteEmail ,
                                           int A245PagoNumero ,
                                           String A256PagoNubefactRequest ,
                                           String A257PagoNubefactResponse ,
                                           String A308PagoRequest ,
                                           String A309PagoResponse ,
                                           String A310PagoPasarelaId ,
                                           int A311PagoStatusCode ,
                                           int A34DisponibilidadId ,
                                           String A338PagoEnlacePDF ,
                                           String A339PagoEnlaceXML ,
                                           java.util.Date A66SGCitaDisponibilidadFecha ,
                                           java.util.Date A252PagoFechaEmision )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int40 = new byte[76];
      Object[] GXv_Object41 = new Object[2];
      scmdbuf = "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoEnlaceXML], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoFechaEmision], T1.[PagoNumero]," ;
      scmdbuf += " T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[PagoId], T1.[PagoEstadoR], T1.[PagoEnlacePDF], T1.[PagoPasarelaId], T1.[PagoResponse]," ;
      scmdbuf += " T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion]," ;
      scmdbuf += " T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON" ;
      scmdbuf += " T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId])" ;
      if ( ! (GXutil.strcmp("", AV90Pagowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(8), CAST(T1.[PagoId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( T2.[CitaCode] like '%' + ?) or ( CONVERT( char(6), CAST(T1.[PagoMonto] AS decimal(6,2))) like '%' + ?) or ( T1.[PagoToken] like '%' + ?) or ( 'ruc' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '6') or ( 'dni' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '1') or ( 'carnet de ext.' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '4') or ( 'pasaporte' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '7') or ( 'cdi' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = 'A') or ( 'no domiciliado' like '%' + LOWER(?) and T1.[PagoTipoDocumentoCliente] = '0') or ( T1.[PagoClienteNroDocumento] like '%' + ?) or ( T1.[PagoClienteDenominacion] like '%' + ?) or ( T1.[PagoClienteDireccion] like '%' + ?) or ( T1.[PagoClienteEmail] like '%' + ?) or ( 'factura' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 1) or ( 'boleta' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 2) or ( 'nota credito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 3) or ( 'nota debito' like '%' + LOWER(?) and T1.[PagoTipoDocumento] = 4) or ( CONVERT( char(8), CAST(T1.[PagoNumero] AS decimal(8,0))) like '%' + ?) or ( 'soles' like '%' + LOWER(?) and T1.[PagoMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and T1.[PagoMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and T1.[PagoMoneda] = 3) or ( T1.[PagoNubefactRequest] like '%' + ?) or ( T1.[PagoNubefactResponse] like '%' + ?) or ( T1.[PagoRequest] like '%' + ?) or ( T1.[PagoResponse] like '%' + ?) or ( T1.[PagoPasarelaId] like '%' + ?) or ( CONVERT( char(8), CAST(T1.[PagoStatusCode] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[DisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( T1.[PagoEnlacePDF] like '%' + ?) or ( T1.[PagoEnlaceXML] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[PagoEstadoR] = 'I'))");
      }
      else
      {
         GXv_int40[0] = (byte)(1) ;
         GXv_int40[1] = (byte)(1) ;
         GXv_int40[2] = (byte)(1) ;
         GXv_int40[3] = (byte)(1) ;
         GXv_int40[4] = (byte)(1) ;
         GXv_int40[5] = (byte)(1) ;
         GXv_int40[6] = (byte)(1) ;
         GXv_int40[7] = (byte)(1) ;
         GXv_int40[8] = (byte)(1) ;
         GXv_int40[9] = (byte)(1) ;
         GXv_int40[10] = (byte)(1) ;
         GXv_int40[11] = (byte)(1) ;
         GXv_int40[12] = (byte)(1) ;
         GXv_int40[13] = (byte)(1) ;
         GXv_int40[14] = (byte)(1) ;
         GXv_int40[15] = (byte)(1) ;
         GXv_int40[16] = (byte)(1) ;
         GXv_int40[17] = (byte)(1) ;
         GXv_int40[18] = (byte)(1) ;
         GXv_int40[19] = (byte)(1) ;
         GXv_int40[20] = (byte)(1) ;
         GXv_int40[21] = (byte)(1) ;
         GXv_int40[22] = (byte)(1) ;
         GXv_int40[23] = (byte)(1) ;
         GXv_int40[24] = (byte)(1) ;
         GXv_int40[25] = (byte)(1) ;
         GXv_int40[26] = (byte)(1) ;
         GXv_int40[27] = (byte)(1) ;
         GXv_int40[28] = (byte)(1) ;
         GXv_int40[29] = (byte)(1) ;
         GXv_int40[30] = (byte)(1) ;
         GXv_int40[31] = (byte)(1) ;
         GXv_int40[32] = (byte)(1) ;
         GXv_int40[33] = (byte)(1) ;
      }
      if ( ! (0==AV91Pagowwds_2_tfpagoid) )
      {
         addWhere(sWhereString, "(T1.[PagoId] >= ?)");
      }
      else
      {
         GXv_int40[34] = (byte)(1) ;
      }
      if ( ! (0==AV92Pagowwds_3_tfpagoid_to) )
      {
         addWhere(sWhereString, "(T1.[PagoId] <= ?)");
      }
      else
      {
         GXv_int40[35] = (byte)(1) ;
      }
      if ( ! (0==AV93Pagowwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int40[36] = (byte)(1) ;
      }
      if ( ! (0==AV94Pagowwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int40[37] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV95Pagowwds_6_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] like ?)");
      }
      else
      {
         GXv_int40[38] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Pagowwds_7_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[CitaCode] = ?)");
      }
      else
      {
         GXv_int40[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV97Pagowwds_8_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int40[40] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV98Pagowwds_9_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int40[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Pagowwds_10_tfpagomonto)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] >= ?)");
      }
      else
      {
         GXv_int40[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV100Pagowwds_11_tfpagomonto_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoMonto] <= ?)");
      }
      else
      {
         GXv_int40[43] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) && ( ! (GXutil.strcmp("", AV101Pagowwds_12_tfpagotoken)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] like ?)");
      }
      else
      {
         GXv_int40[44] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Pagowwds_13_tfpagotoken_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoToken] = ?)");
      }
      else
      {
         GXv_int40[45] = (byte)(1) ;
      }
      if ( AV103Pagowwds_14_tfpagotipodocumentocliente_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Pagowwds_14_tfpagotipodocumentocliente_sels, "T1.[PagoTipoDocumentoCliente] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV104Pagowwds_15_tfpagoclientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int40[46] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV105Pagowwds_16_tfpagoclientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int40[47] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) && ( ! (GXutil.strcmp("", AV106Pagowwds_17_tfpagoclientedenominacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] like ?)");
      }
      else
      {
         GXv_int40[48] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV107Pagowwds_18_tfpagoclientedenominacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDenominacion] = ?)");
      }
      else
      {
         GXv_int40[49] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) && ( ! (GXutil.strcmp("", AV108Pagowwds_19_tfpagoclientedireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] like ?)");
      }
      else
      {
         GXv_int40[50] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Pagowwds_20_tfpagoclientedireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteDireccion] = ?)");
      }
      else
      {
         GXv_int40[51] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) && ( ! (GXutil.strcmp("", AV110Pagowwds_21_tfpagoclienteemail)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] like ?)");
      }
      else
      {
         GXv_int40[52] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV111Pagowwds_22_tfpagoclienteemail_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoClienteEmail] = ?)");
      }
      else
      {
         GXv_int40[53] = (byte)(1) ;
      }
      if ( AV112Pagowwds_23_tfpagotipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Pagowwds_23_tfpagotipodocumento_sels, "T1.[PagoTipoDocumento] IN (", ")")+")");
      }
      if ( ! (0==AV113Pagowwds_24_tfpagonumero) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] >= ?)");
      }
      else
      {
         GXv_int40[54] = (byte)(1) ;
      }
      if ( ! (0==AV114Pagowwds_25_tfpagonumero_to) )
      {
         addWhere(sWhereString, "(T1.[PagoNumero] <= ?)");
      }
      else
      {
         GXv_int40[55] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV115Pagowwds_26_tfpagofechaemision)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] >= ?)");
      }
      else
      {
         GXv_int40[56] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV116Pagowwds_27_tfpagofechaemision_to)) )
      {
         addWhere(sWhereString, "(T1.[PagoFechaEmision] <= ?)");
      }
      else
      {
         GXv_int40[57] = (byte)(1) ;
      }
      if ( AV117Pagowwds_28_tfpagomoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV117Pagowwds_28_tfpagomoneda_sels, "T1.[PagoMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) && ( ! (GXutil.strcmp("", AV118Pagowwds_29_tfpagonubefactrequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] like ?)");
      }
      else
      {
         GXv_int40[58] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV119Pagowwds_30_tfpagonubefactrequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactRequest] = ?)");
      }
      else
      {
         GXv_int40[59] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) && ( ! (GXutil.strcmp("", AV120Pagowwds_31_tfpagonubefactresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] like ?)");
      }
      else
      {
         GXv_int40[60] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV121Pagowwds_32_tfpagonubefactresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoNubefactResponse] = ?)");
      }
      else
      {
         GXv_int40[61] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) && ( ! (GXutil.strcmp("", AV122Pagowwds_33_tfpagorequest)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] like ?)");
      }
      else
      {
         GXv_int40[62] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV123Pagowwds_34_tfpagorequest_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoRequest] = ?)");
      }
      else
      {
         GXv_int40[63] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) && ( ! (GXutil.strcmp("", AV124Pagowwds_35_tfpagoresponse)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] like ?)");
      }
      else
      {
         GXv_int40[64] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV125Pagowwds_36_tfpagoresponse_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoResponse] = ?)");
      }
      else
      {
         GXv_int40[65] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) && ( ! (GXutil.strcmp("", AV126Pagowwds_37_tfpagopasarelaid)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] like ?)");
      }
      else
      {
         GXv_int40[66] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV127Pagowwds_38_tfpagopasarelaid_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoPasarelaId] = ?)");
      }
      else
      {
         GXv_int40[67] = (byte)(1) ;
      }
      if ( ! (0==AV128Pagowwds_39_tfpagostatuscode) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] >= ?)");
      }
      else
      {
         GXv_int40[68] = (byte)(1) ;
      }
      if ( ! (0==AV129Pagowwds_40_tfpagostatuscode_to) )
      {
         addWhere(sWhereString, "(T1.[PagoStatusCode] <= ?)");
      }
      else
      {
         GXv_int40[69] = (byte)(1) ;
      }
      if ( ! (0==AV130Pagowwds_41_tfdisponibilidadid) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int40[70] = (byte)(1) ;
      }
      if ( ! (0==AV131Pagowwds_42_tfdisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T1.[DisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int40[71] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) && ( ! (GXutil.strcmp("", AV132Pagowwds_43_tfpagoenlacepdf)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] like ?)");
      }
      else
      {
         GXv_int40[72] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV133Pagowwds_44_tfpagoenlacepdf_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlacePDF] = ?)");
      }
      else
      {
         GXv_int40[73] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) && ( ! (GXutil.strcmp("", AV134Pagowwds_45_tfpagoenlacexml)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] like ?)");
      }
      else
      {
         GXv_int40[74] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV135Pagowwds_46_tfpagoenlacexml_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PagoEnlaceXML] = ?)");
      }
      else
      {
         GXv_int40[75] = (byte)(1) ;
      }
      if ( AV136Pagowwds_47_tfpagoestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV136Pagowwds_47_tfpagoestador_sels, "T1.[PagoEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PagoEnlaceXML]" ;
      GXv_Object41[0] = scmdbuf ;
      GXv_Object41[1] = GXv_int40 ;
      return GXv_Object41 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P003B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 1 :
                  return conditional_P003B3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 2 :
                  return conditional_P003B4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 3 :
                  return conditional_P003B5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 4 :
                  return conditional_P003B6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 5 :
                  return conditional_P003B7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 6 :
                  return conditional_P003B8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 7 :
                  return conditional_P003B9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 8 :
                  return conditional_P003B10(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 9 :
                  return conditional_P003B11(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 10 :
                  return conditional_P003B12(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 11 :
                  return conditional_P003B13(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
            case 12 :
                  return conditional_P003B14(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , (java.util.Date)dynConstraints[33] , (java.util.Date)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , (String)dynConstraints[51] , (String)dynConstraints[52] , (String)dynConstraints[53] , ((Number) dynConstraints[54]).intValue() , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (String)dynConstraints[59] , (String)dynConstraints[60] , (String)dynConstraints[61] , (String)dynConstraints[62] , (String)dynConstraints[63] , ((Number) dynConstraints[64]).intValue() , (String)dynConstraints[65] , (String)dynConstraints[66] , (String)dynConstraints[67] , (String)dynConstraints[68] , (String)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , (String)dynConstraints[72] , (String)dynConstraints[73] , (java.util.Date)dynConstraints[74] , (java.util.Date)dynConstraints[75] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B10", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B12", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B13", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003B14", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getVarchar(24);
               ((String[]) buf[27])[0] = rslt.getString(25, 1);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 1);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(17);
               ((short[]) buf[20])[0] = rslt.getShort(18);
               ((short[]) buf[21])[0] = rslt.getShort(19);
               ((String[]) buf[22])[0] = rslt.getVarchar(20);
               ((String[]) buf[23])[0] = rslt.getVarchar(21);
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((String[]) buf[25])[0] = rslt.getVarchar(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 9 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 10 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 11 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
            case 12 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[92], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[93], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[94], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[95], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[96], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[97], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[104], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[105], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[108], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[109], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[110]).intValue());
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[111]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[112]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[113]).intValue());
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[114], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[115], 100);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[116]);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[117]);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[118], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[119], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[120], 40);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[121], 40);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[122], 40);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[123], 40);
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[124], 100);
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[125], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[126], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[127], 100);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[128], 100);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[129], 100);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[130]).intValue());
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[131]).intValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[132]);
               }
               if ( ((Number) parms[57]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[133]);
               }
               if ( ((Number) parms[58]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[134], 200);
               }
               if ( ((Number) parms[59]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[135], 200);
               }
               if ( ((Number) parms[60]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[136], 200);
               }
               if ( ((Number) parms[61]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[137], 200);
               }
               if ( ((Number) parms[62]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[138], 200);
               }
               if ( ((Number) parms[63]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[139], 200);
               }
               if ( ((Number) parms[64]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[140], 200);
               }
               if ( ((Number) parms[65]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[141], 200);
               }
               if ( ((Number) parms[66]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[142], 100);
               }
               if ( ((Number) parms[67]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[143], 100);
               }
               if ( ((Number) parms[68]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[144]).intValue());
               }
               if ( ((Number) parms[69]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[145]).intValue());
               }
               if ( ((Number) parms[70]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[146]).intValue());
               }
               if ( ((Number) parms[71]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[147]).intValue());
               }
               if ( ((Number) parms[72]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[148], 1000);
               }
               if ( ((Number) parms[73]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[149], 1000);
               }
               if ( ((Number) parms[74]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[150], 1000);
               }
               if ( ((Number) parms[75]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[151], 1000);
               }
               return;
      }
   }

}

