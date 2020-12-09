import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {DashboardComponent} from './component/dashboard/dashboard.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {AgendaComponent} from './component/agenda/agenda.component';
import {TransparenciaComponent} from './component/transparencia/transparencia.component';
import {NoticiaComponent} from './component/noticia/noticia.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {IndexComponent} from './component/index/index.component';
import {ACvmComponent} from './component/a-cvm/a-cvm.component';
import {EducacaoInfantilComponent} from './component/educacao-infantil/educacao-infantil.component';
import {AcolhimentoInstitucionalComponent} from './component/acolhimento-institucional/acolhimento-institucional.component';
import {CasCentroAtendimentoSocialComponent} from './component/cas-centro-atendimento-social/cas-centro-atendimento-social.component';
import {FooterbarComponent} from './component/footerbar/footerbar.component';
import {LoginComponent} from "./component/login/login.component";
import {ServiceService} from "./service/service.service";
import {Logged} from "./component/auth/logged";
import {PermissoesService} from "./component/seguranca/autorizacao-service";
import {AuthGuardService} from "./component/seguranca/auth-guard-service";
import {MAT_DATE_LOCALE} from "@angular/material/core";
import {MenuComponent} from "./component/menu/menu.component";
import {MatListModule} from "@angular/material/list";
import { InclusaoProdutivaComponent } from './component/inclusao-produtiva/inclusao-produtiva.component';
import { ComunidadeTerapeuticoComponent } from './component/comunidade-terapeutico/comunidade-terapeutico.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    AgendaComponent,
    TransparenciaComponent,
    NoticiaComponent,
    IndexComponent,
    MenuComponent,
    ACvmComponent,
    LoginComponent,
    EducacaoInfantilComponent,
    AcolhimentoInstitucionalComponent,
    CasCentroAtendimentoSocialComponent,
    FooterbarComponent,
    InclusaoProdutivaComponent,
    ComunidadeTerapeuticoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatSidenavModule,
    MatListModule
  ],
  providers: [
    ServiceService,
    Logged,
    PermissoesService,
    AuthGuardService,
    {provide: MAT_DATE_LOCALE, useValue: 'pt-BR'},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
