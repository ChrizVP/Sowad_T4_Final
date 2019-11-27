import { TestBed } from '@angular/core/testing';

import { CotizacionnewService } from './cotizacionnew.service';

describe('CotizacionnewService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CotizacionnewService = TestBed.get(CotizacionnewService);
    expect(service).toBeTruthy();
  });
});
