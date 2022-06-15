package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class encuestawwgetfilterdata extends GXProcedure
{
   public encuestawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( encuestawwgetfilterdata.class ), "" );
   }

   public encuestawwgetfilterdata( int remoteHandle ,
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
      encuestawwgetfilterdata.this.aP5 = new String[] {""};
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
      encuestawwgetfilterdata.this.AV53DDOName = aP0;
      encuestawwgetfilterdata.this.AV51SearchTxt = aP1;
      encuestawwgetfilterdata.this.AV52SearchTxtTo = aP2;
      encuestawwgetfilterdata.this.aP3 = aP3;
      encuestawwgetfilterdata.this.aP4 = aP4;
      encuestawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV56Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta", GXv_boolean2) ;
      encuestawwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV53DDOName), "DDO_SGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSGCITADISPONIBILIDADPROFULLNAMEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV53DDOName), "DDO_SGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADSGCITADISPONIBILIDADESPECIALIDADNOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV53DDOName), "DDO_PACIENTEAPELLIDOPATERNO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTEAPELLIDOPATERNOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV53DDOName), "DDO_PACIENTEAPELLIDOMATERNO") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTEAPELLIDOMATERNOOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV53DDOName), "DDO_PACIENTENOMBRES") == 0 )
         {
            /* Execute user subroutine: 'LOADPACIENTENOMBRESOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV53DDOName), "DDO_SGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADSGCITADISPONIBILIDADCLINICANOMBREOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV53DDOName), "DDO_ENCUESTACOMENTARIOS") == 0 )
         {
            /* Execute user subroutine: 'LOADENCUESTACOMENTARIOSOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV57OptionsJson = AV56Options.toJSonString(false) ;
      AV60OptionsDescJson = AV59OptionsDesc.toJSonString(false) ;
      AV62OptionIndexesJson = AV61OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV64Session.getValue("EncuestaWWGridState"), "") == 0 )
      {
         AV66GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EncuestaWWGridState"), null, null);
      }
      else
      {
         AV66GridState.fromxml(AV64Session.getValue("EncuestaWWGridState"), null, null);
      }
      AV73GXV1 = 1 ;
      while ( AV73GXV1 <= AV66GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV67GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV66GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV73GXV1));
         if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV69FilterFullText = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAID") == 0 )
         {
            AV11TFEncuestaId = (short)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFEncuestaId_To = (short)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV13TFCitaId = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFCitaId_To = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFESIONALID") == 0 )
         {
            AV15TFSGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV16TFSGCitaDisponibilidadProfesionalId_To = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME") == 0 )
         {
            AV17TFSGCitaDisponibilidadProFullName = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADPROFULLNAME_SEL") == 0 )
         {
            AV18TFSGCitaDisponibilidadProFullName_Sel = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADID") == 0 )
         {
            AV19TFSGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFSGCitaDisponibilidadEspecialidadId_To = (short)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV21TFSGCitaDisponibilidadEspecialidadNombre = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADID") == 0 )
         {
            AV23TFSGCitaDisponibilidadId = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFSGCitaDisponibilidadId_To = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV25TFSGCitaDisponibilidadFecha = localUtil.ctod( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV26TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEID") == 0 )
         {
            AV27TFPacienteId = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV28TFPacienteId_To = (int)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV29TFPacienteApellidoPaterno = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV30TFPacienteApellidoPaterno_Sel = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV31TFPacienteApellidoMaterno = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV32TFPacienteApellidoMaterno_Sel = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV33TFPacienteNombres = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV34TFPacienteNombres_Sel = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICAID") == 0 )
         {
            AV35TFSGCitaDisponibilidadClinicaId = (short)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFSGCitaDisponibilidadClinicaId_To = (short)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV37TFSGCitaDisponibilidadClinicaNombre = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV70TFSGCitaDisponibilidadClinicaNombre_Sel = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENCION_SEL") == 0 )
         {
            AV39TFEncuestaAtencion_SelsJson = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFEncuestaAtencion_Sels.fromJSonString(AV39TFEncuestaAtencion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAATENDIDO_SEL") == 0 )
         {
            AV41TFEncuestaAtendido_SelsJson = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFEncuestaAtendido_Sels.fromJSonString(AV41TFEncuestaAtendido_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAHORAATENCION") == 0 )
         {
            AV43TFEncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV44TFEncuestaHoraAtencion_To = GXutil.resetDate(localUtil.ctot( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS") == 0 )
         {
            AV45TFEncuestaComentarios = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTACOMENTARIOS_SEL") == 0 )
         {
            AV46TFEncuestaComentarios_Sel = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTARECOMENDACION") == 0 )
         {
            AV47TFEncuestaRecomendacion = (byte)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV48TFEncuestaRecomendacion_To = (byte)(GXutil.lval( AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFENCUESTAESTADO_SEL") == 0 )
         {
            AV49TFEncuestaEstado_SelsJson = AV67GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFEncuestaEstado_Sels.fromJSonString(AV49TFEncuestaEstado_SelsJson, null);
         }
         AV73GXV1 = (int)(AV73GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSGCITADISPONIBILIDADPROFULLNAMEOPTIONS' Routine */
      returnInSub = false ;
      AV17TFSGCitaDisponibilidadProFullName = AV51SearchTxt ;
      AV18TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV75Encuestawwds_1_filterfulltext = AV69FilterFullText ;
      AV76Encuestawwds_2_tfencuestaid = AV11TFEncuestaId ;
      AV77Encuestawwds_3_tfencuestaid_to = AV12TFEncuestaId_To ;
      AV78Encuestawwds_4_tfcitaid = AV13TFCitaId ;
      AV79Encuestawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV15TFSGCitaDisponibilidadProfesionalId ;
      AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV16TFSGCitaDisponibilidadProfesionalId_To ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV17TFSGCitaDisponibilidadProFullName ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV18TFSGCitaDisponibilidadProFullName_Sel ;
      AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV19TFSGCitaDisponibilidadEspecialidadId ;
      AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV20TFSGCitaDisponibilidadEspecialidadId_To ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV21TFSGCitaDisponibilidadEspecialidadNombre ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV88Encuestawwds_14_tfsgcitadisponibilidadid = AV23TFSGCitaDisponibilidadId ;
      AV89Encuestawwds_15_tfsgcitadisponibilidadid_to = AV24TFSGCitaDisponibilidadId_To ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = AV25TFSGCitaDisponibilidadFecha ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV26TFSGCitaDisponibilidadFecha_To ;
      AV92Encuestawwds_18_tfpacienteid = AV27TFPacienteId ;
      AV93Encuestawwds_19_tfpacienteid_to = AV28TFPacienteId_To ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV98Encuestawwds_24_tfpacientenombres = AV33TFPacienteNombres ;
      AV99Encuestawwds_25_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV35TFSGCitaDisponibilidadClinicaId ;
      AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV36TFSGCitaDisponibilidadClinicaId_To ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV37TFSGCitaDisponibilidadClinicaNombre ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = AV40TFEncuestaAtencion_Sels ;
      AV105Encuestawwds_31_tfencuestaatendido_sels = AV42TFEncuestaAtendido_Sels ;
      AV106Encuestawwds_32_tfencuestahoraatencion = AV43TFEncuestaHoraAtencion ;
      AV107Encuestawwds_33_tfencuestahoraatencion_to = AV44TFEncuestaHoraAtencion_To ;
      AV108Encuestawwds_34_tfencuestacomentarios = AV45TFEncuestaComentarios ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = AV46TFEncuestaComentarios_Sel ;
      AV110Encuestawwds_36_tfencuestarecomendacion = AV47TFEncuestaRecomendacion ;
      AV111Encuestawwds_37_tfencuestarecomendacion_to = AV48TFEncuestaRecomendacion_To ;
      AV112Encuestawwds_38_tfencuestaestado_sels = AV50TFEncuestaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV112Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV76Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV78Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV92Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to) ,
                                           AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV99Encuestawwds_25_tfpacientenombres_sel ,
                                           AV98Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV104Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV105Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV106Encuestawwds_32_tfencuestahoraatencion ,
                                           AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV108Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV112Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           AV75Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV96Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV98Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV108Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P00312 */
      pr_default.execute(0, new Object[] {AV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, Short.valueOf(AV76Encuestawwds_2_tfencuestaid), Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV78Encuestawwds_4_tfcitaid), Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to), AV90Encuestawwds_16_tfsgcitadisponibilidadfecha, AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV92Encuestawwds_18_tfpacienteid), Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to), lV94Encuestawwds_20_tfpacienteapellidopaterno, AV95Encuestawwds_21_tfpacienteapellidopaterno_sel, lV96Encuestawwds_22_tfpacienteapellidomaterno, AV97Encuestawwds_23_tfpacienteapellidomaterno_sel, lV98Encuestawwds_24_tfpacientenombres, AV99Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV106Encuestawwds_32_tfencuestahoraatencion, AV107Encuestawwds_33_tfencuestahoraatencion_to, lV108Encuestawwds_34_tfencuestacomentarios, AV109Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk312 = false ;
         A72SGCitaDisponibilidadSedeId = P00312_A72SGCitaDisponibilidadSedeId[0] ;
         A82SGCitaDisponibilidadProFullName = P00312_A82SGCitaDisponibilidadProFullName[0] ;
         A152EncuestaRecomendacion = P00312_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P00312_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P00312_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P00312_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P00312_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P00312_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00312_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00312_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00312_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00312_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P00312_A19CitaId[0] ;
         A37EncuestaId = P00312_A37EncuestaId[0] ;
         A153EncuestaEstado = P00312_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P00312_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P00312_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P00312_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P00312_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P00312_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P00312_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P00312_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00312_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P00312_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00312_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00312_A103PacienteApellidoPaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00312_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00312_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00312_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00312_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00312_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00312_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00312_n86ProfesionalApellidoMaterno[0] ;
         A82SGCitaDisponibilidadProFullName = P00312_A82SGCitaDisponibilidadProFullName[0] ;
         A20PacienteId = P00312_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P00312_A21SGCitaDisponibilidadId[0] ;
         A105PacienteNombres = P00312_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00312_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00312_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P00312_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P00312_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00312_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00312_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00312_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00312_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00312_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00312_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00312_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00312_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00312_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00312_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00312_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00312_n86ProfesionalApellidoMaterno[0] ;
         AV63count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00312_A82SGCitaDisponibilidadProFullName[0], A82SGCitaDisponibilidadProFullName) == 0 ) )
         {
            brk312 = false ;
            A21SGCitaDisponibilidadId = P00312_A21SGCitaDisponibilidadId[0] ;
            A81SGCitaDisponibilidadProfesionalId = P00312_A81SGCitaDisponibilidadProfesionalId[0] ;
            A19CitaId = P00312_A19CitaId[0] ;
            A37EncuestaId = P00312_A37EncuestaId[0] ;
            A84ProfesionalNombres = P00312_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = P00312_n84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = P00312_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = P00312_n85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = P00312_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = P00312_n86ProfesionalApellidoMaterno[0] ;
            A21SGCitaDisponibilidadId = P00312_A21SGCitaDisponibilidadId[0] ;
            A81SGCitaDisponibilidadProfesionalId = P00312_A81SGCitaDisponibilidadProfesionalId[0] ;
            A84ProfesionalNombres = P00312_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = P00312_n84ProfesionalNombres[0] ;
            A85ProfesionalApellidoPaterno = P00312_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = P00312_n85ProfesionalApellidoPaterno[0] ;
            A86ProfesionalApellidoMaterno = P00312_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = P00312_n86ProfesionalApellidoMaterno[0] ;
            AV63count = (long)(AV63count+1) ;
            brk312 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A82SGCitaDisponibilidadProFullName)==0) )
         {
            AV55Option = A82SGCitaDisponibilidadProFullName ;
            AV56Options.add(AV55Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV63count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV56Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk312 )
         {
            brk312 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSGCITADISPONIBILIDADESPECIALIDADNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV21TFSGCitaDisponibilidadEspecialidadNombre = AV51SearchTxt ;
      AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV75Encuestawwds_1_filterfulltext = AV69FilterFullText ;
      AV76Encuestawwds_2_tfencuestaid = AV11TFEncuestaId ;
      AV77Encuestawwds_3_tfencuestaid_to = AV12TFEncuestaId_To ;
      AV78Encuestawwds_4_tfcitaid = AV13TFCitaId ;
      AV79Encuestawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV15TFSGCitaDisponibilidadProfesionalId ;
      AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV16TFSGCitaDisponibilidadProfesionalId_To ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV17TFSGCitaDisponibilidadProFullName ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV18TFSGCitaDisponibilidadProFullName_Sel ;
      AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV19TFSGCitaDisponibilidadEspecialidadId ;
      AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV20TFSGCitaDisponibilidadEspecialidadId_To ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV21TFSGCitaDisponibilidadEspecialidadNombre ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV88Encuestawwds_14_tfsgcitadisponibilidadid = AV23TFSGCitaDisponibilidadId ;
      AV89Encuestawwds_15_tfsgcitadisponibilidadid_to = AV24TFSGCitaDisponibilidadId_To ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = AV25TFSGCitaDisponibilidadFecha ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV26TFSGCitaDisponibilidadFecha_To ;
      AV92Encuestawwds_18_tfpacienteid = AV27TFPacienteId ;
      AV93Encuestawwds_19_tfpacienteid_to = AV28TFPacienteId_To ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV98Encuestawwds_24_tfpacientenombres = AV33TFPacienteNombres ;
      AV99Encuestawwds_25_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV35TFSGCitaDisponibilidadClinicaId ;
      AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV36TFSGCitaDisponibilidadClinicaId_To ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV37TFSGCitaDisponibilidadClinicaNombre ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = AV40TFEncuestaAtencion_Sels ;
      AV105Encuestawwds_31_tfencuestaatendido_sels = AV42TFEncuestaAtendido_Sels ;
      AV106Encuestawwds_32_tfencuestahoraatencion = AV43TFEncuestaHoraAtencion ;
      AV107Encuestawwds_33_tfencuestahoraatencion_to = AV44TFEncuestaHoraAtencion_To ;
      AV108Encuestawwds_34_tfencuestacomentarios = AV45TFEncuestaComentarios ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = AV46TFEncuestaComentarios_Sel ;
      AV110Encuestawwds_36_tfencuestarecomendacion = AV47TFEncuestaRecomendacion ;
      AV111Encuestawwds_37_tfencuestarecomendacion_to = AV48TFEncuestaRecomendacion_To ;
      AV112Encuestawwds_38_tfencuestaestado_sels = AV50TFEncuestaEstado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV112Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV76Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV78Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV92Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to) ,
                                           AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV99Encuestawwds_25_tfpacientenombres_sel ,
                                           AV98Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV104Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV105Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV106Encuestawwds_32_tfencuestahoraatencion ,
                                           AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV108Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV112Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           AV75Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV96Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV98Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV108Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P00313 */
      pr_default.execute(1, new Object[] {AV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, Short.valueOf(AV76Encuestawwds_2_tfencuestaid), Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV78Encuestawwds_4_tfcitaid), Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to), AV90Encuestawwds_16_tfsgcitadisponibilidadfecha, AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV92Encuestawwds_18_tfpacienteid), Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to), lV94Encuestawwds_20_tfpacienteapellidopaterno, AV95Encuestawwds_21_tfpacienteapellidopaterno_sel, lV96Encuestawwds_22_tfpacienteapellidomaterno, AV97Encuestawwds_23_tfpacienteapellidomaterno_sel, lV98Encuestawwds_24_tfpacientenombres, AV99Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV106Encuestawwds_32_tfencuestahoraatencion, AV107Encuestawwds_33_tfencuestahoraatencion_to, lV108Encuestawwds_34_tfencuestacomentarios, AV109Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk314 = false ;
         A72SGCitaDisponibilidadSedeId = P00313_A72SGCitaDisponibilidadSedeId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00313_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A152EncuestaRecomendacion = P00313_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P00313_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P00313_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P00313_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P00313_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P00313_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00313_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00313_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00313_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00313_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P00313_A19CitaId[0] ;
         A37EncuestaId = P00313_A37EncuestaId[0] ;
         A153EncuestaEstado = P00313_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P00313_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P00313_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P00313_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P00313_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P00313_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P00313_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P00313_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00313_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P00313_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00313_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00313_A103PacienteApellidoPaterno[0] ;
         A82SGCitaDisponibilidadProFullName = P00313_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P00313_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00313_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00313_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00313_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00313_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00313_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P00313_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P00313_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P00313_A82SGCitaDisponibilidadProFullName[0] ;
         A105PacienteNombres = P00313_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00313_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00313_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P00313_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P00313_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00313_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00313_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00313_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00313_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00313_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00313_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00313_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00313_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00313_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00313_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00313_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00313_n86ProfesionalApellidoMaterno[0] ;
         AV63count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00313_A146SGCitaDisponibilidadEspecialidadNombre[0], A146SGCitaDisponibilidadEspecialidadNombre) == 0 ) )
         {
            brk314 = false ;
            A21SGCitaDisponibilidadId = P00313_A21SGCitaDisponibilidadId[0] ;
            A70SGCitaDisponibilidadEspecialidadId = P00313_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A19CitaId = P00313_A19CitaId[0] ;
            A37EncuestaId = P00313_A37EncuestaId[0] ;
            A21SGCitaDisponibilidadId = P00313_A21SGCitaDisponibilidadId[0] ;
            A70SGCitaDisponibilidadEspecialidadId = P00313_A70SGCitaDisponibilidadEspecialidadId[0] ;
            AV63count = (long)(AV63count+1) ;
            brk314 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A146SGCitaDisponibilidadEspecialidadNombre)==0) )
         {
            AV55Option = A146SGCitaDisponibilidadEspecialidadNombre ;
            AV56Options.add(AV55Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV63count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV56Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk314 )
         {
            brk314 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPACIENTEAPELLIDOPATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV29TFPacienteApellidoPaterno = AV51SearchTxt ;
      AV30TFPacienteApellidoPaterno_Sel = "" ;
      AV75Encuestawwds_1_filterfulltext = AV69FilterFullText ;
      AV76Encuestawwds_2_tfencuestaid = AV11TFEncuestaId ;
      AV77Encuestawwds_3_tfencuestaid_to = AV12TFEncuestaId_To ;
      AV78Encuestawwds_4_tfcitaid = AV13TFCitaId ;
      AV79Encuestawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV15TFSGCitaDisponibilidadProfesionalId ;
      AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV16TFSGCitaDisponibilidadProfesionalId_To ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV17TFSGCitaDisponibilidadProFullName ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV18TFSGCitaDisponibilidadProFullName_Sel ;
      AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV19TFSGCitaDisponibilidadEspecialidadId ;
      AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV20TFSGCitaDisponibilidadEspecialidadId_To ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV21TFSGCitaDisponibilidadEspecialidadNombre ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV88Encuestawwds_14_tfsgcitadisponibilidadid = AV23TFSGCitaDisponibilidadId ;
      AV89Encuestawwds_15_tfsgcitadisponibilidadid_to = AV24TFSGCitaDisponibilidadId_To ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = AV25TFSGCitaDisponibilidadFecha ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV26TFSGCitaDisponibilidadFecha_To ;
      AV92Encuestawwds_18_tfpacienteid = AV27TFPacienteId ;
      AV93Encuestawwds_19_tfpacienteid_to = AV28TFPacienteId_To ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV98Encuestawwds_24_tfpacientenombres = AV33TFPacienteNombres ;
      AV99Encuestawwds_25_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV35TFSGCitaDisponibilidadClinicaId ;
      AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV36TFSGCitaDisponibilidadClinicaId_To ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV37TFSGCitaDisponibilidadClinicaNombre ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = AV40TFEncuestaAtencion_Sels ;
      AV105Encuestawwds_31_tfencuestaatendido_sels = AV42TFEncuestaAtendido_Sels ;
      AV106Encuestawwds_32_tfencuestahoraatencion = AV43TFEncuestaHoraAtencion ;
      AV107Encuestawwds_33_tfencuestahoraatencion_to = AV44TFEncuestaHoraAtencion_To ;
      AV108Encuestawwds_34_tfencuestacomentarios = AV45TFEncuestaComentarios ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = AV46TFEncuestaComentarios_Sel ;
      AV110Encuestawwds_36_tfencuestarecomendacion = AV47TFEncuestaRecomendacion ;
      AV111Encuestawwds_37_tfencuestarecomendacion_to = AV48TFEncuestaRecomendacion_To ;
      AV112Encuestawwds_38_tfencuestaestado_sels = AV50TFEncuestaEstado_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV112Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV76Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV78Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV92Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to) ,
                                           AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV99Encuestawwds_25_tfpacientenombres_sel ,
                                           AV98Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV104Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV105Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV106Encuestawwds_32_tfencuestahoraatencion ,
                                           AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV108Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV112Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           AV75Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV96Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV98Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV108Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P00314 */
      pr_default.execute(2, new Object[] {AV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, Short.valueOf(AV76Encuestawwds_2_tfencuestaid), Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV78Encuestawwds_4_tfcitaid), Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to), AV90Encuestawwds_16_tfsgcitadisponibilidadfecha, AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV92Encuestawwds_18_tfpacienteid), Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to), lV94Encuestawwds_20_tfpacienteapellidopaterno, AV95Encuestawwds_21_tfpacienteapellidopaterno_sel, lV96Encuestawwds_22_tfpacienteapellidomaterno, AV97Encuestawwds_23_tfpacienteapellidomaterno_sel, lV98Encuestawwds_24_tfpacientenombres, AV99Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV106Encuestawwds_32_tfencuestahoraatencion, AV107Encuestawwds_33_tfencuestahoraatencion_to, lV108Encuestawwds_34_tfencuestacomentarios, AV109Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk316 = false ;
         A72SGCitaDisponibilidadSedeId = P00314_A72SGCitaDisponibilidadSedeId[0] ;
         A103PacienteApellidoPaterno = P00314_A103PacienteApellidoPaterno[0] ;
         A152EncuestaRecomendacion = P00314_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P00314_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P00314_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P00314_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P00314_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P00314_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00314_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00314_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00314_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00314_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P00314_A19CitaId[0] ;
         A37EncuestaId = P00314_A37EncuestaId[0] ;
         A153EncuestaEstado = P00314_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P00314_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P00314_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P00314_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P00314_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P00314_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P00314_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P00314_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00314_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P00314_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00314_A104PacienteApellidoMaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00314_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = P00314_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P00314_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00314_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00314_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00314_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00314_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00314_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P00314_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P00314_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P00314_A82SGCitaDisponibilidadProFullName[0] ;
         A103PacienteApellidoPaterno = P00314_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P00314_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00314_A104PacienteApellidoMaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P00314_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P00314_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00314_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00314_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00314_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00314_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00314_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00314_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00314_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00314_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00314_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00314_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00314_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00314_n86ProfesionalApellidoMaterno[0] ;
         AV63count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00314_A103PacienteApellidoPaterno[0], A103PacienteApellidoPaterno) == 0 ) )
         {
            brk316 = false ;
            A20PacienteId = P00314_A20PacienteId[0] ;
            A19CitaId = P00314_A19CitaId[0] ;
            A37EncuestaId = P00314_A37EncuestaId[0] ;
            A20PacienteId = P00314_A20PacienteId[0] ;
            AV63count = (long)(AV63count+1) ;
            brk316 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A103PacienteApellidoPaterno)==0) )
         {
            AV55Option = A103PacienteApellidoPaterno ;
            AV56Options.add(AV55Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV63count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV56Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk316 )
         {
            brk316 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADPACIENTEAPELLIDOMATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV31TFPacienteApellidoMaterno = AV51SearchTxt ;
      AV32TFPacienteApellidoMaterno_Sel = "" ;
      AV75Encuestawwds_1_filterfulltext = AV69FilterFullText ;
      AV76Encuestawwds_2_tfencuestaid = AV11TFEncuestaId ;
      AV77Encuestawwds_3_tfencuestaid_to = AV12TFEncuestaId_To ;
      AV78Encuestawwds_4_tfcitaid = AV13TFCitaId ;
      AV79Encuestawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV15TFSGCitaDisponibilidadProfesionalId ;
      AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV16TFSGCitaDisponibilidadProfesionalId_To ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV17TFSGCitaDisponibilidadProFullName ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV18TFSGCitaDisponibilidadProFullName_Sel ;
      AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV19TFSGCitaDisponibilidadEspecialidadId ;
      AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV20TFSGCitaDisponibilidadEspecialidadId_To ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV21TFSGCitaDisponibilidadEspecialidadNombre ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV88Encuestawwds_14_tfsgcitadisponibilidadid = AV23TFSGCitaDisponibilidadId ;
      AV89Encuestawwds_15_tfsgcitadisponibilidadid_to = AV24TFSGCitaDisponibilidadId_To ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = AV25TFSGCitaDisponibilidadFecha ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV26TFSGCitaDisponibilidadFecha_To ;
      AV92Encuestawwds_18_tfpacienteid = AV27TFPacienteId ;
      AV93Encuestawwds_19_tfpacienteid_to = AV28TFPacienteId_To ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV98Encuestawwds_24_tfpacientenombres = AV33TFPacienteNombres ;
      AV99Encuestawwds_25_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV35TFSGCitaDisponibilidadClinicaId ;
      AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV36TFSGCitaDisponibilidadClinicaId_To ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV37TFSGCitaDisponibilidadClinicaNombre ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = AV40TFEncuestaAtencion_Sels ;
      AV105Encuestawwds_31_tfencuestaatendido_sels = AV42TFEncuestaAtendido_Sels ;
      AV106Encuestawwds_32_tfencuestahoraatencion = AV43TFEncuestaHoraAtencion ;
      AV107Encuestawwds_33_tfencuestahoraatencion_to = AV44TFEncuestaHoraAtencion_To ;
      AV108Encuestawwds_34_tfencuestacomentarios = AV45TFEncuestaComentarios ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = AV46TFEncuestaComentarios_Sel ;
      AV110Encuestawwds_36_tfencuestarecomendacion = AV47TFEncuestaRecomendacion ;
      AV111Encuestawwds_37_tfencuestarecomendacion_to = AV48TFEncuestaRecomendacion_To ;
      AV112Encuestawwds_38_tfencuestaestado_sels = AV50TFEncuestaEstado_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV112Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV76Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV78Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV92Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to) ,
                                           AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV99Encuestawwds_25_tfpacientenombres_sel ,
                                           AV98Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV104Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV105Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV106Encuestawwds_32_tfencuestahoraatencion ,
                                           AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV108Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV112Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           AV75Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV96Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV98Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV108Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P00315 */
      pr_default.execute(3, new Object[] {AV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, Short.valueOf(AV76Encuestawwds_2_tfencuestaid), Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV78Encuestawwds_4_tfcitaid), Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to), AV90Encuestawwds_16_tfsgcitadisponibilidadfecha, AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV92Encuestawwds_18_tfpacienteid), Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to), lV94Encuestawwds_20_tfpacienteapellidopaterno, AV95Encuestawwds_21_tfpacienteapellidopaterno_sel, lV96Encuestawwds_22_tfpacienteapellidomaterno, AV97Encuestawwds_23_tfpacienteapellidomaterno_sel, lV98Encuestawwds_24_tfpacientenombres, AV99Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV106Encuestawwds_32_tfencuestahoraatencion, AV107Encuestawwds_33_tfencuestahoraatencion_to, lV108Encuestawwds_34_tfencuestacomentarios, AV109Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk318 = false ;
         A72SGCitaDisponibilidadSedeId = P00315_A72SGCitaDisponibilidadSedeId[0] ;
         A104PacienteApellidoMaterno = P00315_A104PacienteApellidoMaterno[0] ;
         A152EncuestaRecomendacion = P00315_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P00315_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P00315_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P00315_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P00315_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P00315_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00315_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00315_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00315_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00315_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P00315_A19CitaId[0] ;
         A37EncuestaId = P00315_A37EncuestaId[0] ;
         A153EncuestaEstado = P00315_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P00315_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P00315_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P00315_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P00315_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P00315_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P00315_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P00315_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00315_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P00315_A105PacienteNombres[0] ;
         A103PacienteApellidoPaterno = P00315_A103PacienteApellidoPaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00315_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = P00315_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P00315_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00315_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00315_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00315_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00315_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00315_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P00315_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P00315_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P00315_A82SGCitaDisponibilidadProFullName[0] ;
         A104PacienteApellidoMaterno = P00315_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = P00315_A105PacienteNombres[0] ;
         A103PacienteApellidoPaterno = P00315_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P00315_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P00315_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00315_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00315_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00315_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00315_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00315_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00315_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00315_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00315_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00315_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00315_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00315_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00315_n86ProfesionalApellidoMaterno[0] ;
         AV63count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P00315_A104PacienteApellidoMaterno[0], A104PacienteApellidoMaterno) == 0 ) )
         {
            brk318 = false ;
            A20PacienteId = P00315_A20PacienteId[0] ;
            A19CitaId = P00315_A19CitaId[0] ;
            A37EncuestaId = P00315_A37EncuestaId[0] ;
            A20PacienteId = P00315_A20PacienteId[0] ;
            AV63count = (long)(AV63count+1) ;
            brk318 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A104PacienteApellidoMaterno)==0) )
         {
            AV55Option = A104PacienteApellidoMaterno ;
            AV56Options.add(AV55Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV63count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV56Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk318 )
         {
            brk318 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADPACIENTENOMBRESOPTIONS' Routine */
      returnInSub = false ;
      AV33TFPacienteNombres = AV51SearchTxt ;
      AV34TFPacienteNombres_Sel = "" ;
      AV75Encuestawwds_1_filterfulltext = AV69FilterFullText ;
      AV76Encuestawwds_2_tfencuestaid = AV11TFEncuestaId ;
      AV77Encuestawwds_3_tfencuestaid_to = AV12TFEncuestaId_To ;
      AV78Encuestawwds_4_tfcitaid = AV13TFCitaId ;
      AV79Encuestawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV15TFSGCitaDisponibilidadProfesionalId ;
      AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV16TFSGCitaDisponibilidadProfesionalId_To ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV17TFSGCitaDisponibilidadProFullName ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV18TFSGCitaDisponibilidadProFullName_Sel ;
      AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV19TFSGCitaDisponibilidadEspecialidadId ;
      AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV20TFSGCitaDisponibilidadEspecialidadId_To ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV21TFSGCitaDisponibilidadEspecialidadNombre ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV88Encuestawwds_14_tfsgcitadisponibilidadid = AV23TFSGCitaDisponibilidadId ;
      AV89Encuestawwds_15_tfsgcitadisponibilidadid_to = AV24TFSGCitaDisponibilidadId_To ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = AV25TFSGCitaDisponibilidadFecha ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV26TFSGCitaDisponibilidadFecha_To ;
      AV92Encuestawwds_18_tfpacienteid = AV27TFPacienteId ;
      AV93Encuestawwds_19_tfpacienteid_to = AV28TFPacienteId_To ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV98Encuestawwds_24_tfpacientenombres = AV33TFPacienteNombres ;
      AV99Encuestawwds_25_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV35TFSGCitaDisponibilidadClinicaId ;
      AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV36TFSGCitaDisponibilidadClinicaId_To ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV37TFSGCitaDisponibilidadClinicaNombre ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = AV40TFEncuestaAtencion_Sels ;
      AV105Encuestawwds_31_tfencuestaatendido_sels = AV42TFEncuestaAtendido_Sels ;
      AV106Encuestawwds_32_tfencuestahoraatencion = AV43TFEncuestaHoraAtencion ;
      AV107Encuestawwds_33_tfencuestahoraatencion_to = AV44TFEncuestaHoraAtencion_To ;
      AV108Encuestawwds_34_tfencuestacomentarios = AV45TFEncuestaComentarios ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = AV46TFEncuestaComentarios_Sel ;
      AV110Encuestawwds_36_tfencuestarecomendacion = AV47TFEncuestaRecomendacion ;
      AV111Encuestawwds_37_tfencuestarecomendacion_to = AV48TFEncuestaRecomendacion_To ;
      AV112Encuestawwds_38_tfencuestaestado_sels = AV50TFEncuestaEstado_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV112Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV76Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV78Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV92Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to) ,
                                           AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV99Encuestawwds_25_tfpacientenombres_sel ,
                                           AV98Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV104Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV105Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV106Encuestawwds_32_tfencuestahoraatencion ,
                                           AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV108Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV112Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           AV75Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV96Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV98Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV108Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P00316 */
      pr_default.execute(4, new Object[] {AV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, Short.valueOf(AV76Encuestawwds_2_tfencuestaid), Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV78Encuestawwds_4_tfcitaid), Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to), AV90Encuestawwds_16_tfsgcitadisponibilidadfecha, AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV92Encuestawwds_18_tfpacienteid), Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to), lV94Encuestawwds_20_tfpacienteapellidopaterno, AV95Encuestawwds_21_tfpacienteapellidopaterno_sel, lV96Encuestawwds_22_tfpacienteapellidomaterno, AV97Encuestawwds_23_tfpacienteapellidomaterno_sel, lV98Encuestawwds_24_tfpacientenombres, AV99Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV106Encuestawwds_32_tfencuestahoraatencion, AV107Encuestawwds_33_tfencuestahoraatencion_to, lV108Encuestawwds_34_tfencuestacomentarios, AV109Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk3110 = false ;
         A72SGCitaDisponibilidadSedeId = P00316_A72SGCitaDisponibilidadSedeId[0] ;
         A105PacienteNombres = P00316_A105PacienteNombres[0] ;
         A152EncuestaRecomendacion = P00316_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P00316_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P00316_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P00316_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P00316_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P00316_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00316_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00316_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00316_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00316_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P00316_A19CitaId[0] ;
         A37EncuestaId = P00316_A37EncuestaId[0] ;
         A153EncuestaEstado = P00316_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P00316_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P00316_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P00316_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P00316_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P00316_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P00316_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P00316_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00316_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A104PacienteApellidoMaterno = P00316_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00316_A103PacienteApellidoPaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00316_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = P00316_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P00316_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00316_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00316_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00316_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00316_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00316_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P00316_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P00316_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P00316_A82SGCitaDisponibilidadProFullName[0] ;
         A105PacienteNombres = P00316_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00316_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00316_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P00316_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P00316_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00316_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00316_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00316_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00316_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00316_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00316_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00316_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00316_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00316_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00316_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00316_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00316_n86ProfesionalApellidoMaterno[0] ;
         AV63count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P00316_A105PacienteNombres[0], A105PacienteNombres) == 0 ) )
         {
            brk3110 = false ;
            A20PacienteId = P00316_A20PacienteId[0] ;
            A19CitaId = P00316_A19CitaId[0] ;
            A37EncuestaId = P00316_A37EncuestaId[0] ;
            A20PacienteId = P00316_A20PacienteId[0] ;
            AV63count = (long)(AV63count+1) ;
            brk3110 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A105PacienteNombres)==0) )
         {
            AV55Option = A105PacienteNombres ;
            AV56Options.add(AV55Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV63count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV56Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3110 )
         {
            brk3110 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADSGCITADISPONIBILIDADCLINICANOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV37TFSGCitaDisponibilidadClinicaNombre = AV51SearchTxt ;
      AV70TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV75Encuestawwds_1_filterfulltext = AV69FilterFullText ;
      AV76Encuestawwds_2_tfencuestaid = AV11TFEncuestaId ;
      AV77Encuestawwds_3_tfencuestaid_to = AV12TFEncuestaId_To ;
      AV78Encuestawwds_4_tfcitaid = AV13TFCitaId ;
      AV79Encuestawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV15TFSGCitaDisponibilidadProfesionalId ;
      AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV16TFSGCitaDisponibilidadProfesionalId_To ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV17TFSGCitaDisponibilidadProFullName ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV18TFSGCitaDisponibilidadProFullName_Sel ;
      AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV19TFSGCitaDisponibilidadEspecialidadId ;
      AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV20TFSGCitaDisponibilidadEspecialidadId_To ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV21TFSGCitaDisponibilidadEspecialidadNombre ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV88Encuestawwds_14_tfsgcitadisponibilidadid = AV23TFSGCitaDisponibilidadId ;
      AV89Encuestawwds_15_tfsgcitadisponibilidadid_to = AV24TFSGCitaDisponibilidadId_To ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = AV25TFSGCitaDisponibilidadFecha ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV26TFSGCitaDisponibilidadFecha_To ;
      AV92Encuestawwds_18_tfpacienteid = AV27TFPacienteId ;
      AV93Encuestawwds_19_tfpacienteid_to = AV28TFPacienteId_To ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV98Encuestawwds_24_tfpacientenombres = AV33TFPacienteNombres ;
      AV99Encuestawwds_25_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV35TFSGCitaDisponibilidadClinicaId ;
      AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV36TFSGCitaDisponibilidadClinicaId_To ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV37TFSGCitaDisponibilidadClinicaNombre ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = AV40TFEncuestaAtencion_Sels ;
      AV105Encuestawwds_31_tfencuestaatendido_sels = AV42TFEncuestaAtendido_Sels ;
      AV106Encuestawwds_32_tfencuestahoraatencion = AV43TFEncuestaHoraAtencion ;
      AV107Encuestawwds_33_tfencuestahoraatencion_to = AV44TFEncuestaHoraAtencion_To ;
      AV108Encuestawwds_34_tfencuestacomentarios = AV45TFEncuestaComentarios ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = AV46TFEncuestaComentarios_Sel ;
      AV110Encuestawwds_36_tfencuestarecomendacion = AV47TFEncuestaRecomendacion ;
      AV111Encuestawwds_37_tfencuestarecomendacion_to = AV48TFEncuestaRecomendacion_To ;
      AV112Encuestawwds_38_tfencuestaestado_sels = AV50TFEncuestaEstado_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV112Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV76Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV78Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV92Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to) ,
                                           AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV99Encuestawwds_25_tfpacientenombres_sel ,
                                           AV98Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV104Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV105Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV106Encuestawwds_32_tfencuestahoraatencion ,
                                           AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV108Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV112Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           AV75Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV96Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV98Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV108Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P00317 */
      pr_default.execute(5, new Object[] {AV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, Short.valueOf(AV76Encuestawwds_2_tfencuestaid), Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV78Encuestawwds_4_tfcitaid), Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to), AV90Encuestawwds_16_tfsgcitadisponibilidadfecha, AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV92Encuestawwds_18_tfpacienteid), Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to), lV94Encuestawwds_20_tfpacienteapellidopaterno, AV95Encuestawwds_21_tfpacienteapellidopaterno_sel, lV96Encuestawwds_22_tfpacienteapellidomaterno, AV97Encuestawwds_23_tfpacienteapellidomaterno_sel, lV98Encuestawwds_24_tfpacientenombres, AV99Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV106Encuestawwds_32_tfencuestahoraatencion, AV107Encuestawwds_33_tfencuestahoraatencion_to, lV108Encuestawwds_34_tfencuestacomentarios, AV109Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk3112 = false ;
         A72SGCitaDisponibilidadSedeId = P00317_A72SGCitaDisponibilidadSedeId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00317_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A152EncuestaRecomendacion = P00317_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P00317_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P00317_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P00317_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P00317_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P00317_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00317_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00317_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00317_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00317_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P00317_A19CitaId[0] ;
         A37EncuestaId = P00317_A37EncuestaId[0] ;
         A153EncuestaEstado = P00317_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P00317_n153EncuestaEstado[0] ;
         A151EncuestaComentarios = P00317_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P00317_n151EncuestaComentarios[0] ;
         A149EncuestaAtendido = P00317_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P00317_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P00317_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P00317_n148EncuestaAtencion[0] ;
         A105PacienteNombres = P00317_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00317_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00317_A103PacienteApellidoPaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00317_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = P00317_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P00317_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00317_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00317_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00317_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00317_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00317_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P00317_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P00317_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P00317_A82SGCitaDisponibilidadProFullName[0] ;
         A105PacienteNombres = P00317_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00317_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00317_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P00317_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P00317_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00317_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00317_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00317_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00317_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00317_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00317_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00317_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00317_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00317_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00317_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00317_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00317_n86ProfesionalApellidoMaterno[0] ;
         AV63count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P00317_A78SGCitaDisponibilidadClinicaNombre[0], A78SGCitaDisponibilidadClinicaNombre) == 0 ) )
         {
            brk3112 = false ;
            A72SGCitaDisponibilidadSedeId = P00317_A72SGCitaDisponibilidadSedeId[0] ;
            A76SGCitaDisponibilidadClinicaId = P00317_A76SGCitaDisponibilidadClinicaId[0] ;
            A21SGCitaDisponibilidadId = P00317_A21SGCitaDisponibilidadId[0] ;
            A19CitaId = P00317_A19CitaId[0] ;
            A37EncuestaId = P00317_A37EncuestaId[0] ;
            A21SGCitaDisponibilidadId = P00317_A21SGCitaDisponibilidadId[0] ;
            A72SGCitaDisponibilidadSedeId = P00317_A72SGCitaDisponibilidadSedeId[0] ;
            A76SGCitaDisponibilidadClinicaId = P00317_A76SGCitaDisponibilidadClinicaId[0] ;
            AV63count = (long)(AV63count+1) ;
            brk3112 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A78SGCitaDisponibilidadClinicaNombre)==0) )
         {
            AV55Option = A78SGCitaDisponibilidadClinicaNombre ;
            AV56Options.add(AV55Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV63count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV56Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3112 )
         {
            brk3112 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADENCUESTACOMENTARIOSOPTIONS' Routine */
      returnInSub = false ;
      AV45TFEncuestaComentarios = AV51SearchTxt ;
      AV46TFEncuestaComentarios_Sel = "" ;
      AV75Encuestawwds_1_filterfulltext = AV69FilterFullText ;
      AV76Encuestawwds_2_tfencuestaid = AV11TFEncuestaId ;
      AV77Encuestawwds_3_tfencuestaid_to = AV12TFEncuestaId_To ;
      AV78Encuestawwds_4_tfcitaid = AV13TFCitaId ;
      AV79Encuestawwds_5_tfcitaid_to = AV14TFCitaId_To ;
      AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid = AV15TFSGCitaDisponibilidadProfesionalId ;
      AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to = AV16TFSGCitaDisponibilidadProfesionalId_To ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = AV17TFSGCitaDisponibilidadProFullName ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = AV18TFSGCitaDisponibilidadProFullName_Sel ;
      AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid = AV19TFSGCitaDisponibilidadEspecialidadId ;
      AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to = AV20TFSGCitaDisponibilidadEspecialidadId_To ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = AV21TFSGCitaDisponibilidadEspecialidadNombre ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV88Encuestawwds_14_tfsgcitadisponibilidadid = AV23TFSGCitaDisponibilidadId ;
      AV89Encuestawwds_15_tfsgcitadisponibilidadid_to = AV24TFSGCitaDisponibilidadId_To ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = AV25TFSGCitaDisponibilidadFecha ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = AV26TFSGCitaDisponibilidadFecha_To ;
      AV92Encuestawwds_18_tfpacienteid = AV27TFPacienteId ;
      AV93Encuestawwds_19_tfpacienteid_to = AV28TFPacienteId_To ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = AV29TFPacienteApellidoPaterno ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = AV30TFPacienteApellidoPaterno_Sel ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = AV31TFPacienteApellidoMaterno ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = AV32TFPacienteApellidoMaterno_Sel ;
      AV98Encuestawwds_24_tfpacientenombres = AV33TFPacienteNombres ;
      AV99Encuestawwds_25_tfpacientenombres_sel = AV34TFPacienteNombres_Sel ;
      AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid = AV35TFSGCitaDisponibilidadClinicaId ;
      AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to = AV36TFSGCitaDisponibilidadClinicaId_To ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = AV37TFSGCitaDisponibilidadClinicaNombre ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = AV40TFEncuestaAtencion_Sels ;
      AV105Encuestawwds_31_tfencuestaatendido_sels = AV42TFEncuestaAtendido_Sels ;
      AV106Encuestawwds_32_tfencuestahoraatencion = AV43TFEncuestaHoraAtencion ;
      AV107Encuestawwds_33_tfencuestahoraatencion_to = AV44TFEncuestaHoraAtencion_To ;
      AV108Encuestawwds_34_tfencuestacomentarios = AV45TFEncuestaComentarios ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = AV46TFEncuestaComentarios_Sel ;
      AV110Encuestawwds_36_tfencuestarecomendacion = AV47TFEncuestaRecomendacion ;
      AV111Encuestawwds_37_tfencuestarecomendacion_to = AV48TFEncuestaRecomendacion_To ;
      AV112Encuestawwds_38_tfencuestaestado_sels = AV50TFEncuestaEstado_Sels ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A148EncuestaAtencion ,
                                           AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                           A149EncuestaAtendido ,
                                           AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                           A153EncuestaEstado ,
                                           AV112Encuestawwds_38_tfencuestaestado_sels ,
                                           Short.valueOf(AV76Encuestawwds_2_tfencuestaid) ,
                                           Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to) ,
                                           Integer.valueOf(AV78Encuestawwds_4_tfcitaid) ,
                                           Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to) ,
                                           Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) ,
                                           Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) ,
                                           AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                           AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                           Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) ,
                                           Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) ,
                                           AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                           Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid) ,
                                           Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) ,
                                           AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                           AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                           Integer.valueOf(AV92Encuestawwds_18_tfpacienteid) ,
                                           Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to) ,
                                           AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                           AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                           AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                           AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                           AV99Encuestawwds_25_tfpacientenombres_sel ,
                                           AV98Encuestawwds_24_tfpacientenombres ,
                                           Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) ,
                                           Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) ,
                                           AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV104Encuestawwds_30_tfencuestaatencion_sels.size()) ,
                                           Integer.valueOf(AV105Encuestawwds_31_tfencuestaatendido_sels.size()) ,
                                           AV106Encuestawwds_32_tfencuestahoraatencion ,
                                           AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                           AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                           AV108Encuestawwds_34_tfencuestacomentarios ,
                                           Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion) ,
                                           Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to) ,
                                           Integer.valueOf(AV112Encuestawwds_38_tfencuestaestado_sels.size()) ,
                                           Short.valueOf(A37EncuestaId) ,
                                           Integer.valueOf(A19CitaId) ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           A84ProfesionalNombres ,
                                           A85ProfesionalApellidoPaterno ,
                                           A86ProfesionalApellidoMaterno ,
                                           Short.valueOf(A70SGCitaDisponibilidadEspecialidadId) ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           Integer.valueOf(A21SGCitaDisponibilidadId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           Integer.valueOf(A20PacienteId) ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           Short.valueOf(A76SGCitaDisponibilidadClinicaId) ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           A150EncuestaHoraAtencion ,
                                           A151EncuestaComentarios ,
                                           Byte.valueOf(A152EncuestaRecomendacion) ,
                                           AV75Encuestawwds_1_filterfulltext ,
                                           A82SGCitaDisponibilidadProFullName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV75Encuestawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV75Encuestawwds_1_filterfulltext), "%", "") ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = GXutil.concat( GXutil.rtrim( AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname), "%", "") ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV94Encuestawwds_20_tfpacienteapellidopaterno), "%", "") ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV96Encuestawwds_22_tfpacienteapellidomaterno), "%", "") ;
      lV98Encuestawwds_24_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV98Encuestawwds_24_tfpacientenombres), "%", "") ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV108Encuestawwds_34_tfencuestacomentarios = GXutil.concat( GXutil.rtrim( AV108Encuestawwds_34_tfencuestacomentarios), "%", "") ;
      /* Using cursor P00318 */
      pr_default.execute(6, new Object[] {AV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, lV75Encuestawwds_1_filterfulltext, Short.valueOf(AV76Encuestawwds_2_tfencuestaid), Short.valueOf(AV77Encuestawwds_3_tfencuestaid_to), Integer.valueOf(AV78Encuestawwds_4_tfcitaid), Integer.valueOf(AV79Encuestawwds_5_tfcitaid_to), Integer.valueOf(AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid), Integer.valueOf(AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to), lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname, AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel, Short.valueOf(AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid), Short.valueOf(AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to), lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre, AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel, Integer.valueOf(AV88Encuestawwds_14_tfsgcitadisponibilidadid), Integer.valueOf(AV89Encuestawwds_15_tfsgcitadisponibilidadid_to), AV90Encuestawwds_16_tfsgcitadisponibilidadfecha, AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to, Integer.valueOf(AV92Encuestawwds_18_tfpacienteid), Integer.valueOf(AV93Encuestawwds_19_tfpacienteid_to), lV94Encuestawwds_20_tfpacienteapellidopaterno, AV95Encuestawwds_21_tfpacienteapellidopaterno_sel, lV96Encuestawwds_22_tfpacienteapellidomaterno, AV97Encuestawwds_23_tfpacienteapellidomaterno_sel, lV98Encuestawwds_24_tfpacientenombres, AV99Encuestawwds_25_tfpacientenombres_sel, Short.valueOf(AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid), Short.valueOf(AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to), lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre, AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel, AV106Encuestawwds_32_tfencuestahoraatencion, AV107Encuestawwds_33_tfencuestahoraatencion_to, lV108Encuestawwds_34_tfencuestacomentarios, AV109Encuestawwds_35_tfencuestacomentarios_sel, Byte.valueOf(AV110Encuestawwds_36_tfencuestarecomendacion), Byte.valueOf(AV111Encuestawwds_37_tfencuestarecomendacion_to)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk3114 = false ;
         A72SGCitaDisponibilidadSedeId = P00318_A72SGCitaDisponibilidadSedeId[0] ;
         A151EncuestaComentarios = P00318_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = P00318_n151EncuestaComentarios[0] ;
         A152EncuestaRecomendacion = P00318_A152EncuestaRecomendacion[0] ;
         A150EncuestaHoraAtencion = P00318_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = P00318_n150EncuestaHoraAtencion[0] ;
         A76SGCitaDisponibilidadClinicaId = P00318_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P00318_A20PacienteId[0] ;
         A66SGCitaDisponibilidadFecha = P00318_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00318_n66SGCitaDisponibilidadFecha[0] ;
         A21SGCitaDisponibilidadId = P00318_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00318_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00318_A81SGCitaDisponibilidadProfesionalId[0] ;
         A19CitaId = P00318_A19CitaId[0] ;
         A37EncuestaId = P00318_A37EncuestaId[0] ;
         A153EncuestaEstado = P00318_A153EncuestaEstado[0] ;
         n153EncuestaEstado = P00318_n153EncuestaEstado[0] ;
         A149EncuestaAtendido = P00318_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = P00318_n149EncuestaAtendido[0] ;
         A148EncuestaAtencion = P00318_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = P00318_n148EncuestaAtencion[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00318_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P00318_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00318_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00318_A103PacienteApellidoPaterno[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00318_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A82SGCitaDisponibilidadProFullName = P00318_A82SGCitaDisponibilidadProFullName[0] ;
         A84ProfesionalNombres = P00318_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00318_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00318_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00318_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00318_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00318_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = P00318_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P00318_A21SGCitaDisponibilidadId[0] ;
         A82SGCitaDisponibilidadProFullName = P00318_A82SGCitaDisponibilidadProFullName[0] ;
         A105PacienteNombres = P00318_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P00318_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P00318_A103PacienteApellidoPaterno[0] ;
         A72SGCitaDisponibilidadSedeId = P00318_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = P00318_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P00318_n66SGCitaDisponibilidadFecha[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P00318_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P00318_A81SGCitaDisponibilidadProfesionalId[0] ;
         A76SGCitaDisponibilidadClinicaId = P00318_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P00318_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P00318_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A84ProfesionalNombres = P00318_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P00318_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = P00318_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P00318_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P00318_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P00318_n86ProfesionalApellidoMaterno[0] ;
         AV63count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P00318_A151EncuestaComentarios[0], A151EncuestaComentarios) == 0 ) )
         {
            brk3114 = false ;
            A37EncuestaId = P00318_A37EncuestaId[0] ;
            AV63count = (long)(AV63count+1) ;
            brk3114 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A151EncuestaComentarios)==0) )
         {
            AV55Option = A151EncuestaComentarios ;
            AV56Options.add(AV55Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV63count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV56Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3114 )
         {
            brk3114 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   protected void cleanup( )
   {
      this.aP3[0] = encuestawwgetfilterdata.this.AV57OptionsJson;
      this.aP4[0] = encuestawwgetfilterdata.this.AV60OptionsDescJson;
      this.aP5[0] = encuestawwgetfilterdata.this.AV62OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV57OptionsJson = "" ;
      AV60OptionsDescJson = "" ;
      AV62OptionIndexesJson = "" ;
      AV56Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV64Session = httpContext.getWebSession();
      AV66GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV67GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV69FilterFullText = "" ;
      AV17TFSGCitaDisponibilidadProFullName = "" ;
      AV18TFSGCitaDisponibilidadProFullName_Sel = "" ;
      AV21TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV25TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV26TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV29TFPacienteApellidoPaterno = "" ;
      AV30TFPacienteApellidoPaterno_Sel = "" ;
      AV31TFPacienteApellidoMaterno = "" ;
      AV32TFPacienteApellidoMaterno_Sel = "" ;
      AV33TFPacienteNombres = "" ;
      AV34TFPacienteNombres_Sel = "" ;
      AV37TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV70TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV39TFEncuestaAtencion_SelsJson = "" ;
      AV40TFEncuestaAtencion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFEncuestaAtendido_SelsJson = "" ;
      AV42TFEncuestaAtendido_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFEncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      AV44TFEncuestaHoraAtencion_To = GXutil.resetTime( GXutil.nullDate() );
      AV45TFEncuestaComentarios = "" ;
      AV46TFEncuestaComentarios_Sel = "" ;
      AV49TFEncuestaEstado_SelsJson = "" ;
      AV50TFEncuestaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A82SGCitaDisponibilidadProFullName = "" ;
      AV75Encuestawwds_1_filterfulltext = "" ;
      AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel = "" ;
      AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV90Encuestawwds_16_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV94Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      AV95Encuestawwds_21_tfpacienteapellidopaterno_sel = "" ;
      AV96Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      AV97Encuestawwds_23_tfpacienteapellidomaterno_sel = "" ;
      AV98Encuestawwds_24_tfpacientenombres = "" ;
      AV99Encuestawwds_25_tfpacientenombres_sel = "" ;
      AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV104Encuestawwds_30_tfencuestaatencion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV105Encuestawwds_31_tfencuestaatendido_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV106Encuestawwds_32_tfencuestahoraatencion = GXutil.resetTime( GXutil.nullDate() );
      AV107Encuestawwds_33_tfencuestahoraatencion_to = GXutil.resetTime( GXutil.nullDate() );
      AV108Encuestawwds_34_tfencuestacomentarios = "" ;
      AV109Encuestawwds_35_tfencuestacomentarios_sel = "" ;
      AV112Encuestawwds_38_tfencuestaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV75Encuestawwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname = "" ;
      lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV94Encuestawwds_20_tfpacienteapellidopaterno = "" ;
      lV96Encuestawwds_22_tfpacienteapellidomaterno = "" ;
      lV98Encuestawwds_24_tfpacientenombres = "" ;
      lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre = "" ;
      lV108Encuestawwds_34_tfencuestacomentarios = "" ;
      A148EncuestaAtencion = "" ;
      A149EncuestaAtendido = "" ;
      A153EncuestaEstado = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      A151EncuestaComentarios = "" ;
      P00312_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00312_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00312_A152EncuestaRecomendacion = new byte[1] ;
      P00312_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P00312_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P00312_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00312_A20PacienteId = new int[1] ;
      P00312_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00312_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00312_A21SGCitaDisponibilidadId = new int[1] ;
      P00312_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00312_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00312_A19CitaId = new int[1] ;
      P00312_A37EncuestaId = new short[1] ;
      P00312_A153EncuestaEstado = new String[] {""} ;
      P00312_n153EncuestaEstado = new boolean[] {false} ;
      P00312_A151EncuestaComentarios = new String[] {""} ;
      P00312_n151EncuestaComentarios = new boolean[] {false} ;
      P00312_A149EncuestaAtendido = new String[] {""} ;
      P00312_n149EncuestaAtendido = new boolean[] {false} ;
      P00312_A148EncuestaAtencion = new String[] {""} ;
      P00312_n148EncuestaAtencion = new boolean[] {false} ;
      P00312_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00312_A105PacienteNombres = new String[] {""} ;
      P00312_A104PacienteApellidoMaterno = new String[] {""} ;
      P00312_A103PacienteApellidoPaterno = new String[] {""} ;
      P00312_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00312_A84ProfesionalNombres = new String[] {""} ;
      P00312_n84ProfesionalNombres = new boolean[] {false} ;
      P00312_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00312_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00312_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00312_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      AV55Option = "" ;
      P00313_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00313_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00313_A152EncuestaRecomendacion = new byte[1] ;
      P00313_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P00313_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P00313_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00313_A20PacienteId = new int[1] ;
      P00313_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00313_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00313_A21SGCitaDisponibilidadId = new int[1] ;
      P00313_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00313_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00313_A19CitaId = new int[1] ;
      P00313_A37EncuestaId = new short[1] ;
      P00313_A153EncuestaEstado = new String[] {""} ;
      P00313_n153EncuestaEstado = new boolean[] {false} ;
      P00313_A151EncuestaComentarios = new String[] {""} ;
      P00313_n151EncuestaComentarios = new boolean[] {false} ;
      P00313_A149EncuestaAtendido = new String[] {""} ;
      P00313_n149EncuestaAtendido = new boolean[] {false} ;
      P00313_A148EncuestaAtencion = new String[] {""} ;
      P00313_n148EncuestaAtencion = new boolean[] {false} ;
      P00313_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00313_A105PacienteNombres = new String[] {""} ;
      P00313_A104PacienteApellidoMaterno = new String[] {""} ;
      P00313_A103PacienteApellidoPaterno = new String[] {""} ;
      P00313_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00313_A84ProfesionalNombres = new String[] {""} ;
      P00313_n84ProfesionalNombres = new boolean[] {false} ;
      P00313_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00313_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00313_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00313_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P00314_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00314_A103PacienteApellidoPaterno = new String[] {""} ;
      P00314_A152EncuestaRecomendacion = new byte[1] ;
      P00314_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P00314_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P00314_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00314_A20PacienteId = new int[1] ;
      P00314_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00314_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00314_A21SGCitaDisponibilidadId = new int[1] ;
      P00314_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00314_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00314_A19CitaId = new int[1] ;
      P00314_A37EncuestaId = new short[1] ;
      P00314_A153EncuestaEstado = new String[] {""} ;
      P00314_n153EncuestaEstado = new boolean[] {false} ;
      P00314_A151EncuestaComentarios = new String[] {""} ;
      P00314_n151EncuestaComentarios = new boolean[] {false} ;
      P00314_A149EncuestaAtendido = new String[] {""} ;
      P00314_n149EncuestaAtendido = new boolean[] {false} ;
      P00314_A148EncuestaAtencion = new String[] {""} ;
      P00314_n148EncuestaAtencion = new boolean[] {false} ;
      P00314_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00314_A105PacienteNombres = new String[] {""} ;
      P00314_A104PacienteApellidoMaterno = new String[] {""} ;
      P00314_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00314_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00314_A84ProfesionalNombres = new String[] {""} ;
      P00314_n84ProfesionalNombres = new boolean[] {false} ;
      P00314_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00314_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00314_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00314_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P00315_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00315_A104PacienteApellidoMaterno = new String[] {""} ;
      P00315_A152EncuestaRecomendacion = new byte[1] ;
      P00315_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P00315_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P00315_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00315_A20PacienteId = new int[1] ;
      P00315_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00315_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00315_A21SGCitaDisponibilidadId = new int[1] ;
      P00315_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00315_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00315_A19CitaId = new int[1] ;
      P00315_A37EncuestaId = new short[1] ;
      P00315_A153EncuestaEstado = new String[] {""} ;
      P00315_n153EncuestaEstado = new boolean[] {false} ;
      P00315_A151EncuestaComentarios = new String[] {""} ;
      P00315_n151EncuestaComentarios = new boolean[] {false} ;
      P00315_A149EncuestaAtendido = new String[] {""} ;
      P00315_n149EncuestaAtendido = new boolean[] {false} ;
      P00315_A148EncuestaAtencion = new String[] {""} ;
      P00315_n148EncuestaAtencion = new boolean[] {false} ;
      P00315_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00315_A105PacienteNombres = new String[] {""} ;
      P00315_A103PacienteApellidoPaterno = new String[] {""} ;
      P00315_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00315_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00315_A84ProfesionalNombres = new String[] {""} ;
      P00315_n84ProfesionalNombres = new boolean[] {false} ;
      P00315_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00315_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00315_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00315_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P00316_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00316_A105PacienteNombres = new String[] {""} ;
      P00316_A152EncuestaRecomendacion = new byte[1] ;
      P00316_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P00316_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P00316_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00316_A20PacienteId = new int[1] ;
      P00316_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00316_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00316_A21SGCitaDisponibilidadId = new int[1] ;
      P00316_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00316_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00316_A19CitaId = new int[1] ;
      P00316_A37EncuestaId = new short[1] ;
      P00316_A153EncuestaEstado = new String[] {""} ;
      P00316_n153EncuestaEstado = new boolean[] {false} ;
      P00316_A151EncuestaComentarios = new String[] {""} ;
      P00316_n151EncuestaComentarios = new boolean[] {false} ;
      P00316_A149EncuestaAtendido = new String[] {""} ;
      P00316_n149EncuestaAtendido = new boolean[] {false} ;
      P00316_A148EncuestaAtencion = new String[] {""} ;
      P00316_n148EncuestaAtencion = new boolean[] {false} ;
      P00316_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00316_A104PacienteApellidoMaterno = new String[] {""} ;
      P00316_A103PacienteApellidoPaterno = new String[] {""} ;
      P00316_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00316_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00316_A84ProfesionalNombres = new String[] {""} ;
      P00316_n84ProfesionalNombres = new boolean[] {false} ;
      P00316_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00316_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00316_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00316_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P00317_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00317_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00317_A152EncuestaRecomendacion = new byte[1] ;
      P00317_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P00317_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P00317_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00317_A20PacienteId = new int[1] ;
      P00317_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00317_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00317_A21SGCitaDisponibilidadId = new int[1] ;
      P00317_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00317_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00317_A19CitaId = new int[1] ;
      P00317_A37EncuestaId = new short[1] ;
      P00317_A153EncuestaEstado = new String[] {""} ;
      P00317_n153EncuestaEstado = new boolean[] {false} ;
      P00317_A151EncuestaComentarios = new String[] {""} ;
      P00317_n151EncuestaComentarios = new boolean[] {false} ;
      P00317_A149EncuestaAtendido = new String[] {""} ;
      P00317_n149EncuestaAtendido = new boolean[] {false} ;
      P00317_A148EncuestaAtencion = new String[] {""} ;
      P00317_n148EncuestaAtencion = new boolean[] {false} ;
      P00317_A105PacienteNombres = new String[] {""} ;
      P00317_A104PacienteApellidoMaterno = new String[] {""} ;
      P00317_A103PacienteApellidoPaterno = new String[] {""} ;
      P00317_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00317_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00317_A84ProfesionalNombres = new String[] {""} ;
      P00317_n84ProfesionalNombres = new boolean[] {false} ;
      P00317_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00317_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00317_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00317_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P00318_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P00318_A151EncuestaComentarios = new String[] {""} ;
      P00318_n151EncuestaComentarios = new boolean[] {false} ;
      P00318_A152EncuestaRecomendacion = new byte[1] ;
      P00318_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      P00318_n150EncuestaHoraAtencion = new boolean[] {false} ;
      P00318_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P00318_A20PacienteId = new int[1] ;
      P00318_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00318_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P00318_A21SGCitaDisponibilidadId = new int[1] ;
      P00318_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P00318_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P00318_A19CitaId = new int[1] ;
      P00318_A37EncuestaId = new short[1] ;
      P00318_A153EncuestaEstado = new String[] {""} ;
      P00318_n153EncuestaEstado = new boolean[] {false} ;
      P00318_A149EncuestaAtendido = new String[] {""} ;
      P00318_n149EncuestaAtendido = new boolean[] {false} ;
      P00318_A148EncuestaAtencion = new String[] {""} ;
      P00318_n148EncuestaAtencion = new boolean[] {false} ;
      P00318_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P00318_A105PacienteNombres = new String[] {""} ;
      P00318_A104PacienteApellidoMaterno = new String[] {""} ;
      P00318_A103PacienteApellidoPaterno = new String[] {""} ;
      P00318_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P00318_A82SGCitaDisponibilidadProFullName = new String[] {""} ;
      P00318_A84ProfesionalNombres = new String[] {""} ;
      P00318_n84ProfesionalNombres = new boolean[] {false} ;
      P00318_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00318_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P00318_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00318_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.encuestawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00312_A72SGCitaDisponibilidadSedeId, P00312_A82SGCitaDisponibilidadProFullName, P00312_A152EncuestaRecomendacion, P00312_A150EncuestaHoraAtencion, P00312_n150EncuestaHoraAtencion, P00312_A76SGCitaDisponibilidadClinicaId, P00312_A20PacienteId, P00312_A66SGCitaDisponibilidadFecha, P00312_n66SGCitaDisponibilidadFecha, P00312_A21SGCitaDisponibilidadId,
            P00312_A70SGCitaDisponibilidadEspecialidadId, P00312_A81SGCitaDisponibilidadProfesionalId, P00312_A19CitaId, P00312_A37EncuestaId, P00312_A153EncuestaEstado, P00312_n153EncuestaEstado, P00312_A151EncuestaComentarios, P00312_n151EncuestaComentarios, P00312_A149EncuestaAtendido, P00312_n149EncuestaAtendido,
            P00312_A148EncuestaAtencion, P00312_n148EncuestaAtencion, P00312_A78SGCitaDisponibilidadClinicaNombre, P00312_A105PacienteNombres, P00312_A104PacienteApellidoMaterno, P00312_A103PacienteApellidoPaterno, P00312_A146SGCitaDisponibilidadEspecialidadNombre, P00312_A84ProfesionalNombres, P00312_n84ProfesionalNombres, P00312_A85ProfesionalApellidoPaterno,
            P00312_n85ProfesionalApellidoPaterno, P00312_A86ProfesionalApellidoMaterno, P00312_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P00313_A72SGCitaDisponibilidadSedeId, P00313_A146SGCitaDisponibilidadEspecialidadNombre, P00313_A152EncuestaRecomendacion, P00313_A150EncuestaHoraAtencion, P00313_n150EncuestaHoraAtencion, P00313_A76SGCitaDisponibilidadClinicaId, P00313_A20PacienteId, P00313_A66SGCitaDisponibilidadFecha, P00313_n66SGCitaDisponibilidadFecha, P00313_A21SGCitaDisponibilidadId,
            P00313_A70SGCitaDisponibilidadEspecialidadId, P00313_A81SGCitaDisponibilidadProfesionalId, P00313_A19CitaId, P00313_A37EncuestaId, P00313_A153EncuestaEstado, P00313_n153EncuestaEstado, P00313_A151EncuestaComentarios, P00313_n151EncuestaComentarios, P00313_A149EncuestaAtendido, P00313_n149EncuestaAtendido,
            P00313_A148EncuestaAtencion, P00313_n148EncuestaAtencion, P00313_A78SGCitaDisponibilidadClinicaNombre, P00313_A105PacienteNombres, P00313_A104PacienteApellidoMaterno, P00313_A103PacienteApellidoPaterno, P00313_A82SGCitaDisponibilidadProFullName, P00313_A84ProfesionalNombres, P00313_n84ProfesionalNombres, P00313_A85ProfesionalApellidoPaterno,
            P00313_n85ProfesionalApellidoPaterno, P00313_A86ProfesionalApellidoMaterno, P00313_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P00314_A72SGCitaDisponibilidadSedeId, P00314_A103PacienteApellidoPaterno, P00314_A152EncuestaRecomendacion, P00314_A150EncuestaHoraAtencion, P00314_n150EncuestaHoraAtencion, P00314_A76SGCitaDisponibilidadClinicaId, P00314_A20PacienteId, P00314_A66SGCitaDisponibilidadFecha, P00314_n66SGCitaDisponibilidadFecha, P00314_A21SGCitaDisponibilidadId,
            P00314_A70SGCitaDisponibilidadEspecialidadId, P00314_A81SGCitaDisponibilidadProfesionalId, P00314_A19CitaId, P00314_A37EncuestaId, P00314_A153EncuestaEstado, P00314_n153EncuestaEstado, P00314_A151EncuestaComentarios, P00314_n151EncuestaComentarios, P00314_A149EncuestaAtendido, P00314_n149EncuestaAtendido,
            P00314_A148EncuestaAtencion, P00314_n148EncuestaAtencion, P00314_A78SGCitaDisponibilidadClinicaNombre, P00314_A105PacienteNombres, P00314_A104PacienteApellidoMaterno, P00314_A146SGCitaDisponibilidadEspecialidadNombre, P00314_A82SGCitaDisponibilidadProFullName, P00314_A84ProfesionalNombres, P00314_n84ProfesionalNombres, P00314_A85ProfesionalApellidoPaterno,
            P00314_n85ProfesionalApellidoPaterno, P00314_A86ProfesionalApellidoMaterno, P00314_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P00315_A72SGCitaDisponibilidadSedeId, P00315_A104PacienteApellidoMaterno, P00315_A152EncuestaRecomendacion, P00315_A150EncuestaHoraAtencion, P00315_n150EncuestaHoraAtencion, P00315_A76SGCitaDisponibilidadClinicaId, P00315_A20PacienteId, P00315_A66SGCitaDisponibilidadFecha, P00315_n66SGCitaDisponibilidadFecha, P00315_A21SGCitaDisponibilidadId,
            P00315_A70SGCitaDisponibilidadEspecialidadId, P00315_A81SGCitaDisponibilidadProfesionalId, P00315_A19CitaId, P00315_A37EncuestaId, P00315_A153EncuestaEstado, P00315_n153EncuestaEstado, P00315_A151EncuestaComentarios, P00315_n151EncuestaComentarios, P00315_A149EncuestaAtendido, P00315_n149EncuestaAtendido,
            P00315_A148EncuestaAtencion, P00315_n148EncuestaAtencion, P00315_A78SGCitaDisponibilidadClinicaNombre, P00315_A105PacienteNombres, P00315_A103PacienteApellidoPaterno, P00315_A146SGCitaDisponibilidadEspecialidadNombre, P00315_A82SGCitaDisponibilidadProFullName, P00315_A84ProfesionalNombres, P00315_n84ProfesionalNombres, P00315_A85ProfesionalApellidoPaterno,
            P00315_n85ProfesionalApellidoPaterno, P00315_A86ProfesionalApellidoMaterno, P00315_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P00316_A72SGCitaDisponibilidadSedeId, P00316_A105PacienteNombres, P00316_A152EncuestaRecomendacion, P00316_A150EncuestaHoraAtencion, P00316_n150EncuestaHoraAtencion, P00316_A76SGCitaDisponibilidadClinicaId, P00316_A20PacienteId, P00316_A66SGCitaDisponibilidadFecha, P00316_n66SGCitaDisponibilidadFecha, P00316_A21SGCitaDisponibilidadId,
            P00316_A70SGCitaDisponibilidadEspecialidadId, P00316_A81SGCitaDisponibilidadProfesionalId, P00316_A19CitaId, P00316_A37EncuestaId, P00316_A153EncuestaEstado, P00316_n153EncuestaEstado, P00316_A151EncuestaComentarios, P00316_n151EncuestaComentarios, P00316_A149EncuestaAtendido, P00316_n149EncuestaAtendido,
            P00316_A148EncuestaAtencion, P00316_n148EncuestaAtencion, P00316_A78SGCitaDisponibilidadClinicaNombre, P00316_A104PacienteApellidoMaterno, P00316_A103PacienteApellidoPaterno, P00316_A146SGCitaDisponibilidadEspecialidadNombre, P00316_A82SGCitaDisponibilidadProFullName, P00316_A84ProfesionalNombres, P00316_n84ProfesionalNombres, P00316_A85ProfesionalApellidoPaterno,
            P00316_n85ProfesionalApellidoPaterno, P00316_A86ProfesionalApellidoMaterno, P00316_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P00317_A72SGCitaDisponibilidadSedeId, P00317_A78SGCitaDisponibilidadClinicaNombre, P00317_A152EncuestaRecomendacion, P00317_A150EncuestaHoraAtencion, P00317_n150EncuestaHoraAtencion, P00317_A76SGCitaDisponibilidadClinicaId, P00317_A20PacienteId, P00317_A66SGCitaDisponibilidadFecha, P00317_n66SGCitaDisponibilidadFecha, P00317_A21SGCitaDisponibilidadId,
            P00317_A70SGCitaDisponibilidadEspecialidadId, P00317_A81SGCitaDisponibilidadProfesionalId, P00317_A19CitaId, P00317_A37EncuestaId, P00317_A153EncuestaEstado, P00317_n153EncuestaEstado, P00317_A151EncuestaComentarios, P00317_n151EncuestaComentarios, P00317_A149EncuestaAtendido, P00317_n149EncuestaAtendido,
            P00317_A148EncuestaAtencion, P00317_n148EncuestaAtencion, P00317_A105PacienteNombres, P00317_A104PacienteApellidoMaterno, P00317_A103PacienteApellidoPaterno, P00317_A146SGCitaDisponibilidadEspecialidadNombre, P00317_A82SGCitaDisponibilidadProFullName, P00317_A84ProfesionalNombres, P00317_n84ProfesionalNombres, P00317_A85ProfesionalApellidoPaterno,
            P00317_n85ProfesionalApellidoPaterno, P00317_A86ProfesionalApellidoMaterno, P00317_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            P00318_A72SGCitaDisponibilidadSedeId, P00318_A151EncuestaComentarios, P00318_n151EncuestaComentarios, P00318_A152EncuestaRecomendacion, P00318_A150EncuestaHoraAtencion, P00318_n150EncuestaHoraAtencion, P00318_A76SGCitaDisponibilidadClinicaId, P00318_A20PacienteId, P00318_A66SGCitaDisponibilidadFecha, P00318_n66SGCitaDisponibilidadFecha,
            P00318_A21SGCitaDisponibilidadId, P00318_A70SGCitaDisponibilidadEspecialidadId, P00318_A81SGCitaDisponibilidadProfesionalId, P00318_A19CitaId, P00318_A37EncuestaId, P00318_A153EncuestaEstado, P00318_n153EncuestaEstado, P00318_A149EncuestaAtendido, P00318_n149EncuestaAtendido, P00318_A148EncuestaAtencion,
            P00318_n148EncuestaAtencion, P00318_A78SGCitaDisponibilidadClinicaNombre, P00318_A105PacienteNombres, P00318_A104PacienteApellidoMaterno, P00318_A103PacienteApellidoPaterno, P00318_A146SGCitaDisponibilidadEspecialidadNombre, P00318_A82SGCitaDisponibilidadProFullName, P00318_A84ProfesionalNombres, P00318_n84ProfesionalNombres, P00318_A85ProfesionalApellidoPaterno,
            P00318_n85ProfesionalApellidoPaterno, P00318_A86ProfesionalApellidoMaterno, P00318_n86ProfesionalApellidoMaterno
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV47TFEncuestaRecomendacion ;
   private byte AV48TFEncuestaRecomendacion_To ;
   private byte AV110Encuestawwds_36_tfencuestarecomendacion ;
   private byte AV111Encuestawwds_37_tfencuestarecomendacion_to ;
   private byte A152EncuestaRecomendacion ;
   private short AV11TFEncuestaId ;
   private short AV12TFEncuestaId_To ;
   private short AV19TFSGCitaDisponibilidadEspecialidadId ;
   private short AV20TFSGCitaDisponibilidadEspecialidadId_To ;
   private short AV35TFSGCitaDisponibilidadClinicaId ;
   private short AV36TFSGCitaDisponibilidadClinicaId_To ;
   private short AV76Encuestawwds_2_tfencuestaid ;
   private short AV77Encuestawwds_3_tfencuestaid_to ;
   private short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ;
   private short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ;
   private short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ;
   private short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ;
   private short A37EncuestaId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short Gx_err ;
   private int AV73GXV1 ;
   private int AV13TFCitaId ;
   private int AV14TFCitaId_To ;
   private int AV15TFSGCitaDisponibilidadProfesionalId ;
   private int AV16TFSGCitaDisponibilidadProfesionalId_To ;
   private int AV23TFSGCitaDisponibilidadId ;
   private int AV24TFSGCitaDisponibilidadId_To ;
   private int AV27TFPacienteId ;
   private int AV28TFPacienteId_To ;
   private int AV78Encuestawwds_4_tfcitaid ;
   private int AV79Encuestawwds_5_tfcitaid_to ;
   private int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ;
   private int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ;
   private int AV88Encuestawwds_14_tfsgcitadisponibilidadid ;
   private int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ;
   private int AV92Encuestawwds_18_tfpacienteid ;
   private int AV93Encuestawwds_19_tfpacienteid_to ;
   private int AV104Encuestawwds_30_tfencuestaatencion_sels_size ;
   private int AV105Encuestawwds_31_tfencuestaatendido_sels_size ;
   private int AV112Encuestawwds_38_tfencuestaestado_sels_size ;
   private int A19CitaId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private int A20PacienteId ;
   private long AV63count ;
   private String scmdbuf ;
   private String A148EncuestaAtencion ;
   private String A149EncuestaAtendido ;
   private String A153EncuestaEstado ;
   private java.util.Date AV43TFEncuestaHoraAtencion ;
   private java.util.Date AV44TFEncuestaHoraAtencion_To ;
   private java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ;
   private java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ;
   private java.util.Date A150EncuestaHoraAtencion ;
   private java.util.Date AV25TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV26TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk312 ;
   private boolean n150EncuestaHoraAtencion ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n153EncuestaEstado ;
   private boolean n151EncuestaComentarios ;
   private boolean n149EncuestaAtendido ;
   private boolean n148EncuestaAtencion ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean brk314 ;
   private boolean brk316 ;
   private boolean brk318 ;
   private boolean brk3110 ;
   private boolean brk3112 ;
   private boolean brk3114 ;
   private String AV57OptionsJson ;
   private String AV60OptionsDescJson ;
   private String AV62OptionIndexesJson ;
   private String AV39TFEncuestaAtencion_SelsJson ;
   private String AV41TFEncuestaAtendido_SelsJson ;
   private String AV49TFEncuestaEstado_SelsJson ;
   private String A151EncuestaComentarios ;
   private String AV53DDOName ;
   private String AV51SearchTxt ;
   private String AV52SearchTxtTo ;
   private String AV69FilterFullText ;
   private String AV17TFSGCitaDisponibilidadProFullName ;
   private String AV18TFSGCitaDisponibilidadProFullName_Sel ;
   private String AV21TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV22TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV29TFPacienteApellidoPaterno ;
   private String AV30TFPacienteApellidoPaterno_Sel ;
   private String AV31TFPacienteApellidoMaterno ;
   private String AV32TFPacienteApellidoMaterno_Sel ;
   private String AV33TFPacienteNombres ;
   private String AV34TFPacienteNombres_Sel ;
   private String AV37TFSGCitaDisponibilidadClinicaNombre ;
   private String AV70TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV45TFEncuestaComentarios ;
   private String AV46TFEncuestaComentarios_Sel ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String AV75Encuestawwds_1_filterfulltext ;
   private String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ;
   private String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV94Encuestawwds_20_tfpacienteapellidopaterno ;
   private String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ;
   private String AV96Encuestawwds_22_tfpacienteapellidomaterno ;
   private String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ;
   private String AV98Encuestawwds_24_tfpacientenombres ;
   private String AV99Encuestawwds_25_tfpacientenombres_sel ;
   private String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV108Encuestawwds_34_tfencuestacomentarios ;
   private String AV109Encuestawwds_35_tfencuestacomentarios_sel ;
   private String lV75Encuestawwds_1_filterfulltext ;
   private String lV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ;
   private String lV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV94Encuestawwds_20_tfpacienteapellidopaterno ;
   private String lV96Encuestawwds_22_tfpacienteapellidomaterno ;
   private String lV98Encuestawwds_24_tfpacientenombres ;
   private String lV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ;
   private String lV108Encuestawwds_34_tfencuestacomentarios ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String AV55Option ;
   private com.genexus.webpanels.WebSession AV64Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00312_A72SGCitaDisponibilidadSedeId ;
   private String[] P00312_A82SGCitaDisponibilidadProFullName ;
   private byte[] P00312_A152EncuestaRecomendacion ;
   private java.util.Date[] P00312_A150EncuestaHoraAtencion ;
   private boolean[] P00312_n150EncuestaHoraAtencion ;
   private short[] P00312_A76SGCitaDisponibilidadClinicaId ;
   private int[] P00312_A20PacienteId ;
   private java.util.Date[] P00312_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00312_n66SGCitaDisponibilidadFecha ;
   private int[] P00312_A21SGCitaDisponibilidadId ;
   private short[] P00312_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P00312_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P00312_A19CitaId ;
   private short[] P00312_A37EncuestaId ;
   private String[] P00312_A153EncuestaEstado ;
   private boolean[] P00312_n153EncuestaEstado ;
   private String[] P00312_A151EncuestaComentarios ;
   private boolean[] P00312_n151EncuestaComentarios ;
   private String[] P00312_A149EncuestaAtendido ;
   private boolean[] P00312_n149EncuestaAtendido ;
   private String[] P00312_A148EncuestaAtencion ;
   private boolean[] P00312_n148EncuestaAtencion ;
   private String[] P00312_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00312_A105PacienteNombres ;
   private String[] P00312_A104PacienteApellidoMaterno ;
   private String[] P00312_A103PacienteApellidoPaterno ;
   private String[] P00312_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00312_A84ProfesionalNombres ;
   private boolean[] P00312_n84ProfesionalNombres ;
   private String[] P00312_A85ProfesionalApellidoPaterno ;
   private boolean[] P00312_n85ProfesionalApellidoPaterno ;
   private String[] P00312_A86ProfesionalApellidoMaterno ;
   private boolean[] P00312_n86ProfesionalApellidoMaterno ;
   private short[] P00313_A72SGCitaDisponibilidadSedeId ;
   private String[] P00313_A146SGCitaDisponibilidadEspecialidadNombre ;
   private byte[] P00313_A152EncuestaRecomendacion ;
   private java.util.Date[] P00313_A150EncuestaHoraAtencion ;
   private boolean[] P00313_n150EncuestaHoraAtencion ;
   private short[] P00313_A76SGCitaDisponibilidadClinicaId ;
   private int[] P00313_A20PacienteId ;
   private java.util.Date[] P00313_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00313_n66SGCitaDisponibilidadFecha ;
   private int[] P00313_A21SGCitaDisponibilidadId ;
   private short[] P00313_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P00313_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P00313_A19CitaId ;
   private short[] P00313_A37EncuestaId ;
   private String[] P00313_A153EncuestaEstado ;
   private boolean[] P00313_n153EncuestaEstado ;
   private String[] P00313_A151EncuestaComentarios ;
   private boolean[] P00313_n151EncuestaComentarios ;
   private String[] P00313_A149EncuestaAtendido ;
   private boolean[] P00313_n149EncuestaAtendido ;
   private String[] P00313_A148EncuestaAtencion ;
   private boolean[] P00313_n148EncuestaAtencion ;
   private String[] P00313_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00313_A105PacienteNombres ;
   private String[] P00313_A104PacienteApellidoMaterno ;
   private String[] P00313_A103PacienteApellidoPaterno ;
   private String[] P00313_A82SGCitaDisponibilidadProFullName ;
   private String[] P00313_A84ProfesionalNombres ;
   private boolean[] P00313_n84ProfesionalNombres ;
   private String[] P00313_A85ProfesionalApellidoPaterno ;
   private boolean[] P00313_n85ProfesionalApellidoPaterno ;
   private String[] P00313_A86ProfesionalApellidoMaterno ;
   private boolean[] P00313_n86ProfesionalApellidoMaterno ;
   private short[] P00314_A72SGCitaDisponibilidadSedeId ;
   private String[] P00314_A103PacienteApellidoPaterno ;
   private byte[] P00314_A152EncuestaRecomendacion ;
   private java.util.Date[] P00314_A150EncuestaHoraAtencion ;
   private boolean[] P00314_n150EncuestaHoraAtencion ;
   private short[] P00314_A76SGCitaDisponibilidadClinicaId ;
   private int[] P00314_A20PacienteId ;
   private java.util.Date[] P00314_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00314_n66SGCitaDisponibilidadFecha ;
   private int[] P00314_A21SGCitaDisponibilidadId ;
   private short[] P00314_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P00314_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P00314_A19CitaId ;
   private short[] P00314_A37EncuestaId ;
   private String[] P00314_A153EncuestaEstado ;
   private boolean[] P00314_n153EncuestaEstado ;
   private String[] P00314_A151EncuestaComentarios ;
   private boolean[] P00314_n151EncuestaComentarios ;
   private String[] P00314_A149EncuestaAtendido ;
   private boolean[] P00314_n149EncuestaAtendido ;
   private String[] P00314_A148EncuestaAtencion ;
   private boolean[] P00314_n148EncuestaAtencion ;
   private String[] P00314_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00314_A105PacienteNombres ;
   private String[] P00314_A104PacienteApellidoMaterno ;
   private String[] P00314_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00314_A82SGCitaDisponibilidadProFullName ;
   private String[] P00314_A84ProfesionalNombres ;
   private boolean[] P00314_n84ProfesionalNombres ;
   private String[] P00314_A85ProfesionalApellidoPaterno ;
   private boolean[] P00314_n85ProfesionalApellidoPaterno ;
   private String[] P00314_A86ProfesionalApellidoMaterno ;
   private boolean[] P00314_n86ProfesionalApellidoMaterno ;
   private short[] P00315_A72SGCitaDisponibilidadSedeId ;
   private String[] P00315_A104PacienteApellidoMaterno ;
   private byte[] P00315_A152EncuestaRecomendacion ;
   private java.util.Date[] P00315_A150EncuestaHoraAtencion ;
   private boolean[] P00315_n150EncuestaHoraAtencion ;
   private short[] P00315_A76SGCitaDisponibilidadClinicaId ;
   private int[] P00315_A20PacienteId ;
   private java.util.Date[] P00315_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00315_n66SGCitaDisponibilidadFecha ;
   private int[] P00315_A21SGCitaDisponibilidadId ;
   private short[] P00315_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P00315_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P00315_A19CitaId ;
   private short[] P00315_A37EncuestaId ;
   private String[] P00315_A153EncuestaEstado ;
   private boolean[] P00315_n153EncuestaEstado ;
   private String[] P00315_A151EncuestaComentarios ;
   private boolean[] P00315_n151EncuestaComentarios ;
   private String[] P00315_A149EncuestaAtendido ;
   private boolean[] P00315_n149EncuestaAtendido ;
   private String[] P00315_A148EncuestaAtencion ;
   private boolean[] P00315_n148EncuestaAtencion ;
   private String[] P00315_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00315_A105PacienteNombres ;
   private String[] P00315_A103PacienteApellidoPaterno ;
   private String[] P00315_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00315_A82SGCitaDisponibilidadProFullName ;
   private String[] P00315_A84ProfesionalNombres ;
   private boolean[] P00315_n84ProfesionalNombres ;
   private String[] P00315_A85ProfesionalApellidoPaterno ;
   private boolean[] P00315_n85ProfesionalApellidoPaterno ;
   private String[] P00315_A86ProfesionalApellidoMaterno ;
   private boolean[] P00315_n86ProfesionalApellidoMaterno ;
   private short[] P00316_A72SGCitaDisponibilidadSedeId ;
   private String[] P00316_A105PacienteNombres ;
   private byte[] P00316_A152EncuestaRecomendacion ;
   private java.util.Date[] P00316_A150EncuestaHoraAtencion ;
   private boolean[] P00316_n150EncuestaHoraAtencion ;
   private short[] P00316_A76SGCitaDisponibilidadClinicaId ;
   private int[] P00316_A20PacienteId ;
   private java.util.Date[] P00316_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00316_n66SGCitaDisponibilidadFecha ;
   private int[] P00316_A21SGCitaDisponibilidadId ;
   private short[] P00316_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P00316_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P00316_A19CitaId ;
   private short[] P00316_A37EncuestaId ;
   private String[] P00316_A153EncuestaEstado ;
   private boolean[] P00316_n153EncuestaEstado ;
   private String[] P00316_A151EncuestaComentarios ;
   private boolean[] P00316_n151EncuestaComentarios ;
   private String[] P00316_A149EncuestaAtendido ;
   private boolean[] P00316_n149EncuestaAtendido ;
   private String[] P00316_A148EncuestaAtencion ;
   private boolean[] P00316_n148EncuestaAtencion ;
   private String[] P00316_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00316_A104PacienteApellidoMaterno ;
   private String[] P00316_A103PacienteApellidoPaterno ;
   private String[] P00316_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00316_A82SGCitaDisponibilidadProFullName ;
   private String[] P00316_A84ProfesionalNombres ;
   private boolean[] P00316_n84ProfesionalNombres ;
   private String[] P00316_A85ProfesionalApellidoPaterno ;
   private boolean[] P00316_n85ProfesionalApellidoPaterno ;
   private String[] P00316_A86ProfesionalApellidoMaterno ;
   private boolean[] P00316_n86ProfesionalApellidoMaterno ;
   private short[] P00317_A72SGCitaDisponibilidadSedeId ;
   private String[] P00317_A78SGCitaDisponibilidadClinicaNombre ;
   private byte[] P00317_A152EncuestaRecomendacion ;
   private java.util.Date[] P00317_A150EncuestaHoraAtencion ;
   private boolean[] P00317_n150EncuestaHoraAtencion ;
   private short[] P00317_A76SGCitaDisponibilidadClinicaId ;
   private int[] P00317_A20PacienteId ;
   private java.util.Date[] P00317_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00317_n66SGCitaDisponibilidadFecha ;
   private int[] P00317_A21SGCitaDisponibilidadId ;
   private short[] P00317_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P00317_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P00317_A19CitaId ;
   private short[] P00317_A37EncuestaId ;
   private String[] P00317_A153EncuestaEstado ;
   private boolean[] P00317_n153EncuestaEstado ;
   private String[] P00317_A151EncuestaComentarios ;
   private boolean[] P00317_n151EncuestaComentarios ;
   private String[] P00317_A149EncuestaAtendido ;
   private boolean[] P00317_n149EncuestaAtendido ;
   private String[] P00317_A148EncuestaAtencion ;
   private boolean[] P00317_n148EncuestaAtencion ;
   private String[] P00317_A105PacienteNombres ;
   private String[] P00317_A104PacienteApellidoMaterno ;
   private String[] P00317_A103PacienteApellidoPaterno ;
   private String[] P00317_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00317_A82SGCitaDisponibilidadProFullName ;
   private String[] P00317_A84ProfesionalNombres ;
   private boolean[] P00317_n84ProfesionalNombres ;
   private String[] P00317_A85ProfesionalApellidoPaterno ;
   private boolean[] P00317_n85ProfesionalApellidoPaterno ;
   private String[] P00317_A86ProfesionalApellidoMaterno ;
   private boolean[] P00317_n86ProfesionalApellidoMaterno ;
   private short[] P00318_A72SGCitaDisponibilidadSedeId ;
   private String[] P00318_A151EncuestaComentarios ;
   private boolean[] P00318_n151EncuestaComentarios ;
   private byte[] P00318_A152EncuestaRecomendacion ;
   private java.util.Date[] P00318_A150EncuestaHoraAtencion ;
   private boolean[] P00318_n150EncuestaHoraAtencion ;
   private short[] P00318_A76SGCitaDisponibilidadClinicaId ;
   private int[] P00318_A20PacienteId ;
   private java.util.Date[] P00318_A66SGCitaDisponibilidadFecha ;
   private boolean[] P00318_n66SGCitaDisponibilidadFecha ;
   private int[] P00318_A21SGCitaDisponibilidadId ;
   private short[] P00318_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] P00318_A81SGCitaDisponibilidadProfesionalId ;
   private int[] P00318_A19CitaId ;
   private short[] P00318_A37EncuestaId ;
   private String[] P00318_A153EncuestaEstado ;
   private boolean[] P00318_n153EncuestaEstado ;
   private String[] P00318_A149EncuestaAtendido ;
   private boolean[] P00318_n149EncuestaAtendido ;
   private String[] P00318_A148EncuestaAtencion ;
   private boolean[] P00318_n148EncuestaAtencion ;
   private String[] P00318_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P00318_A105PacienteNombres ;
   private String[] P00318_A104PacienteApellidoMaterno ;
   private String[] P00318_A103PacienteApellidoPaterno ;
   private String[] P00318_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P00318_A82SGCitaDisponibilidadProFullName ;
   private String[] P00318_A84ProfesionalNombres ;
   private boolean[] P00318_n84ProfesionalNombres ;
   private String[] P00318_A85ProfesionalApellidoPaterno ;
   private boolean[] P00318_n85ProfesionalApellidoPaterno ;
   private String[] P00318_A86ProfesionalApellidoMaterno ;
   private boolean[] P00318_n86ProfesionalApellidoMaterno ;
   private GXSimpleCollection<String> AV40TFEncuestaAtencion_Sels ;
   private GXSimpleCollection<String> AV42TFEncuestaAtendido_Sels ;
   private GXSimpleCollection<String> AV50TFEncuestaEstado_Sels ;
   private GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ;
   private GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ;
   private GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ;
   private GXSimpleCollection<String> AV56Options ;
   private GXSimpleCollection<String> AV59OptionsDesc ;
   private GXSimpleCollection<String> AV61OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV66GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV67GridStateFilterValue ;
}

final  class encuestawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00312( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV76Encuestawwds_2_tfencuestaid ,
                                          short AV77Encuestawwds_3_tfencuestaid_to ,
                                          int AV78Encuestawwds_4_tfcitaid ,
                                          int AV79Encuestawwds_5_tfcitaid_to ,
                                          int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV88Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV92Encuestawwds_18_tfpacienteid ,
                                          int AV93Encuestawwds_19_tfpacienteid_to ,
                                          String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV99Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV98Encuestawwds_24_tfpacientenombres ,
                                          short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV104Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV105Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV108Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV110Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV111Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV112Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          String AV75Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[57];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '')" ;
      scmdbuf += " + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T1.[EncuestaRecomendacion], T1.[EncuestaHoraAtencion], T5.[ClinicaId]" ;
      scmdbuf += " AS SGCitaDisponibilidadClinicaId, T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId," ;
      scmdbuf += " T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T1.[EncuestaEstado]," ;
      scmdbuf += " T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteNombres]," ;
      scmdbuf += " T3.[PacienteApellidoMaterno], T3.[PacienteApellidoPaterno], T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno]," ;
      scmdbuf += " T8.[ProfesionalApellidoMaterno] FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId])" ;
      scmdbuf += " INNER JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER" ;
      scmdbuf += " JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON" ;
      scmdbuf += " T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV76Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( ! (0==AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (0==AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( ! (0==AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (0==AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( ! (0==AV88Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV96Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int4[47] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int4[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int4[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int4[50] = (byte)(1) ;
      }
      if ( AV104Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV105Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV105Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int4[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV107Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int4[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int4[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int4[54] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int4[55] = (byte)(1) ;
      }
      if ( ! (0==AV111Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int4[56] = (byte)(1) ;
      }
      if ( AV112Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [SGCitaDisponibilidadProFullName]" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00313( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV76Encuestawwds_2_tfencuestaid ,
                                          short AV77Encuestawwds_3_tfencuestaid_to ,
                                          int AV78Encuestawwds_4_tfcitaid ,
                                          int AV79Encuestawwds_5_tfcitaid_to ,
                                          int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV88Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV92Encuestawwds_18_tfpacienteid ,
                                          int AV93Encuestawwds_19_tfpacienteid_to ,
                                          String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV99Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV98Encuestawwds_24_tfpacientenombres ,
                                          short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV104Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV105Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV108Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV110Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV111Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV112Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          String AV75Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[57];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T1.[EncuestaRecomendacion]," ;
      scmdbuf += " T1.[EncuestaHoraAtencion], T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId]" ;
      scmdbuf += " AS SGCitaDisponibilidadId, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId]," ;
      scmdbuf += " T1.[EncuestaEstado], T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteNombres]," ;
      scmdbuf += " T3.[PacienteApellidoMaterno], T3.[PacienteApellidoPaterno], COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' '" ;
      scmdbuf += " + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad]" ;
      scmdbuf += " T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId]" ;
      scmdbuf += " = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV76Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int7[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int7[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int7[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int7[26] = (byte)(1) ;
      }
      if ( ! (0==AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int7[27] = (byte)(1) ;
      }
      if ( ! (0==AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int7[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int7[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int7[30] = (byte)(1) ;
      }
      if ( ! (0==AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int7[31] = (byte)(1) ;
      }
      if ( ! (0==AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int7[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int7[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int7[34] = (byte)(1) ;
      }
      if ( ! (0==AV88Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int7[35] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int7[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int7[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int7[38] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int7[39] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int7[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int7[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int7[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV96Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int7[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int7[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int7[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int7[46] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int7[47] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int7[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int7[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int7[50] = (byte)(1) ;
      }
      if ( AV104Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV105Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV105Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int7[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV107Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int7[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int7[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int7[54] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int7[55] = (byte)(1) ;
      }
      if ( ! (0==AV111Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int7[56] = (byte)(1) ;
      }
      if ( AV112Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T7.[EspecialidadNombre]" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P00314( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV76Encuestawwds_2_tfencuestaid ,
                                          short AV77Encuestawwds_3_tfencuestaid_to ,
                                          int AV78Encuestawwds_4_tfcitaid ,
                                          int AV79Encuestawwds_5_tfcitaid_to ,
                                          int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV88Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV92Encuestawwds_18_tfpacienteid ,
                                          int AV93Encuestawwds_19_tfpacienteid_to ,
                                          String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV99Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV98Encuestawwds_24_tfpacientenombres ,
                                          short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV104Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV105Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV108Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV110Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV111Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV112Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          String AV75Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[57];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T3.[PacienteApellidoPaterno], T1.[EncuestaRecomendacion], T1.[EncuestaHoraAtencion], T5.[ClinicaId]" ;
      scmdbuf += " AS SGCitaDisponibilidadClinicaId, T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId," ;
      scmdbuf += " T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T1.[EncuestaEstado]," ;
      scmdbuf += " T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteNombres]," ;
      scmdbuf += " T3.[PacienteApellidoMaterno], T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno]," ;
      scmdbuf += " '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad]" ;
      scmdbuf += " T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId]" ;
      scmdbuf += " = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV76Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( ! (0==AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (0==AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( ! (0==AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( ! (0==AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int10[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int10[34] = (byte)(1) ;
      }
      if ( ! (0==AV88Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int10[35] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int10[38] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int10[39] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int10[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int10[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int10[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV96Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int10[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int10[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int10[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int10[46] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int10[47] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int10[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int10[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int10[50] = (byte)(1) ;
      }
      if ( AV104Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV105Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV105Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int10[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV107Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int10[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int10[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int10[54] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int10[55] = (byte)(1) ;
      }
      if ( ! (0==AV111Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int10[56] = (byte)(1) ;
      }
      if ( AV112Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[PacienteApellidoPaterno]" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P00315( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV76Encuestawwds_2_tfencuestaid ,
                                          short AV77Encuestawwds_3_tfencuestaid_to ,
                                          int AV78Encuestawwds_4_tfcitaid ,
                                          int AV79Encuestawwds_5_tfcitaid_to ,
                                          int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV88Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV92Encuestawwds_18_tfpacienteid ,
                                          int AV93Encuestawwds_19_tfpacienteid_to ,
                                          String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV99Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV98Encuestawwds_24_tfpacientenombres ,
                                          short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV104Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV105Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV108Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV110Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV111Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV112Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          String AV75Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[57];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T3.[PacienteApellidoMaterno], T1.[EncuestaRecomendacion], T1.[EncuestaHoraAtencion], T5.[ClinicaId]" ;
      scmdbuf += " AS SGCitaDisponibilidadClinicaId, T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId," ;
      scmdbuf += " T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T1.[EncuestaEstado]," ;
      scmdbuf += " T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteNombres]," ;
      scmdbuf += " T3.[PacienteApellidoPaterno], T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno]," ;
      scmdbuf += " '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad]" ;
      scmdbuf += " T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId]" ;
      scmdbuf += " = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV76Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int13[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int13[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int13[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int13[26] = (byte)(1) ;
      }
      if ( ! (0==AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int13[27] = (byte)(1) ;
      }
      if ( ! (0==AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int13[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int13[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int13[30] = (byte)(1) ;
      }
      if ( ! (0==AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int13[31] = (byte)(1) ;
      }
      if ( ! (0==AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int13[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int13[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int13[34] = (byte)(1) ;
      }
      if ( ! (0==AV88Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int13[35] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int13[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int13[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int13[38] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int13[39] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int13[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int13[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int13[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV96Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int13[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int13[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int13[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int13[46] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int13[47] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int13[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int13[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int13[50] = (byte)(1) ;
      }
      if ( AV104Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV105Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV105Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int13[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV107Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int13[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int13[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int13[54] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int13[55] = (byte)(1) ;
      }
      if ( ! (0==AV111Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int13[56] = (byte)(1) ;
      }
      if ( AV112Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[PacienteApellidoMaterno]" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P00316( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV76Encuestawwds_2_tfencuestaid ,
                                          short AV77Encuestawwds_3_tfencuestaid_to ,
                                          int AV78Encuestawwds_4_tfcitaid ,
                                          int AV79Encuestawwds_5_tfcitaid_to ,
                                          int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV88Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV92Encuestawwds_18_tfpacienteid ,
                                          int AV93Encuestawwds_19_tfpacienteid_to ,
                                          String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV99Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV98Encuestawwds_24_tfpacientenombres ,
                                          short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV104Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV105Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV108Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV110Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV111Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV112Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          String AV75Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[57];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T3.[PacienteNombres], T1.[EncuestaRecomendacion], T1.[EncuestaHoraAtencion], T5.[ClinicaId]" ;
      scmdbuf += " AS SGCitaDisponibilidadClinicaId, T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId," ;
      scmdbuf += " T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T1.[EncuestaEstado]," ;
      scmdbuf += " T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteApellidoMaterno]," ;
      scmdbuf += " T3.[PacienteApellidoPaterno], T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno]," ;
      scmdbuf += " '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad]" ;
      scmdbuf += " T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId]" ;
      scmdbuf += " = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV76Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int16[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int16[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int16[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int16[26] = (byte)(1) ;
      }
      if ( ! (0==AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int16[27] = (byte)(1) ;
      }
      if ( ! (0==AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int16[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int16[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int16[30] = (byte)(1) ;
      }
      if ( ! (0==AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int16[31] = (byte)(1) ;
      }
      if ( ! (0==AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int16[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int16[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int16[34] = (byte)(1) ;
      }
      if ( ! (0==AV88Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int16[35] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int16[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int16[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int16[38] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int16[39] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int16[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int16[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int16[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV96Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int16[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int16[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int16[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int16[46] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int16[47] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int16[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int16[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int16[50] = (byte)(1) ;
      }
      if ( AV104Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV105Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV105Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int16[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV107Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int16[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int16[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int16[54] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int16[55] = (byte)(1) ;
      }
      if ( ! (0==AV111Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int16[56] = (byte)(1) ;
      }
      if ( AV112Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.[PacienteNombres]" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P00317( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV76Encuestawwds_2_tfencuestaid ,
                                          short AV77Encuestawwds_3_tfencuestaid_to ,
                                          int AV78Encuestawwds_4_tfcitaid ,
                                          int AV79Encuestawwds_5_tfcitaid_to ,
                                          int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV88Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV92Encuestawwds_18_tfpacienteid ,
                                          int AV93Encuestawwds_19_tfpacienteid_to ,
                                          String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV99Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV98Encuestawwds_24_tfpacientenombres ,
                                          short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV104Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV105Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV108Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV110Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV111Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV112Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          String AV75Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[57];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T1.[EncuestaRecomendacion]," ;
      scmdbuf += " T1.[EncuestaHoraAtencion], T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId]" ;
      scmdbuf += " AS SGCitaDisponibilidadId, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId]," ;
      scmdbuf += " T1.[EncuestaEstado], T1.[EncuestaComentarios], T1.[EncuestaAtendido], T1.[EncuestaAtencion], T3.[PacienteNombres], T3.[PacienteApellidoMaterno], T3.[PacienteApellidoPaterno]," ;
      scmdbuf += " T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '')" ;
      scmdbuf += " + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad]" ;
      scmdbuf += " T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId]" ;
      scmdbuf += " = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV76Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int19[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int19[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int19[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int19[26] = (byte)(1) ;
      }
      if ( ! (0==AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int19[27] = (byte)(1) ;
      }
      if ( ! (0==AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int19[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int19[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int19[30] = (byte)(1) ;
      }
      if ( ! (0==AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int19[31] = (byte)(1) ;
      }
      if ( ! (0==AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int19[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int19[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int19[34] = (byte)(1) ;
      }
      if ( ! (0==AV88Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int19[35] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int19[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int19[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int19[38] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int19[39] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int19[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int19[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int19[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV96Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int19[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int19[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int19[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int19[46] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int19[47] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int19[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int19[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int19[50] = (byte)(1) ;
      }
      if ( AV104Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV105Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV105Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int19[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV107Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int19[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int19[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int19[54] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int19[55] = (byte)(1) ;
      }
      if ( ! (0==AV111Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int19[56] = (byte)(1) ;
      }
      if ( AV112Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T6.[ClinicaNombreAbreviado]" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P00318( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A148EncuestaAtencion ,
                                          GXSimpleCollection<String> AV104Encuestawwds_30_tfencuestaatencion_sels ,
                                          String A149EncuestaAtendido ,
                                          GXSimpleCollection<String> AV105Encuestawwds_31_tfencuestaatendido_sels ,
                                          String A153EncuestaEstado ,
                                          GXSimpleCollection<String> AV112Encuestawwds_38_tfencuestaestado_sels ,
                                          short AV76Encuestawwds_2_tfencuestaid ,
                                          short AV77Encuestawwds_3_tfencuestaid_to ,
                                          int AV78Encuestawwds_4_tfcitaid ,
                                          int AV79Encuestawwds_5_tfcitaid_to ,
                                          int AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid ,
                                          int AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to ,
                                          String AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel ,
                                          String AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname ,
                                          short AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid ,
                                          short AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to ,
                                          String AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre ,
                                          int AV88Encuestawwds_14_tfsgcitadisponibilidadid ,
                                          int AV89Encuestawwds_15_tfsgcitadisponibilidadid_to ,
                                          java.util.Date AV90Encuestawwds_16_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to ,
                                          int AV92Encuestawwds_18_tfpacienteid ,
                                          int AV93Encuestawwds_19_tfpacienteid_to ,
                                          String AV95Encuestawwds_21_tfpacienteapellidopaterno_sel ,
                                          String AV94Encuestawwds_20_tfpacienteapellidopaterno ,
                                          String AV97Encuestawwds_23_tfpacienteapellidomaterno_sel ,
                                          String AV96Encuestawwds_22_tfpacienteapellidomaterno ,
                                          String AV99Encuestawwds_25_tfpacientenombres_sel ,
                                          String AV98Encuestawwds_24_tfpacientenombres ,
                                          short AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid ,
                                          short AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to ,
                                          String AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre ,
                                          int AV104Encuestawwds_30_tfencuestaatencion_sels_size ,
                                          int AV105Encuestawwds_31_tfencuestaatendido_sels_size ,
                                          java.util.Date AV106Encuestawwds_32_tfencuestahoraatencion ,
                                          java.util.Date AV107Encuestawwds_33_tfencuestahoraatencion_to ,
                                          String AV109Encuestawwds_35_tfencuestacomentarios_sel ,
                                          String AV108Encuestawwds_34_tfencuestacomentarios ,
                                          byte AV110Encuestawwds_36_tfencuestarecomendacion ,
                                          byte AV111Encuestawwds_37_tfencuestarecomendacion_to ,
                                          int AV112Encuestawwds_38_tfencuestaestado_sels_size ,
                                          short A37EncuestaId ,
                                          int A19CitaId ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          String A84ProfesionalNombres ,
                                          String A85ProfesionalApellidoPaterno ,
                                          String A86ProfesionalApellidoMaterno ,
                                          short A70SGCitaDisponibilidadEspecialidadId ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          int A21SGCitaDisponibilidadId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          int A20PacienteId ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          short A76SGCitaDisponibilidadClinicaId ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          java.util.Date A150EncuestaHoraAtencion ,
                                          String A151EncuestaComentarios ,
                                          byte A152EncuestaRecomendacion ,
                                          String AV75Encuestawwds_1_filterfulltext ,
                                          String A82SGCitaDisponibilidadProFullName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[57];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T1.[EncuestaComentarios], T1.[EncuestaRecomendacion], T1.[EncuestaHoraAtencion], T5.[ClinicaId]" ;
      scmdbuf += " AS SGCitaDisponibilidadClinicaId, T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId," ;
      scmdbuf += " T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaId], T1.[EncuestaId], T1.[EncuestaEstado]," ;
      scmdbuf += " T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[PacienteNombres], T3.[PacienteApellidoMaterno]," ;
      scmdbuf += " T3.[PacienteApellidoPaterno], T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno]," ;
      scmdbuf += " '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') AS SGCitaDisponibilidadProFullName, T8.[ProfesionalNombres], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalApellidoMaterno]" ;
      scmdbuf += " FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad]" ;
      scmdbuf += " T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId]" ;
      scmdbuf += " = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[EncuestaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T1.[CitaId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T4.[ProfesionalId] AS decimal(8,0))) like '%' + ?) or ( COALESCE( T8.[ProfesionalNombres], '') + ' ' + COALESCE( T8.[ProfesionalApellidoPaterno], '') + ' ' + COALESCE( T8.[ProfesionalApellidoMaterno], '') like '%' + ?) or ( CONVERT( char(4), CAST(T4.[EspecialidadId] AS decimal(4,0))) like '%' + ?) or ( T7.[EspecialidadNombre] like '%' + ?) or ( CONVERT( char(8), CAST(T2.[SGCitaDisponibilidadId] AS decimal(8,0))) like '%' + ?) or ( CONVERT( char(8), CAST(T2.[PacienteId] AS decimal(8,0))) like '%' + ?) or ( T3.[PacienteApellidoPaterno] like '%' + ?) or ( T3.[PacienteApellidoMaterno] like '%' + ?) or ( T3.[PacienteNombres] like '%' + ?) or ( CONVERT( char(4), CAST(T5.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'buena' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'B') or ( 'regular' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'R') or ( 'mala' like '%' + LOWER(?) and T1.[EncuestaAtencion] = 'M') or ( 'si' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'S') or ( 'no' like '%' + LOWER(?) and T1.[EncuestaAtendido] = 'N') or ( T1.[EncuestaComentarios] like '%' + ?) or ( CONVERT( char(2), CAST(T1.[EncuestaRecomendacion] AS decimal(2,0))) like '%' + ?) or ( 'pendiente' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'P') or ( 'realizada' like '%' + LOWER(?) and T1.[EncuestaEstado] = 'R')))");
      if ( ! (0==AV76Encuestawwds_2_tfencuestaid) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] >= ?)");
      }
      else
      {
         GXv_int22[23] = (byte)(1) ;
      }
      if ( ! (0==AV77Encuestawwds_3_tfencuestaid_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaId] <= ?)");
      }
      else
      {
         GXv_int22[24] = (byte)(1) ;
      }
      if ( ! (0==AV78Encuestawwds_4_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int22[25] = (byte)(1) ;
      }
      if ( ! (0==AV79Encuestawwds_5_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int22[26] = (byte)(1) ;
      }
      if ( ! (0==AV80Encuestawwds_6_tfsgcitadisponibilidadprofesionalid) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] >= ?)");
      }
      else
      {
         GXv_int22[27] = (byte)(1) ;
      }
      if ( ! (0==AV81Encuestawwds_7_tfsgcitadisponibilidadprofesionalid_to) )
      {
         addWhere(sWhereString, "(T4.[ProfesionalId] <= ?)");
      }
      else
      {
         GXv_int22[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) && ( ! (GXutil.strcmp("", AV82Encuestawwds_8_tfsgcitadisponibilidadprofullname)==0) ) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int22[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Encuestawwds_9_tfsgcitadisponibilidadprofullname_sel)==0) )
      {
         addWhere(sWhereString, "(T8.[ProfesionalNombres] + ' ' + T8.[ProfesionalApellidoPaterno] + ' ' + T8.[ProfesionalApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int22[30] = (byte)(1) ;
      }
      if ( ! (0==AV84Encuestawwds_10_tfsgcitadisponibilidadespecialidadid) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] >= ?)");
      }
      else
      {
         GXv_int22[31] = (byte)(1) ;
      }
      if ( ! (0==AV85Encuestawwds_11_tfsgcitadisponibilidadespecialidadid_to) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadId] <= ?)");
      }
      else
      {
         GXv_int22[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV86Encuestawwds_12_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int22[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Encuestawwds_13_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T7.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int22[34] = (byte)(1) ;
      }
      if ( ! (0==AV88Encuestawwds_14_tfsgcitadisponibilidadid) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] >= ?)");
      }
      else
      {
         GXv_int22[35] = (byte)(1) ;
      }
      if ( ! (0==AV89Encuestawwds_15_tfsgcitadisponibilidadid_to) )
      {
         addWhere(sWhereString, "(T2.[SGCitaDisponibilidadId] <= ?)");
      }
      else
      {
         GXv_int22[36] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Encuestawwds_16_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int22[37] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV91Encuestawwds_17_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T4.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int22[38] = (byte)(1) ;
      }
      if ( ! (0==AV92Encuestawwds_18_tfpacienteid) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] >= ?)");
      }
      else
      {
         GXv_int22[39] = (byte)(1) ;
      }
      if ( ! (0==AV93Encuestawwds_19_tfpacienteid_to) )
      {
         addWhere(sWhereString, "(T2.[PacienteId] <= ?)");
      }
      else
      {
         GXv_int22[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV94Encuestawwds_20_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int22[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV95Encuestawwds_21_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int22[42] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV96Encuestawwds_22_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int22[43] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV97Encuestawwds_23_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int22[44] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV98Encuestawwds_24_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int22[45] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV99Encuestawwds_25_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int22[46] = (byte)(1) ;
      }
      if ( ! (0==AV100Encuestawwds_26_tfsgcitadisponibilidadclinicaid) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int22[47] = (byte)(1) ;
      }
      if ( ! (0==AV101Encuestawwds_27_tfsgcitadisponibilidadclinicaid_to) )
      {
         addWhere(sWhereString, "(T5.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int22[48] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV102Encuestawwds_28_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int22[49] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV103Encuestawwds_29_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int22[50] = (byte)(1) ;
      }
      if ( AV104Encuestawwds_30_tfencuestaatencion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Encuestawwds_30_tfencuestaatencion_sels, "T1.[EncuestaAtencion] IN (", ")")+")");
      }
      if ( AV105Encuestawwds_31_tfencuestaatendido_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV105Encuestawwds_31_tfencuestaatendido_sels, "T1.[EncuestaAtendido] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV106Encuestawwds_32_tfencuestahoraatencion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] >= ?)");
      }
      else
      {
         GXv_int22[51] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV107Encuestawwds_33_tfencuestahoraatencion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaHoraAtencion] <= ?)");
      }
      else
      {
         GXv_int22[52] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) && ( ! (GXutil.strcmp("", AV108Encuestawwds_34_tfencuestacomentarios)==0) ) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] like ?)");
      }
      else
      {
         GXv_int22[53] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV109Encuestawwds_35_tfencuestacomentarios_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[EncuestaComentarios] = ?)");
      }
      else
      {
         GXv_int22[54] = (byte)(1) ;
      }
      if ( ! (0==AV110Encuestawwds_36_tfencuestarecomendacion) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] >= ?)");
      }
      else
      {
         GXv_int22[55] = (byte)(1) ;
      }
      if ( ! (0==AV111Encuestawwds_37_tfencuestarecomendacion_to) )
      {
         addWhere(sWhereString, "(T1.[EncuestaRecomendacion] <= ?)");
      }
      else
      {
         GXv_int22[56] = (byte)(1) ;
      }
      if ( AV112Encuestawwds_38_tfencuestaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV112Encuestawwds_38_tfencuestaestado_sels, "T1.[EncuestaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[EncuestaComentarios]" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
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
                  return conditional_P00312(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , (String)dynConstraints[62] , (String)dynConstraints[63] );
            case 1 :
                  return conditional_P00313(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , (String)dynConstraints[62] , (String)dynConstraints[63] );
            case 2 :
                  return conditional_P00314(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , (String)dynConstraints[62] , (String)dynConstraints[63] );
            case 3 :
                  return conditional_P00315(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , (String)dynConstraints[62] , (String)dynConstraints[63] );
            case 4 :
                  return conditional_P00316(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , (String)dynConstraints[62] , (String)dynConstraints[63] );
            case 5 :
                  return conditional_P00317(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , (String)dynConstraints[62] , (String)dynConstraints[63] );
            case 6 :
                  return conditional_P00318(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , (String)dynConstraints[32] , (String)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , (java.util.Date)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , ((Number) dynConstraints[41]).byteValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , (String)dynConstraints[46] , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).shortValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (java.util.Date)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , (String)dynConstraints[55] , (String)dynConstraints[56] , ((Number) dynConstraints[57]).shortValue() , (String)dynConstraints[58] , (java.util.Date)dynConstraints[59] , (String)dynConstraints[60] , ((Number) dynConstraints[61]).byteValue() , (String)dynConstraints[62] , (String)dynConstraints[63] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00312", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00313", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00314", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00315", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00316", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00317", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00318", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((int[]) buf[11])[0] = rslt.getInt(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(16, 1);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((int[]) buf[12])[0] = rslt.getInt(10);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((String[]) buf[15])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[76], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 100);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[80]).shortValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[81]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[82]).intValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[83]).intValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[84]).intValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[85]).intValue());
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[87], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[88]).shortValue());
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[89]).shortValue());
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[90], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[91], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[94]);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[95]);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[96]).intValue());
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[98], 100);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[99], 100);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[100], 100);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[101], 100);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[102], 100);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[103], 100);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[104]).shortValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[105]).shortValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[106], 100);
               }
               if ( ((Number) parms[50]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[107], 100);
               }
               if ( ((Number) parms[51]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[108], true);
               }
               if ( ((Number) parms[52]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[109], true);
               }
               if ( ((Number) parms[53]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[110], 200);
               }
               if ( ((Number) parms[54]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[111], 200);
               }
               if ( ((Number) parms[55]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[112]).byteValue());
               }
               if ( ((Number) parms[56]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[113]).byteValue());
               }
               return;
      }
   }

}

