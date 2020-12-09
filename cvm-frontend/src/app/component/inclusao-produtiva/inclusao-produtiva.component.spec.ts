import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InclusaoProdutivaComponent } from './inclusao-produtiva.component';

describe('InclusaoProdutivaComponent', () => {
  let component: InclusaoProdutivaComponent;
  let fixture: ComponentFixture<InclusaoProdutivaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InclusaoProdutivaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InclusaoProdutivaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
