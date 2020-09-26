import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CasCentroAtendimentoSocialComponent } from './cas-centro-atendimento-social.component';

describe('CasCentroAtendimentoSocialComponent', () => {
  let component: CasCentroAtendimentoSocialComponent;
  let fixture: ComponentFixture<CasCentroAtendimentoSocialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CasCentroAtendimentoSocialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CasCentroAtendimentoSocialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
