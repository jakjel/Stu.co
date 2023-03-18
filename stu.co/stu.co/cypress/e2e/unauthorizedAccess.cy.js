describe('Unauthorized access', () => {
    it('Unauthorized', function () {
      cy.visit('http://localhost:3000')
      cy.visit('http://localhost:3000/admin')
  
      cy.get('.dashboard').should('contain', 'You have no permission to be here :(')
    })
  })