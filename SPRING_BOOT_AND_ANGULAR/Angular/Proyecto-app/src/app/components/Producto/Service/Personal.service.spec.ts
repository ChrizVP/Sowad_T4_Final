import { TestBed } from '@angular/core/testing';

import { PersonalService } from 'src/app/components/Producto/Service/Personal.service';

describe('PersonalService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PersonalService = TestBed.get(PersonalService);
    expect(service).toBeTruthy();
  });
});

