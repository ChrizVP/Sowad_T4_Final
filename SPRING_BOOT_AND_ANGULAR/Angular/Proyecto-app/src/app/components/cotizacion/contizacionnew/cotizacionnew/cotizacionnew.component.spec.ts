import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CotizacionnewComponent } from './cotizacionnew.component';

describe('CotizacionnewComponent', () => {
  let component: CotizacionnewComponent;
  let fixture: ComponentFixture<CotizacionnewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CotizacionnewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CotizacionnewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
