import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportcotizacionComponent } from './reportcotizacion.component';

describe('ReportcotizacionComponent', () => {
  let component: ReportcotizacionComponent;
  let fixture: ComponentFixture<ReportcotizacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportcotizacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportcotizacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
